package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField idField;
    private JTextField titleField;
    private JTextField categoryField;
    private JTextField costField;
    private JTextField authorsField;

    public AddBookToStoreScreen(Store store) {
        super(store);
    }

    @Override
	protected
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField(50);

        JLabel titleLabel = new JLabel("Title:");
        titleField = new JTextField(50);

        JLabel categoryLabel = new JLabel("Category:");
        categoryField = new JTextField(50);

        JLabel costLabel = new JLabel("Cost:");
        costField = new JTextField(50);

        JLabel authorsLabel = new JLabel("Authors:");
        authorsField = new JTextField(50);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> addBook());

        center.add(idLabel);
        center.add(idField);
        center.add(titleLabel);
        center.add(titleField);
        center.add(categoryLabel);
        center.add(categoryField);
        center.add(costLabel);
        center.add(costField);
        center.add(authorsLabel);
        center.add(authorsField);
        center.add(addButton);

        return center;
    }

    private void addBook() {
        int id = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String category = categoryField.getText();
        float cost = Float.parseFloat(costField.getText());
        String[] authors = authorsField.getText().split(",");

        Book newBook = new Book(title, category, cost);
        for (String author : authors) {
            newBook.addAuthor(author.trim());
        }

        store.addMedia(newBook);

        JOptionPane.showMessageDialog(this, "Book added successfully!");

        new StoreManagerScreen(store);
        this.dispose(); 
    }
}