package fcu.sep.fcushop.model;

/**this is.

 *Product.
 */


@SuppressWarnings("checkstyle:Indentation")

public class Product {

  private long id;

  private String name;

  private String imageUrl;

  private int price;

  private String description;

  private int state;

  public Product() {
  }

  /**this is.
   *Product.
   */
  public Product(long id, String name, String imageUrl, int price, String description, int state) {
    this.id = id;
    this.name = name;
    this.imageUrl = imageUrl;
    this.price = price;
    this.description = description;
    this.state = state;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }
}