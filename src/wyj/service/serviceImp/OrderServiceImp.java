package wyj.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyj.domain.Order;
import wyj.mapper.OrderMapper;
import wyj.service.OrderService;

import java.util.List;

/**
 * Create by wdb on 2018/1/22 10:25
 */
@Service("order")
public class OrderServiceImp implements OrderService {


    @Autowired
    OrderMapper orderMapper;

    @Override
    public int insertIntoOrder(Order order) {
        return orderMapper.insertIntoOrder(order) ;
    }

    @Override
    public List<Order> selectOrderByGoodsStatus(Order order) {
        return orderMapper.selectOrderByGoodsStatus(order);
    }

    @Override
    public int updateOrderStatus(Order order) {
        return orderMapper.updateOrderStatus(order);
    }
}
