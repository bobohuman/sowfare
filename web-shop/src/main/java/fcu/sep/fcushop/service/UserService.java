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


  public String addUsers(int id,String name,String gmail,String account,String password) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query=String.format("INSERT INTO `fcu_shop`.`user` (`id`, `name`, `gmail`, `account`, `password`) VALUES (%d,'%s','%s',%s,'%s');", id,name,gmail,account,password);
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
