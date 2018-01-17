package wyj.service;

import wyj.domain.Goods;
import wyj.domain.Shopping_cart;

import java.util.List;

/**
 * Create by wdb on 2018/1/13 21:10
 */

public interface ShoppingCartService {

    //插入临时数据
    int insertIntoShoppingCart(Shopping_cart shopping_cart);

    //插入数据到购物车
    int insertIntoShoppingCartFinal(Shopping_cart shopping_cart);

    //根据用户名查询该用户的购物车信息
    List<Shopping_cart> selectShoppingGoodsByUsername(String shopping_cart_username);

    //删除购物车内的商品
    int deleteGoodsFromCart(Shopping_cart shopping_cart);
}
