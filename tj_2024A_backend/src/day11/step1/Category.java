package day11.step1;

public class Category {
    private int categoryCode;
    private String categoryName;
    private static int categoryCount = 1;

    public Category(String categoryName) {
        this.categoryCode = categoryCount;
        this.categoryName = categoryName;
        categoryCount++;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
