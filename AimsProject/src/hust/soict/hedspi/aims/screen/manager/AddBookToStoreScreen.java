package hust.soict.hedspi.aims.screen.manager;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
// import hust.soict.hedspi.aims.media.Book; // Make sure to import your Book class

public class AddBookToStoreScreen extends AddItemToStoreScreen {

    public AddBookToStoreScreen(Store store) {
        super(store, "Add Book to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        formPanel.setMaximumSize(new Dimension(500, 200));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfCost = new JTextField();

        formPanel.add(new JLabel("Title: ", SwingConstants.RIGHT));
        formPanel.add(tfTitle);
        formPanel.add(new JLabel("Category: ", SwingConstants.RIGHT));
        formPanel.add(tfCategory);
        formPanel.add(new JLabel("Cost: ", SwingConstants.RIGHT));
        formPanel.add(tfCost);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = tfTitle.getText();
                    String category = tfCategory.getText();
                    float cost = tfCost.getText().isEmpty() ? 0 : Float.parseFloat(tfCost.getText());
                    if (title.isEmpty() || category.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin (Title, Category, Cost)!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return; // Kết thúc hàm tại đây, KHÔNG chạy xuống phần thêm vào Store nữa
                    }
                    // Replace with your actual Book Constructor
                    Book book = new Book(title, category, cost);
                    store.addMedia(book);
                    
                    JOptionPane.showMessageDialog(null, "Book added successfully!");
                    
                    tfTitle.setText("");
                    tfCategory.setText("");
                    tfCost.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        formPanel.add(new JLabel()); // Spacer
        formPanel.add(btnAdd);

        center.add(Box.createVerticalGlue());
        center.add(formPanel);
        center.add(Box.createVerticalGlue());

        return center;
    }
}