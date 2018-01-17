package wyj.service;

import wyj.domain.Goods;

import java.util.List;

/**
 * Create by wdb on 2018/1/12 17:23
 */

public interface GoodsService {

    //根据商品类型查找商品信息
    List<Goods> selectGoodsByGoodsType(String goods_type);

    //根据商品编号查找商品信息
    Goods selectGoodsByGoodsCode(Integer goods_code);

    //查找热门商品
    List<Goods> selectHotGoods(String prepare2);


}
