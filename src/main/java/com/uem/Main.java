package com.uem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uem.controller.OrderController;
import com.uem.model.Order;
import com.uem.view.OrderView;

import java.util.List;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            var inputStream = Main.class.getResourceAsStream("/orders.json");

            List<Order> orders = mapper.readValue(inputStream, new TypeReference<List<Order>>(){});

            for (Order order : orders) {
                log.debug("Loaded order: {}", order.getIdPedido());
            }
            
            OrderView view = new OrderView();
            new OrderController(view, orders);

        } catch (Exception e) {
            log.error("Error al procesar el archivo JSON", e);
        }
    }
}