package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField lengthField;
    private JTextField costField;
    private JTextField directorField;
    private JTextField artistField;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
    }

    @Override
	protected
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(50);

        JLabel categoryLabel = new JLabel("Category:");
        categoryField = new JTextField(50);

        JLabel lengthLabel = new JLabel("Length:");
        lengthField = new JTextField(50);

        JLabel costLabel = new JLabel("Cost:");
        costField = new JTextField(50);

        JLabel directorLabel = new JLabel("Director:");
        directorField = new JTextField(50);

        JLabel artistLabel = new JLabel("Artist:");
        artistField = new JTextField(50);

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> addCompactDisc());

        center.add(titleLabel);
        center.add(titleField);
        center.add(categoryLabel);
        center.add(categoryField);
        center.add(lengthLabel);
        center.add(lengthField);
        center.add(costLabel);
        center.add(costField);
        center.add(directorLabel);
        center.add(directorField);
        center.add(artistLabel);
        center.add(artistField);
        center.add(addButton);

        return center;
    }

    private void addCompactDisc() {
        String title = titleField.getText();
        String category = categoryField.getText();
        int length = Integer.parseInt(lengthField.getText());
        float cost = Float.parseFloat(costField.getText());
        String[] director = directorField.getText().split(",");
        String[] artist = artistField.getText().split(",");

        CompactDisc newCD = new CompactDisc(title, category, cost);

        store.addMedia(newCD);

        JOptionPane.showMessageDialog(this, "CD added successfully!");

        new StoreManagerScreen(store);
        this.dispose();
    }

}