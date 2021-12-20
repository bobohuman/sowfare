package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

import java.util.List;

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

  public List<User> getUsers(String password) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name, ACCOUNT account, PASSWORD password"
          + " from product where password like :password";

      return connection.createQuery(query)
          .addParameter("password", password)
          .executeAndFetch(User.class);
    }
  }
}
