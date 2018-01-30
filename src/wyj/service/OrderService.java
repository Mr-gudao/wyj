package wyj.service;

import wyj.domain.Order;

import java.util.List;

/**
 * Create by wdb on 2018/1/22 9:26
 */

public interface OrderService {

//    确认付款加入订单
    int insertIntoOrder(Order order);

//    根据商品状态查询商品信息
    List<Order> selectOrderByGoodsStatus(Order order);

//    改变订单商品状态
    int updateOrderStatus(Order order);
}
