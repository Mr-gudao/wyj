package wyj.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wyj.domain.Goods;
import wyj.service.serviceImp.GoodsServiceImp;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Create by wdb on 2018/1/12 17:27
 */

@Controller
@RequestMapping("/goods")
@CrossOrigin(origins = "*",maxAge = 3600)
public class GoodsController {

    @Autowired
    @Qualifier("goodsService")
    GoodsServiceImp goodsServiceImp;

    /**
     *
     * @param goods
     * @param response
     * @return
     *
     * 根据商品类型查询商品信息
     */
    @RequestMapping("/selectGoodsByGoodsType")
    @ResponseBody
    public List<Goods> selectGoodsByGoodsType(Goods goods, HttpServletResponse response){

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");

        List<Goods> goodsList =
                goodsServiceImp.selectGoodsByGoodsType(goods.getGoods_type());

        return goodsList;
    }

    /**
     *
     * @param goods
     * @return
     *
     * 根据商品编号查询商品信息
     */
    @RequestMapping("/selectGoodsByGoodsCode")
    @ResponseBody
    public Goods selectGoodsByGoodsCode(Goods goods){
        Goods goodsSingle=
            goodsServiceImp.selectGoodsByGoodsCode(goods.getGoods_code());
        return goodsSingle;
    }

    /**
     *
     * @param goods
     * @param response
     * @return
     *
     * 查找首页热门商品
     */
    @RequestMapping("/selectHotGoods")
    @ResponseBody
    public List<Goods> selectHotGoods(Goods goods, HttpServletResponse response){
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=UTF-8");
        List<Goods> goodsList =
                goodsServiceImp.selectHotGoods(goods.getPrepare2());
        return goodsList;


    }

}
