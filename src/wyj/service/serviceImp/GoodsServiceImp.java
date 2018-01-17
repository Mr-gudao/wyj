package wyj.service.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wyj.domain.Goods;
import wyj.mapper.GoodsMapper;
import wyj.service.GoodsService;

import java.util.List;

/**
 * Create by wdb on 2018/1/12 17:25
 */

@Service("goodsService")
public class GoodsServiceImp implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;

    //根据商品类型查询商品信息
    @Override
    public List<Goods> selectGoodsByGoodsType(String goods_type) {

        return goodsMapper.selectGoodsByGoodsType(goods_type);
    }

    @Override
    public Goods selectGoodsByGoodsCode(Integer goods_code) {
        return goodsMapper.selectGoodsByGoodsCode(goods_code);
    }

    //查找热门商品
    @Override
    public List<Goods> selectHotGoods(String prepare2) {
        return goodsMapper.selectHotGoods(prepare2);
    }
}
