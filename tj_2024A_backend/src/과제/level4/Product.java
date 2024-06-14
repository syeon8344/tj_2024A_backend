package 과제.level4;

public class Product {
    int productNo = 1000;
    String productName;
    int price;
    String addedDate;
    int count = 0;

    public Product(String productName, int price, String addedDate) {
        this.productName = productName;
        this.price = price;
        this.addedDate = addedDate;
        this.productNo += count;
        count++;
    }
}
