package fcu.sep.fcushop.controller;


import fcu.sep.fcushop.model.Order;
import fcu.sep.fcushop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
  @Autowired
  OrderService OrderManager;

  @GetMapping("/orders")
  public List<Order> getOrders() {
    System.out.println("-------------------------------------------");
    System.out.println( OrderManager.getOrders());
    System.out.println("-------------------------------------------");

    return OrderManager.getOrders();

  }


  @GetMapping("/orders/{id}")
  public List<Order> getOrders(@PathVariable("id") int id) {
    return OrderManager.getOrders(id);
  }
}
