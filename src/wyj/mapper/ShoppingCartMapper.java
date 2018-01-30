package wyj.mapper;

import org.apache.ibatis.annotations.*;
import wyj.domain.Goods;
import wyj.domain.Shopping_cart;

import java.util.List;
import java.util.Map;

/**
 * Create by wdb on 2018/1/13 21:13
 */

public interface ShoppingCartMapper {

    //点击购物车时插入临时数据到购物车表
    @Insert("insert into shopping_cart(shopping_cart_username,shopping_cart_goods_code,shopping_cart_goods_name,shopping_cart_goods_currentPrice,shopping_cart_goods_specifications,shopping_cart_goods_counts,shopping_cart_goods_stock,shopping_cart_goods_image) values(#{shopping_cart_username},#{shopping_cart_goods_code},#{shopping_cart_goods_name},#{shopping_cart_goods_currentPrice},#{shopping_cart_goods_specifications},#{shopping_cart_goods_counts},#{shopping_cart_goods_stock},#{shopping_cart_goods_image})")
    int inertIntoShoppingCart(Shopping_cart shopping_cart);

    //点击加入购物车时插入临时数据前，先检查购物车中有没有相同商品，如果有，直接更新数量
    @Select("select *from shopping_cart where shopping_cart_username=#{shopping_cart_username} and shopping_cart_goods_code = #{shopping_cart_goods_code}")
    Shopping_cart selectGoodsByCodeAndUsername(Shopping_cart shopping_cart);

    //如果商品已经存在，直接更新数量
    @Update("update shopping_cart set shopping_cart_goods_counts=shopping_cart_goods_counts+#{shopping_cart_goods_counts} where shopping_cart_username=#{shopping_cart_username} and shopping_cart_goods_code = #{shopping_cart_goods_code}")
    int updateShoppingGoodsCounts(Shopping_cart shopping_cart);

    //根据用户名从购物车中查询添加的数据
    @Select("select *from shopping_cart where shopping_cart_username=#{shopping_cart_username} ")
    List<Shopping_cart> selectShoppingGoodsByUsername(@Param("shopping_cart_username")String shopping_cart_username);

    //删除购物车内商品
    @Delete("delete from  shopping_cart where shopping_cart_goods_code=#{shopping_cart_goods_code} and shopping_cart_username=#{shopping_cart_username}")
    int deleteGoodsFromCart(Shopping_cart shopping_cart);

    //删除购物车内所有商品
    @Delete("delete from shopping_cart where shopping_cart_username=#{shopping_cart_username}")
    int deleteAllGoods(Shopping_cart shopping_cart);


}
