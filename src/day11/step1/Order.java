package day11.step1;

import java.util.ArrayList;

import static day11.step1.OrderDetail.orderDetailCodeCount;

public class Order {
    private int orderCode;
    private String orderTime;
    public ArrayList<OrderDetail> orderDetailList;

    private static int orderCodeCount = 1;

    public Order(String orderTime) {
        this.orderCode = orderCodeCount;
        this.orderTime = orderTime;
        orderDetailList = new ArrayList<OrderDetail>();
        orderCodeCount++;
    }

    public void addOrderDetail(int productCode, int orderAmount){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailCode(orderCode);
        orderDetail.setProductCode(productCode);
        orderDetail.setOrderAmount(orderAmount);
        orderDetailList.add(orderDetail);
        orderDetailCodeCount++;
    }

    public int getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(int orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }


    @Override
    public String toString() {
        return "Order{" +
                "orderCode=" + orderCode +
                ", orderTime='" + orderTime + '\'' +
                ", orderDetailList=" + orderDetailList +
                '}';
    }
}
