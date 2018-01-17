package wyj.domain;

/**
 * Create by wdb on 2018/1/12 17:12
 */

public class Goods {

    private Integer goods_id;
    private String goods_name;
    private Integer goods_code;
    private Integer goods_count;
    private double goods_price;
    private double discounted_price;
    private Integer image_id;
    private String image_src;
    private String memo;
    private Integer delete_flag;
    private String goods_type;
    private String prepare2;
    private String provenance;
    private String specifications;

    public Goods() {
    }

    public Goods(Integer goods_id, String goods_name, Integer goods_code, Integer goods_count, double goods_price, double discounted_price, Integer image_id, String image_src, String memo, Integer delete_flag, String goods_type, String prepare2, String provenance, String specifications) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.goods_code = goods_code;
        this.goods_count = goods_count;
        this.goods_price = goods_price;
        this.discounted_price = discounted_price;
        this.image_id = image_id;
        this.image_src = image_src;
        this.memo = memo;
        this.delete_flag = delete_flag;
        this.goods_type = goods_type;
        this.prepare2 = prepare2;
        this.provenance = provenance;
        this.specifications = specifications;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(Integer goods_code) {
        this.goods_code = goods_code;
    }

    public Integer getGoods_count() {
        return goods_count;
    }

    public void setGoods_count(Integer goods_count) {
        this.goods_count = goods_count;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public double getDiscounted_price() {
        return discounted_price;
    }

    public void setDiscounted_price(double discounted_price) {
        this.discounted_price = discounted_price;
    }

    public Integer getImage_id() {
        return image_id;
    }

    public void setImage_id(Integer image_id) {
        this.image_id = image_id;
    }

    public String getImage_src() {
        return image_src;
    }

    public void setImage_src(String image_src) {
        this.image_src = image_src;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }

    public String getGoods_type() {
        return goods_type;
    }

    public void setGoods_type(String goods_type) {
        this.goods_type = goods_type;
    }

    public String getPrepare2() {
        return prepare2;
    }

    public void setPrepare2(String prepare2) {
        this.prepare2 = prepare2;
    }

    public String getProvenance() {
        return provenance;
    }

    public void setProvenance(String provenance) {
        this.provenance = provenance;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_id=" + goods_id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_code=" + goods_code +
                ", goods_count=" + goods_count +
                ", goods_price=" + goods_price +
                ", discounted_price=" + discounted_price +
                ", image_id=" + image_id +
                ", image_src='" + image_src + '\'' +
                ", memo='" + memo + '\'' +
                ", delete_flag=" + delete_flag +
                ", goods_type='" + goods_type + '\'' +
                ", prepare2='" + prepare2 + '\'' +
                ", provenance='" + provenance + '\'' +
                ", specifications='" + specifications + '\'' +
                '}';
    }
}
