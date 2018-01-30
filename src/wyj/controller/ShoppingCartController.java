package wyj.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wyj.domain.Goods;
import wyj.domain.Shopping_cart;
import wyj.service.serviceImp.GoodsServiceImp;
import wyj.service.serviceImp.ShoppingCartServiceImp;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Create by wdb on 2018/1/13 21:15
 */

@Controller
@RequestMapping("/shoppingCart")
@CrossOrigin(origins = "*",maxAge = 3600)
public class ShoppingCartController {


    @Autowired
    @Qualifier("shoppingCart")
    ShoppingCartServiceImp shoppingCartServiceImp;

    @Autowired
    @Qualifier("goodsService")
    GoodsServiceImp goodsServiceImp;

    /**
     *进入购物车时存储的临时数据(需要存储购买的商品所有信息和用户信息)
     * @param shopping_cart
     * @param username
     * @param response
     * @return
     */
    @RequestMapping("insertIntoShoppingCart")
    @ResponseBody
    public boolean insertIntoShoppingCart(Shopping_cart shopping_cart ,
                                          @Param("shopping_cart_goods_counts") int shopping_cart_goods_counts,
                                          @Param("user_name") String username,
                                          HttpServletResponse response) {
        boolean result=false;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //点击加入购物车时，先检查同款商品在购物车中是否已经存在，如果已经存在，直接更新数量
        //如果不存在，直接插入新数据
        Shopping_cart shopping_cart2 =
                new Shopping_cart(username,shopping_cart.getShopping_cart_goods_code(),shopping_cart_goods_counts);

        Shopping_cart shopping_cart3 =
                shoppingCartServiceImp.selectGoodsByCodeAndUSername(shopping_cart2);
        if (shopping_cart3!=null){

            //如果不为空，更新数量即可，不插入数据
            shoppingCartServiceImp.updateShoppingGoodsCounts(shopping_cart2);

            //如果为空，直接插入新的商品数据
        }else {
            Goods goods=
                    goodsServiceImp.selectGoodsByGoodsCode(shopping_cart.getShopping_cart_goods_code());

            Shopping_cart shopping_cart1=
                    new Shopping_cart(username,goods.getGoods_code(),goods.getGoods_name(),goods.getDiscounted_price(),goods.getSpecifications(),shopping_cart_goods_counts,goods.getGoods_count(),goods.getImage_src());

            int insertIntoShoppingCart =
                    shoppingCartServiceImp.insertIntoShoppingCart(shopping_cart1);

            if (insertIntoShoppingCart!=0){
                result=true;
            }
        }
        return result;

    }

    /**
     *退出购物车时更新的最终数据（需要存储所有的商品信息和购买数量，价格，总价格）
     * @param
     * @param user_name
     * @param goods_counts
     * @param totalPrice
     * @param response
     * @return
     */
//    @RequestMapping("updateShoppingCartFinal")
//    @ResponseBody
//    public boolean updateShoppingCartFinal(@Param("goods_code")int goods_code ,
//                                          @Param("user_name") String user_name,
//                                          @Param("goods_counts") int goods_counts,
//                                          @Param("totalPrice") double totalPrice,
//                                          HttpServletResponse response){
//
//        System.out.println(goods_counts);
//        System.out.println(user_name);
//        System.out.println(goods_code);
//        System.out.println(totalPrice);
//
//        boolean result=false;
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=UTF-8");
//        Shopping_cart shopping_cart1=
//                new Shopping_cart(user_name,goods_code,goods_counts,totalPrice);
//        int updateShoppingCart=
//            shoppingCartServiceImp.updateShoppingCartFinal(shopping_cart1);
//        if (updateShoppingCart!=0){
//            result=true;
//        }
//        return result;
//    }


    /**
     * 根据用户名查询该用户的购物车信息
     * @param shopping_cart_username
     * @return
     */
    @RequestMapping("/selectShoppingGoods")
    @ResponseBody
    public List<Shopping_cart> selectShoppingGoodsByUsername(@Param("shopping_cart_username")
                                                                         String shopping_cart_username){

        List<Shopping_cart> shopping_carts =
                shoppingCartServiceImp.selectShoppingGoodsByUsername(shopping_cart_username);
       return shopping_carts;
    }
    /**
     * 从购物车中删除数据
     * @param shopping_cart
     * @return
     */
    @RequestMapping("/deleteGoods")
    @ResponseBody
    public boolean deleteGoodsFromCart(Shopping_cart shopping_cart){
        boolean result=false;
        int deleteGoodsFromCart =
                shoppingCartServiceImp.deleteGoodsFromCart(shopping_cart);
        if (deleteGoodsFromCart!=0){
            result=true;
        }
        return result;
    }

    /**
     * 删除购物车所有商品
     * @return
     */
    @RequestMapping("/deleteAllGoods")
    @ResponseBody
    public boolean deleteAllGoods(Shopping_cart shopping_cart){
        boolean result=false;

        int deleteAllGoods = shoppingCartServiceImp.deleteAllGoods(shopping_cart);

        if (deleteAllGoods!=0){
            result=true;
        }

        return result;
    }

}
