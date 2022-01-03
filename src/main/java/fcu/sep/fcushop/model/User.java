package fcu.sep.fcushop.model;
/**this is.

 *User.
 */


@SuppressWarnings("checkstyle:Indentation")

public class User {

  private int id;

  private int orderstate;

  private String orderhome;

  private int orderpay;

  private String name;

  private String gmail;

  private String account;

  private String password;

  private String home;

  private int state;

  private int orderid;


  public User() {
  }
  /**this is.
   *User.
   */
  public User(int id, int orderstate, String orderhome, int orderpay, String name,
              String gmail, String account, String password, String home, int state, int orderid) {
    this.id = id;
    this.orderstate = orderstate;
    this.orderhome = orderhome;
    this.orderpay = orderpay;
    this.name = name;
    this.gmail = gmail;
    this.account = account;
    this.password = password;
    this.home = home;
    this.state = state;
    this.orderid = orderid;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getOrderstate() {
    return orderstate;
  }

  public void setOrderstate(int orderstate) {
    this.orderstate = orderstate;
  }

  public String getOrderhome() {
    return orderhome;
  }

  public void setOrder_home(String orderhome) {
    this.orderhome = orderhome;
  }


  public int getOrderpay() {
    return  orderpay;
  }

  public void setOrderhome(int orderpay) {
    this. orderpay =  orderpay;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGmail() {
    return  gmail;
  }

  public void setGmail(String gmail) {
    this.gmail = gmail;
  }

  public String getAccount() {
    return  account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public String getPassword() {
    return  password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getHome() {
    return  home;
  }

  public void setHome(String home) {
    this.home = home;
  }

  public int getState() {
    return  state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public int getOrderid() {
    return orderid;
  }

  public void setOrderid(int orderid) {
    this.orderid = orderid;
  }


}