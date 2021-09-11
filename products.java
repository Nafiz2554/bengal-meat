 
package NewFx;

 
public class products {
     int product_id,price;
    String product_name,seller_name;

    public products(int product_id, int price, String product_name, String seller_name) {
        this.product_id = product_id;
        this.price = price;
        this.product_name = product_name;
        this.seller_name = seller_name;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
    }
     
    
}
