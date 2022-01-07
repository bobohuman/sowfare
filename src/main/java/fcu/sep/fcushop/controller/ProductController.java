package fcu.sep.fcushop.controller;

import fcu.sep.fcushop.model.Product;
import fcu.sep.fcushop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

  @Autowired
  ProductService productManager;

  @GetMapping("/products")
  public List<Product> getProducts() {
    System.out.println("-------------------------------------------");
    System.out.println( productManager.getProducts());
    System.out.println("-------------------------------------------");

    return productManager.getProducts();

  }

  @GetMapping("/products/{keyword}")
  public List<Product> getProducts(@PathVariable("keyword") String keyword) {
    return productManager.getProducts(keyword);
  }

  @GetMapping("/products/state/{state}")
  public List<Product> getProducts(@PathVariable("state") int state) {
    return productManager.getProducts(state);
  }
  
  @GetMapping("/products/shop/{id}")
  public List<Product> getshopProducts(@PathVariable("id") int id) {
    return productManager.getshopProducts(id);
  }

  public int getProductsCount() {
    return Integer.parseInt(String.valueOf(productManager.getProductsCount()));
  }

  public int getMaxID() {
    return Integer.parseInt(String.valueOf(productManager.getMaxID()));
  }

  @GetMapping("/add/{productName}/{productUrl}/{productMoney}/{productDescription}/{productState}/{productTime}")
  public String addProducts(@PathVariable("productName") String productName, @PathVariable("productUrl") String productUrl, @PathVariable("productMoney") int productMoney, @PathVariable("productDescription") String productDescription, @PathVariable("productState") int productState, @PathVariable("productTime") int productTime) {
    return productManager.addProducts(productName,productUrl,productMoney,productDescription,productState,productTime);
  }

  @GetMapping("update/{ID}/{productName}/{productUrl}/{productMoney}/{productDescription}")
  public List<Product> updateProducts(@PathVariable("ID") int ID, @PathVariable("productName") String productName, @PathVariable("productUrl") String productUrl, @PathVariable("productMoney") String productMoney, @PathVariable("productDescription") String productDescription) {
    productManager.updateProducts(ID,productName,"https://i.imgur.com/"+productUrl,Integer.parseInt(productMoney),productDescription);
    return productManager.getProducts();
  }
  @GetMapping("/delete/{ID}")
  public List<Product> deleteProducts(@PathVariable("ID") int ID) {
    productManager.deleteProducts(ID);
    return productManager.getProducts();
  }
}


