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

  public Order() {
  }

  /**this is.
   *Order.
   */
  public Order(int id,int productId,int productCount,int productTime) {
    this.id = id;
    this.productId = productId;
    this.productCount = productCount;
    this.productTime = productTime;
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
}