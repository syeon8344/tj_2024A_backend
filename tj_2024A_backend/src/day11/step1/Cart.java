package day11.step1;

public class Cart {
    private int cartCode;
    private int productCode;
    private int amount;

    public Cart(int cartCode, int productCode, int amount) {
        this.cartCode = cartCode;
        this.productCode = productCode;
        this.amount = amount;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
