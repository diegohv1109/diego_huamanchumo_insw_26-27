package com.uem.view;

import javax.swing.*;
import com.uem.model.Article;
import com.uem.model.Order;
import java.awt.*;

public class OrderView extends JFrame {
    private JTextField searchField = new JTextField(10);
    private JButton searchButton = new JButton("Search");
    private JTextArea resultArea = new JTextArea(10, 40);

    public OrderView() {
        setTitle("Order Management");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Order ID:"));
        add(searchField);
        add(searchButton);
        add(new JScrollPane(resultArea));

        pack();
        setVisible(true);
    }

    public String getSearchId() {
        return searchField.getText().trim();
    }

    public JButton getSearchButton() {
        return searchButton;
    }

    public void displayOrder(Order order) {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ").append(order.getIdPedido()).append(":\n");

        for (Article a : order.getArticulos()) {
            sb.append(a.getNombre())
              .append(" x").append(a.getCantidad())
              .append(" @ ").append(a.getPrecio()).append("$")
              .append(" (discount ").append(a.getDescuento()).append("%)")
              .append(" = ").append(a.getDiscountedAmount()).append("$\n");
        }

        sb.append("Gross total: ").append(order.getGrossTotal()).append("$\n");
        sb.append("Discounted total: ").append(order.getDiscountedTotal()).append("$\n");

        resultArea.setText(sb.toString());
    }

    public void displayMessage(String message) {
        resultArea.setText(message);
    }
}