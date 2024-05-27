package dao;

import model.Characters;
import model.Location;
import model.Orders;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcOrdersDaoTest extends BaseDaoTests{
    private static  final Orders order1 = new Orders(1, "nameTest1");
    private static  final Orders order2 = new Orders(2, "nameTest2");
    private static  final Orders order3 = new Orders(3, "nameTest3");


    private JdbcOrdersDao dao;

    @Before
    public void setUp() throws Exception{
        this.dao = new JdbcOrdersDao(dataSource);
    }

    @Test
    public void getOrderById() {
        Orders order = dao.getOrderById(1);
        assertOrdersMatch(order1, order);

    }

    @Test
    public void getOrders() {
        List<Orders> orders = dao.getOrders();
        Assert.assertEquals(3, orders.size());
    }

    private void assertOrdersMatch(Orders expected, Orders actual) {
        Assert.assertEquals(expected.getOrderId(), actual.getOrderId());
        Assert.assertEquals(expected.getName(), actual.getName());
    }
}