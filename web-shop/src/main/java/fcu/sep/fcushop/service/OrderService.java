package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Order;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;


@Service
public class OrderService {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  public OrderService() {

  }
  public List<Order> getOrders() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id"
          + " from ORDER ";
      return connection.createQuery(query).executeAndFetch(Order.class);
    }
  }

  public List<Order> getOrders(int id) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {

      String query = "select ID id, product_id productId, product_count productCount"
          + " from order WHERE (id like:id) ";

      return connection.createQuery(query)
          .addParameter("id",id )
          .executeAndFetch(Order.class);
    }
  }

}
