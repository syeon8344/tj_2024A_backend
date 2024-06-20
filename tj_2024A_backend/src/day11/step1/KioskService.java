package day11.step1;

import java.util.ArrayList;

public class KioskService {

    static ArrayList<Category> categoryList = new ArrayList<>();
    static ArrayList<Product> productList = new ArrayList<>();
    static ArrayList<Order> orderList = new ArrayList<>();
    static ArrayList<Cart> cartList = new ArrayList<>();

    static int cartCount = 0;

    public static boolean categoryAdd(String categoryName){
        Category c = new Category(categoryName);
        categoryList.add(c);
        return true;
    }
    public static String categoryList(){
        String cateText = "=================== 카테고리 목록 ===================";
        for (Category c : categoryList){
            cateText += ("\n카테고리코드 : " + c.getCategoryCode() + "\t카테고리명 : " + c.getCategoryName());
        }
        return cateText;
    }
    public static boolean categoryCheck(int categoryCode){
        boolean found = false;
        for (Category c : categoryList){
            if(c.getCategoryCode() == categoryCode){
                found = true;
                return found;
            }
        }
        return found;
    }
    public static void productAdd(String addProdName, int addProdPrice, int addProdCode){
        for (Category c : categoryList){
            if (c.getCategoryCode() == addProdCode) {
                Product p = new Product(addProdName, addProdPrice, addProdCode);
                productList.add(p);
            }
        }
    }
    public static String showProductList(){
        String prodText = "=================== 제품 목록 ===================";
        for (Category c : categoryList) {
            prodText += "\n>>" + c.getCategoryName() + " 카테고리 제품목록 -";
            for (Product p : productList){
                if (p.getCategoryCode() == c.getCategoryCode()){
                    prodText += ("\n제품코드 : " + p.getProductCode() + "\t제품명 : " + p.getProductName() + "\t제품가격 : " + p.getProductPrice());
                }
            }
        }
        return prodText;
    }
    public void cartAdd(){}
    public void cartList(){}
    public void orderAdd(){}
    public void orderList(){}

}
