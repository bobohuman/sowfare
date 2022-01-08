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



  public String addOrders(int proudctid,int count,int time,int id,int state) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query=String.format("INSERT INTO `lend_things`.`order` ( `productid`, `productcount`, `producttime`, `userid`, `state`) VALUES (%d,%d,%d,%d,%d);", proudctid,count,time,id,state);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "寫入成功";

    } catch (Exception ex)// 除了SQLException以外之錯誤
    {
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }

  public String deleteOrders(int proudctid,int id,int state) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query=String.format("DELETE FROM `lend_things`.`order` WHERE(`productid`="+ proudctid +" AND `userid`=" + id +" AND `STATE`=" + state +" );");
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "刪除成功";

    } catch (Exception ex)// 除了SQLException以外之錯誤
    {
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }

  public String updateOrders(int id,int state) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query=String.format("UPDATE `lend_things`.`order` SET STATE=2 WHERE(`userid`=" + id +" AND `STATE`=" + state +" );");
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "更新成功";

    } catch (Exception ex)// 除了SQLException以外之錯誤
    {
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
}
