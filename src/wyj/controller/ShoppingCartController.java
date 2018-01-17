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
     *
     * @param shopping_cart
     * @param username
     * @param response
     * @return
     *
     * 进入购物车时存储的临时数据(需要存储购买的商品所以信息和用户信息)
     */
    @RequestMapping("insertIntoShoppingCart")
    @ResponseBody
    public boolean insertIntoShoppingCart(Shopping_cart shopping_cart ,
                                          @Param("goods_counts") int goods_counts,
                                          @Param("user_name") String username,
                                          HttpServletResponse response) {
        boolean result=false;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Goods goods=
                goodsServiceImp.selectGoodsByGoodsCode(shopping_cart.getShopping_cart_goods_code());
        Shopping_cart shopping_cart1=
                new Shopping_cart(username,goods.getGoods_code(),goods.getGoods_name(),goods.getDiscounted_price(),goods.getSpecifications(),goods_counts,goods.getGoods_count());
        int insertIntoShoppingCart =
                shoppingCartServiceImp.insertIntoShoppingCart(shopping_cart1);
        if (insertIntoShoppingCart!=0){
            result=true;
        }

        return true;
    }

    /**
     *
     * @param shopping_cart
     * @param username
     * @param goods_counts
     * @param totalPrice
     * @param response
     * @return
     *
     * 退出购物车时更新的最终数据（需要存储所有的商品信息和购买数量，价格，总价格）
     */
    @RequestMapping("updateShoppingCartFinal")
    @ResponseBody
    public boolean updateShoppingCartFinal(Shopping_cart shopping_cart ,
                                          @Param("user_name") String username,
                                          @Param("goods_counts") int goods_counts,
                                          @Param("totalPrice") double totalPrice,
                                          HttpServletResponse response){

        boolean result=false;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        Goods goods=
            goodsServiceImp.selectGoodsByGoodsCode(shopping_cart.getShopping_cart_goods_code());
        Shopping_cart shopping_cart1=
                new Shopping_cart(username,goods.getGoods_code(),goods_counts,totalPrice);
        int insertIntoShoppingCart=
        shoppingCartServiceImp.insertIntoShoppingCartFinal(shopping_cart1);
        if (insertIntoShoppingCart!=0){
            result=true;
        }
        return result;
    }

    /**
     * 根据用户名查询该用户的购物车信息
     * @param shopping_cart_username
     * @return
     */

    @RequestMapping("/selectShoppingGoods")
    @ResponseBody
    public List<Shopping_cart> selectShoppingGoodsByUsername(@Param("shopping_cart_username") String shopping_cart_username){
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
}
