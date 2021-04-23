import com.lt.test.entity.OrderItem;
import com.lt.test.entity.OrderItemEntity;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lt
 * @date 2021/4/19 12:05
 */
public class OrderItemTest {

    @Test
    public void test01(){
        OrderItemEntity itemEntity = new OrderItemEntity();
        itemEntity.setId(1L);
        OrderItem orderItem = new OrderItem();
        orderItem.setAsc(false);
        orderItem.setColumn("id");
        new ArrayList<>().add(new OrderItem("id",false));
        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        itemEntity.orders.add(orderItem);
//        itemEntity.setOrders().add(orderItem);
        System.out.println(itemEntity);
    }
}
