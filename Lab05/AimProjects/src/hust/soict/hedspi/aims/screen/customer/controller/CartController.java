package hust.soict.hedspi.aims.screen.customer.controller;

import javafx.event.ActionEvent;

import java.io.IOException;

import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.cart.Cart;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {
    private Store store;
    private Cart cart;
    
    public CartController() {
    	
    }

    public void setData(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        if (tblMedia != null && cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }
        updateTotalCost();
    }

    private void updateTotalCost() {
        if (costLabel != null && cart != null) {
            float total = cart.totalCost();
            costLabel.setText(String.format("%.2f $", total));
        }
    }

    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, Integer> colMediaID;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;

    @FXML private Label costLabel;
    @FXML private ToggleGroup filterCategory;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                System.err.println("Error while playing media: " + e.getMessage());
            }
        } else {
            System.out.println("This media is not playable.");
        }
    }


    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            tblMedia.setItems(cart.getItemsOrdered()); // cập nhật bảng
            updateTotalCost(); // cập nhật tổng tiền
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
                "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml"));

            ViewStoreController viewStoreController = new ViewStoreController(store, cart);
            fxmlLoader.setController(viewStoreController);

            Parent root = fxmlLoader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Store");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        cart.clear();

        tblMedia.setItems(cart.getItemsOrdered());
        tblMedia.refresh();

        costLabel.setText("0 $");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
    }

    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            btnPlay.setVisible(media instanceof Playable);
        }
    }

    @FXML
    public void initialize() {
        colMediaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> obs, Media oldVal, Media newVal) {
                    updateButtonBar(newVal);
                }
            }
        );
    }
}
