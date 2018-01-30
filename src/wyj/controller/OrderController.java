package wyj.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wyj.domain.Order;
import wyj.domain.Shopping_cart;
import wyj.service.serviceImp.OrderServiceImp;
import wyj.service.serviceImp.ShoppingCartServiceImp;

import java.util.Calendar;
import java.util.List;


/**
 * Create by wdb on 2018/1/22 10:30
 */
@Controller
@RequestMapping("/order")
@CrossOrigin(origins = "*",maxAge = 3600)
public class OrderController {


    @Autowired
    @Qualifier("order")
    OrderServiceImp orderServiceImp;

    @Autowired
    @Qualifier("shoppingCart")
    ShoppingCartServiceImp shoppingCartServiceImp;

    /**
     * 结算购物车，确认订单，状态待发货
     * @return
     */
    @RequestMapping("/insertIntoOrder")
    @ResponseBody
    public boolean insertIntoOrder(@Param("shopping_cart_username")String shopping_cart_username,
                                    @Param("goods_totalPrice") double goods_totalPrice,
                                   @Param("goods_remark") String goods_remark) {
        boolean result = false;
        int insertIntoOrder = 0;
        //从购物车表中查询到所有要购买的商品
        List<Shopping_cart> shopping_cartList=
            shoppingCartServiceImp.selectShoppingGoodsByUsername(shopping_cart_username);

        //循环遍历获得商品信息，并执行插入到订单表的操作
        for (int i = 0; i < shopping_cartList.size(); i++) {

//           获取订单编号
           String code=OrderController.getOrderCode();
//           获取当前时间
           String time=OrderController.getTime();
//           获取单个商品总价
           double singlePrice=shopping_cartList.get(i).getShopping_cart_goods_counts()*shopping_cartList.get(i).getShopping_cart_goods_currentPrice();


           Order order=
               new Order(code,time,
                         shopping_cart_username,
                         shopping_cartList.get(i).getShopping_cart_goods_code(),
                         shopping_cartList.get(i).getShopping_cart_goods_name(),
                         shopping_cartList.get(i).getShopping_cart_goods_currentPrice(),
                         shopping_cartList.get(i).getShopping_cart_goods_counts(),
                         shopping_cartList.get(i).getShopping_cart_goods_image(),
                         singlePrice,
                         goods_totalPrice,
                         goods_remark,
                       "待发货");
           insertIntoOrder=
            orderServiceImp.insertIntoOrder(order);
        }
        if (insertIntoOrder!=0){
            result=true;
        }

        return result;
    }

    /**
     * 根据不同的订单状态（未发货，待接收，待评价）查询不同的商品
     * @param order
     * @return
     */
    @RequestMapping("/selectOrderByStatus")
    @ResponseBody
    public List<Order> selectOrderByStatus(Order order){

        List<Order> orderList =
                orderServiceImp.selectOrderByGoodsStatus(order);
        return orderList;
    }


    /**
     * 改变商品状态
     * @param order
     * @return
     */
    @RequestMapping("/updateOrderStatus")
    @ResponseBody
    public boolean updateOrderStatus(Order order){

//    取消订单---已取消    确认收货---待评价，完成评价----已完成
        Order order1= new Order();
        order1.setOrder_code(order.getOrder_code());

        if (order.getGoods_status().equals("取消订单")){

            order1.setGoods_status("已取消");

        }else if (order.getGoods_status().equals("确认收货")){

            order1.setGoods_status("待评价");

        }else if(order.getGoods_status().equals("完成评价")){

            order1.setGoods_status("已完成");

        }

        boolean result=false;
        int updateOrderStatus=
            orderServiceImp.updateOrderStatus(order1);

    if (updateOrderStatus!=0){

        result=true;

    }

    return true;

    }
























    //获得订单编号(wjyj+年月日+四位随机数)
    public static String  getOrderCode(){

        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int mouth=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DATE);
        //获取四位随机数
//        Random random=new Random();
        int num= (int) (Math.random()*9000+1000);
        String code="wjyj"+year+(mouth+1)+day+num;
        return code;

    }

    //获得当前年月日时间
    public static String getTime(){
        Calendar calendar=Calendar.getInstance();
        int mouth=calendar.get(Calendar.MONTH);
        int day=calendar.get(Calendar.DATE);
        int h=calendar.get(Calendar.HOUR_OF_DAY);
        int s=calendar.get(Calendar.SECOND);
        String time=(mouth+1)+"-"+day+" "+h+":"+s;
        return time;
    }


}