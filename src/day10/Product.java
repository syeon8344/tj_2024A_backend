package day10;

public class Product {
    private String pCode;
    private String pName;
    private int pPrice;

    public Product(String prodCode, String prodName, int prodPrice) {
        this.pCode = prodCode;
        this.pName = prodName;
        this.pPrice = prodPrice;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public int getpPrice() {
        return pPrice;
    }

    public void setpPrice(int pPrice) {
        this.pPrice = pPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pCode='" + pCode + '\'' +
                ", pName='" + pName + '\'' +
                ", pPrice=" + pPrice +
                '}';
    }
}
