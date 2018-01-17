package wyj.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyj.domain.Goods;
import wyj.domain.Shopping_cart;
import wyj.mapper.ShoppingCartMapper;
import wyj.service.ShoppingCartService;

import java.util.List;

/**
 * Create by wdb on 2018/1/13 21:11
 */

@Service("shoppingCart")
public class ShoppingCartServiceImp implements ShoppingCartService {

    @Autowired
    ShoppingCartMapper shoppingCartMapper;

    @Override
    public int insertIntoShoppingCart(Shopping_cart shopping_cart) {
        return shoppingCartMapper.inertIntoShoppingCart(shopping_cart);
    }

    //插入数据到购物车
    @Override
    public int insertIntoShoppingCartFinal(Shopping_cart shopping_cart) {
        return  shoppingCartMapper.inertIntoShoppingCartFinal(shopping_cart);
    }

    //根据用户名查询购物车数据
    @Override
    public List<Shopping_cart> selectShoppingGoodsByUsername(String shopping_cart_username) {
        return shoppingCartMapper.selectShoppingGoodsByUsername(shopping_cart_username);
    }

    @Override
    public int deleteGoodsFromCart(Shopping_cart shopping_cart) {
        return shoppingCartMapper.deleteGoodsFromCart(shopping_cart);
    }
}
