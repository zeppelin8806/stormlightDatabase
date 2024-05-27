package dao;

import model.Orders;

import java.util.List;

public interface OrdersDao {

    Orders getOrderById(int orderId);

    List<Orders> getOrders();
}
