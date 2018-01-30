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

    //检查购物车中同款商品是否已经存在
    Shopping_cart selectGoodsByCodeAndUSername(Shopping_cart shopping_cart);

    //如果商品已经存在，直接更新数量
    int updateShoppingGoodsCounts(Shopping_cart shopping_cart);

    //更新数据到购物车shopping_cart_goods_counts
//    int updateShoppingCartFinal(Shopping_cart shopping_cart);

    //根据用户名查询该用户的购物车信息
    List<Shopping_cart> selectShoppingGoodsByUsername(String shopping_cart_username);

    //点击删除时删除购物车内的商品
    int deleteGoodsFromCart(Shopping_cart shopping_cart);

    //购买成功删除购物车内所有商品
    int deleteAllGoods(Shopping_cart shopping_cart);
}
