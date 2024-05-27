package dao;

import model.OrdersCharacters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class JdbcOrdersCharactersDaoTest extends BaseDaoTests{
    private static final OrdersCharacters oc1 = new OrdersCharacters(1, 1, 1);
    private static final OrdersCharacters oc2 = new OrdersCharacters(2, 2, 2);
    private static final OrdersCharacters oc3 = new OrdersCharacters(3, 3, 3);

    private JdbcOrdersCharactersDao dao;

    @Before
    public void setUp() throws Exception{
        this.dao = new JdbcOrdersCharactersDao(dataSource);
    }

    @Test
    public void getOrderById() {
        List<OrdersCharacters> ordersCharacters = dao.getOrderById(1);
        Assert.assertEquals(1, ordersCharacters.size());
    }
}