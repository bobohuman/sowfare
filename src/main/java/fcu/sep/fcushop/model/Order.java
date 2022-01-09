package fcu.sep.fcushop.model;

/**this is.

 *Order.
 */


@SuppressWarnings("checkstyle:Indentation")

public class Order {

  private int id;

  private int productId;

  private int productCount;

  private int productTime;

  private int userid;

  private int state;

  public Order() {
  }

  /**this is.
   *Order.
   */
  public Order(int id, int productId, int productCount, int productTime, int userid, int state) {
    this.id = id;
    this.productId = productId;
    this.productCount = productCount;
    this.productTime = productTime;
    this.userid = userid;
    this.state = state;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public int getProductCount() {
    return productCount;
  }

  public void setProductCount(int productCount) {
    this.productCount = productCount;
  }

  public int getProductTime() {
    return productTime;
  }

  public void setProductTime(int productTime) {
    this.productTime = productTime;
  }

  public int getUserid() {
    return userid;
  }

  public void setUserid(int userid) {
    this.userid = userid;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }
}