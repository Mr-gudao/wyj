package wyj.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import wyj.domain.Goods;
import wyj.domain.Shopping_cart;

import java.util.List;

/**
 * Create by wdb on 2018/1/13 21:13
 */

public interface ShoppingCartMapper {

    //点击购物车时插入临时数据到购物车表
    @Insert("insert into shopping_cart(shopping_cart_username,shopping_cart_goods_code,shopping_cart_goods_name,shopping_cart_goods_currentPrice,shopping_cart_goods_specifications,shopping_cart_goods_counts,shopping_cart_goods_stock) values(#{shopping_cart_username},#{shopping_cart_goods_code},#{shopping_cart_goods_name},#{shopping_cart_goods_currentPrice},#{shopping_cart_goods_specifications},#{shopping_cart_goods_counts},#{shopping_cart_goods_stock})")
    int inertIntoShoppingCart(Shopping_cart shopping_cart);


    //退出购物车时插入最终数据到购物车表
    @Insert("update  shopping_cart set(shopping_cart_goods_counts,shopping_cart_totalPrice)" +
            "=(#{shopping_cart_goods_counts},#{shopping_cart_totalPrice} where shopping_cart_goods_code=#{shopping_cart_goods_code} and shopping_cart_username=#{shopping_cart_username})")
    int inertIntoShoppingCartFinal(Shopping_cart shopping_cart);

    //从购物车中查询添加的数据
    @Select("select *from shopping_cart where shopping_cart_username=#{shopping_cart_username} ")
    List<Shopping_cart> selectShoppingGoodsByUsername(@Param("shopping_cart_username")String shopping_cart_username);

    //删除购物车内商品
    @Delete("delete from  shopping_cart where shopping_cart_goods_code=#{shopping_cart_goods_code} and shopping_cart_username=#{shopping_cart_username}")
    int deleteGoodsFromCart(Shopping_cart shopping_cart);
}
