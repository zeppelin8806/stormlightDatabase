package dao;
import model.OrdersCharacters;
import java.util.List;

public interface OrdersCharactersDao {
    List<OrdersCharacters> getOrderById(int orderId);

}
