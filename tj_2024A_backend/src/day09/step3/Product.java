package day09.step3;

public class Product {
    private String prodCode;
    private String prodName;
    private int prodPrice;

    public Product(String prodCode, String prodName, int prodPrice) {
        this.prodCode = prodCode;
        this.prodName = prodName;
        this.prodPrice = prodPrice;
    }

    public String getProdCode() {
        return prodCode;
    }

    public void setProdCode(String prodCode) {
        this.prodCode = prodCode;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public int getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(int prodPrice) {
        this.prodPrice = prodPrice;
    }
}
