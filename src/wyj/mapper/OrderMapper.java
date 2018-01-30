package wyj.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import wyj.domain.Order;

import java.util.List;

/**
 * Create by wdb on 2018/1/19 17:36
 */

public interface OrderMapper {

    //购物车确认订单之后插入订单商品信息(确认，但未发货)
    @Insert("insert into `order` ( order_code,order_time,username,goods_code,goods_name,goods_currentPrice,goods_counts,goods_image,goods_singlePrice,goods_totalPrice,goods_remark,goods_status) values (#{order_code},#{order_time},#{username},#{goods_code},#{goods_name},#{goods_currentPrice},#{goods_counts},#{goods_image},#{goods_singlePrice},#{goods_totalPrice},#{goods_remark},#{goods_status})")
    int insertIntoOrder(Order order);

    //根据商品状态(未发货，待接收，待评价，已完成，已取消)查询商品信息
    @Select("select *from `order` where goods_status=#{goods_status} and username=#{username} ")
    List<Order> selectOrderByGoodsStatus(Order order) ;

    //改变商品订单的状态（根据商品订单和商品状态）
    @Update("update `order` set goods_status = #{goods_status} where order_code=#{order_code}")
    int updateOrderStatus(Order order);

}
