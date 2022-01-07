package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Order;
import java.util.List;

import fcu.sep.fcushop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;


@Service
public class OrderService {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;


  public List<Order> getOrders() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select id id ,productId productId,productCount productCount,productTime productTime"
          + " FROM `lend_things`.`order`; ";
      return connection.createQuery(query).executeAndFetch(Order.class);
    }
  }

  public List<Order> getOrders(int userid,int state) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {

      String query = "select ID id,productId productId,productCount productCount,productTime productTime,userid userid,STATE state"
          + " from `lend_things`.`order` WHERE (`userid`="+ userid +" AND `STATE`=" + state +");";

      return connection.createQuery(query)
          .executeAndFetch(Order.class);
    }
  }
}
