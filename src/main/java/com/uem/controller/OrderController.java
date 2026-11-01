package com.uem.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uem.Searcher;
import com.uem.model.Order;
import com.uem.view.OrderView;

public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private OrderView view;
    private List<Order> orders;
    private Searcher searcher;

    public OrderController(OrderView view, List<Order> orders) {
        this.view = view;
        this.orders = orders;
        this.searcher = new Searcher();

        view.getSearchButton().addActionListener(e -> searchOrder());
    }

    private void searchOrder() {
        String id = view.getSearchId();
        log.debug("Searching order {}", id);

        List<String> ids = orders.stream()
                .map(Order::getIdPedido)
                .collect(Collectors.toList());

        if (searcher.searchWord(id, ids)) {
            Order found = orders.get(ids.indexOf(id));
            view.displayOrder(found);
        } else {
            view.displayMessage("Order not found.");
        }
    }
}