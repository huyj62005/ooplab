package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.exception.LimitExceededException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {
	private Cart cart;

	public void setCart(Cart cart) {
	    this.cart = cart;
	}
    private Media media;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        try {
            cart.addMedia(media);  
            System.out.println("Added to cart: " + media.getTitle());
        } catch (LimitExceededException e) {
            System.err.println("Cannot add to cart: " + e.getMessage());
        }
    }


    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media instanceof Playable) {
            System.out.println("Playing: " + media.getTitle());

            // Gọi phương thức play
            try {
                ((Playable) media).play();
            } catch (Exception e) {
                System.err.println("Error while playing: " + e.getMessage());
            }
        }
    }


    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;

        lblTitle.setText(media.getTitle());
        lblCost.setText(String.format("%.2f $", media.getCost()));

        if (media instanceof Playable) {
            btnPlay.setVisible(true);
        } else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }

    }
    

    }
