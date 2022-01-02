package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;


@Service
public class UserService {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;


  public List<User> getUsers() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name,  PASSWORD password"
          + " from USER ";
      return connection.createQuery(query).executeAndFetch(User.class);
    }
  }

  public List<User> getUsers(String account) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {

      String query = "select ID id, NAME name, ACCOUNT account, PASSWORD password"
          + " from user WHERE (account like:account) ";

      return connection.createQuery(query)
          .addParameter("account",account )
          .executeAndFetch(User.class);
    }
  }
  public List<User> getUsers(String account,String password) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {

      String query = "select ID id, NAME name, ACCOUNT account, PASSWORD password"
          + " from user WHERE (Password like:password) AND (Account like:account) ";

      return connection.createQuery(query)
          .addParameter("account",account )
          .addParameter("password",password )
          .executeAndFetch(User.class);
    }
  }
  public String getUsers(String name,String gmail,String account,String password) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query=String.format("INSERT INTO `fcu_shop`.`user` ( `name`, `gmail`, `account`, `password`) VALUES ('%s','%s','%s','%s');", name,gmail,account,password);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "寫入成功";

    } catch (Exception ex)// 除了SQLException以外之錯誤
    {
      returnMessage = "錯誤訊息:" + ex.getMessage();
    }
    return returnMessage;
  }
}
