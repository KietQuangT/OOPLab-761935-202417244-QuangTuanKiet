package hust.soict.hedspi.aims.screen.manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store, "Add DVD to Store");
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));
        
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        formPanel.setMaximumSize(new Dimension(500, 300));

        JTextField tfTitle = new JTextField();
        JTextField tfCategory = new JTextField();
        JTextField tfDirector = new JTextField();
        JTextField tfLength = new JTextField();
        JTextField tfCost = new JTextField();

        formPanel.add(new JLabel("Title: ", SwingConstants.RIGHT));
        formPanel.add(tfTitle);
        formPanel.add(new JLabel("Category: ", SwingConstants.RIGHT));
        formPanel.add(tfCategory);
        formPanel.add(new JLabel("Director: ", SwingConstants.RIGHT));
        formPanel.add(tfDirector);
        formPanel.add(new JLabel("Length: ", SwingConstants.RIGHT));
        formPanel.add(tfLength);
        formPanel.add(new JLabel("Cost: ", SwingConstants.RIGHT));
        formPanel.add(tfCost);

        JButton btnAdd = new JButton("Add DVD");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = tfTitle.getText();
                    String category = tfCategory.getText();
                    String director = tfDirector.getText();
                    int length = tfLength.getText().isEmpty() ? 0 : Integer.parseInt(tfLength.getText());
                    float cost = tfCost.getText().isEmpty() ? 0 : Float.parseFloat(tfCost.getText());
                    if (title.isEmpty() || category.isEmpty() || director.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin (Title, Category, Cost)!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return; // Kết thúc hàm tại đây, KHÔNG chạy xuống phần thêm vào Store nữa
                    }
                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                    store.addMedia(dvd);
                    
                    JOptionPane.showMessageDialog(null, "DVD added successfully!");
                    
                    // Clear inputs
                    tfTitle.setText("");
                    tfCategory.setText("");
                    tfDirector.setText("");
                    tfLength.setText("");
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