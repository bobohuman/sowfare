package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Order;
import fcu.sep.fcushop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *RestController.
 */
@RestController
public class OrderController {
  @Autowired
  OrderService orderManager;

  /**
   *GetMapping.
   */

  @GetMapping("/orders")
  public List<Order> getOrders() {
    System.out.println("-------------------------------------------");
    System.out.println(orderManager.getOrders());
    System.out.println("-------------------------------------------");

    return orderManager.getOrders();
  }


  @GetMapping("/orders/{userid}/{state}")
  public List<Order> getOrders(@PathVariable("userid") int userid,@PathVariable("state") int state) {
    return orderManager.getOrders(userid,state);
  }

  @GetMapping("/orders/{proid}/{procount}/{protime}/{uid}/{state}")
  public String addProducts(@PathVariable("proid") int proid, @PathVariable("procount") int procount,
   @PathVariable("protime") int protime, @PathVariable("uid") int uid, @PathVariable("state") int state) {
    return orderManager.addOrders(proid,procount,protime,uid,state);
  }

  @GetMapping("/orderdelte/{proid}/{uid}/{state}")
  public String  getOrders(@PathVariable("proid") int proid, @PathVariable("uid") int uid, @PathVariable("state") int state) {
    return orderManager.deleteOrders(proid,uid,state);
  }

  @GetMapping("/orderupdate/{uid}/{state}")
  public String  getStrings(@PathVariable("uid") int uid, @PathVariable("state") int state) {
    return orderManager.updateOrders(uid,state);
  }
}
