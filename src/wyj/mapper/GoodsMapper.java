package wyj.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import wyj.domain.Goods;

import java.util.List;

/**
 * Create by wdb on 2018/1/12 17:20
 */

public interface GoodsMapper {

    //根据商品编号查询商品信息
    @Select("select *from goods where goods_code=#{goods_code}")
    Goods selectGoodsByGoodsCode(@Param("goods_code")Integer goods_code);

    //根据商品类型查找到商品信息
    @Select("select *from goods where goods_type=#{goods_type}")
    List<Goods> selectGoodsByGoodsType(@Param("goods_type") String goods_type);

    //查找热门商品
    @Select("select *from goods where prepare2=#{prepare2}")
    List<Goods> selectHotGoods(@Param("prepare2") String prepare2);


}
