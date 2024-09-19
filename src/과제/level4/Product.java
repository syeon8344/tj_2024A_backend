package 과제.level4;

public class Product {
    static int productNoCount = 1000;
    String productName;
    int price;
    String addedDate;
    int productNo;

    public Product(String productName, int price, String addedDate) {
        this.productName = productName;
        this.price = price;
        this.addedDate = addedDate;
        this.productNo = productNoCount;
        productNoCount++;

    }

    public int getProductNo() {
        return productNo;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

}
