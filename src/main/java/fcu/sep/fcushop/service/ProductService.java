package fcu.sep.fcushop.service;

import fcu.sep.fcushop.database.Sql2oDbHandler;
import fcu.sep.fcushop.model.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sql2o.Connection;

/**this.
 *
 * @Service.
 */

@Service
public class ProductService {

  @Autowired
  private Sql2oDbHandler sql2oDbHandler;

  public ProductService() {

  }
  /**this.
   *
   * @Service.
   */

  public List<Product> getProducts() {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price, D"
              + "ESCRIPTION description,STATE state,TIME time"
              + " from product ";
      return connection.createQuery(query).executeAndFetch(Product.class);
    }
  }

  /**this.
   *
   * @Service.
   */

  public List<Product> getProducts(String keyword) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price, DESCRI"
              + "PTION description,TIME time"
              + " from product where name like :keyword";

      return connection.createQuery(query)
      .addParameter("keyword", "%" + keyword + "%")
      .executeAndFetch(Product.class);
    }
  }

  /**this.
   *
   * @Service.
   */

  public List<Product> getProducts(int state) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price, DESCRIPTION descri"
              + "ption,STATE state,TIME time"
              + " from product where state like :state";

      return connection.createQuery(query)
          .addParameter("state", state)
          .executeAndFetch(Product.class);
    }
  }

  /**this.
   *
   * @Service.
   */

  public List<Product> getshopProducts(int id) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price, DESCRIPTION d"
              + "escription,TIME time,SELLER seller"
              + " from product where id like :id";

      return connection.createQuery(query)
          .addParameter("id", id)
          .executeAndFetch(Product.class);
    }
  }

  /**this.
   *
   * @Service.
   */

  public List<Product> getSeller(int seller) {
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = "select ID id, NAME name, IMAGE_URL imageUrl, PRICE price, DESCRIPTION descr"
              + "iption,TIME time,SELLER seller"
              + " from `lend_things`.`product` WHERE (`SELLER`=" + seller + ");";
      return connection.createQuery(query)
          .executeAndFetch(Product.class);
    }
  }
  /**this.
   *
   * @Service.
   */

  public String addProducts(String NAME, String IMAGE_URL, int PRICE, String
          DESCRIPTION, int STATE, int TIME, int SELLER) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("INSERT INTO `lend_things`.`product` ( `NAME`, `I"
                      + "MAGE_URL`, `PRICE`, `DESCRIPTION`,"
              + " `STATE`, `TIME`,`SELLER`) VALUES ('%s','%s',%d,'%s',%d,%d,%d"
              + ");", NAME, IMAGE_URL, PRICE, DESCRIPTION, STATE, TIME, SELLER);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "????????????";

    } catch (Exception ex) {
      returnMessage = "????????????:" + ex.getMessage();
    }
    return returnMessage;
  }

  /**this.
   *
   * @Service.
   */

  public String deleteProducts(int ID) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("DELETE FROM `lend_things`.`product` WHERE (`ID` = '%d');", ID);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "????????????";
    } catch (Exception ex) {
      returnMessage = "????????????:" + ex.getMessage();
    }
    return returnMessage;
  }

  /**this.
   *
   * @Service.
   */

  public String updateProducts(int ID, String NAME, String IMAGE_URL,
                               int PRICE, String DESCRIPTION) {
    String returnMessage;
    try (Connection connection = sql2oDbHandler.getConnector().open()) {
      String query = String.format("UPDATE `lend_things`.`product` SET `NAME` = '%s'"
              + ", `IMAGE_URL` = '%s', `PRICE` = '%d', `DESCRIPTION` = '%s' WHERE (`ID` = '%d'"
              + "); ", NAME, IMAGE_URL, PRICE, DESCRIPTION);
      System.out.println(query);
      connection.createQuery(query, true).executeUpdate().getKey();
      returnMessage = query + "????????????";
    } catch (Exception ex) {
      returnMessage = "????????????:" + ex.getMessage();
    }
    return returnMessage;
  }
}

//UPDATE `fcu_shop`.`product` SET `NAME` = '??????????????????', `IMAGE_URL` = 'https://i.imgur.com/4gtlSqT.png', `PRICE` = '66', `DESCRIPTION` = '??????????????????????????????????????????' WHERE (`ID` = '5');