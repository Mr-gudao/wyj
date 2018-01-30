package wyj.domain;

import java.util.Date;

/**
 * Create by wdb on 2018/1/19 17:23
 */

public class Order {

    private int order_id;       //订单id
    private String order_code;  //订单编号
    private String order_time;    //订单时间
    private String username;    //订单商品
    private int goods_code;     //订单商品编号
    private String goods_name;  //订单商品名字
    private double goods_currentPrice;  //订单商品价格
    private int goods_counts;           //订单商品数量
    private String goods_image;
    private double goods_singlePrice;   //订单单个商品总价
    private double goods_totalPrice;    //订单所有商品总价
    private String goods_remark;        //订单商品备注
    private String goods_status;        //订单商品状态

    public Order() {
    }

    public Order(String order_code, String order_time, String username, int goods_code, String goods_name, double goods_currentPrice, int goods_counts, String goods_image, double goods_singlePrice, double goods_totalPrice, String goods_remark, String goods_status) {
        this.order_code = order_code;
        this.order_time = order_time;
        this.username = username;
        this.goods_code = goods_code;
        this.goods_name = goods_name;
        this.goods_currentPrice = goods_currentPrice;
        this.goods_counts = goods_counts;
        this.goods_image = goods_image;
        this.goods_singlePrice = goods_singlePrice;
        this.goods_totalPrice = goods_totalPrice;
        this.goods_remark = goods_remark;
        this.goods_status = goods_status;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getGoods_code() {
        return goods_code;
    }

    public void setGoods_code(int goods_code) {
        this.goods_code = goods_code;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getGoods_currentPrice() {
        return goods_currentPrice;
    }

    public void setGoods_currentPrice(double goods_currentPrice) {
        this.goods_currentPrice = goods_currentPrice;
    }

    public int getGoods_counts() {
        return goods_counts;
    }

    public void setGoods_counts(int goods_counts) {
        this.goods_counts = goods_counts;
    }

    public String getGoods_image() {
        return goods_image;
    }

    public void setGoods_image(String goods_image) {
        this.goods_image = goods_image;
    }

    public double getGoods_singlePrice() {
        return goods_singlePrice;
    }

    public void setGoods_singlePrice(double goods_singlePrice) {
        this.goods_singlePrice = goods_singlePrice;
    }

    public double getGoods_totalPrice() {
        return goods_totalPrice;
    }

    public void setGoods_totalPrice(double goods_totalPrice) {
        this.goods_totalPrice = goods_totalPrice;
    }

    public String getGoods_remark() {
        return goods_remark;
    }

    public void setGoods_remark(String goods_remark) {
        this.goods_remark = goods_remark;
    }

    public String getGoods_status() {
        return goods_status;
    }

    public void setGoods_status(String goods_status) {
        this.goods_status = goods_status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", order_code='" + order_code + '\'' +
                ", order_time='" + order_time + '\'' +
                ", username='" + username + '\'' +
                ", goods_code=" + goods_code +
                ", goods_name='" + goods_name + '\'' +
                ", goods_currentPrice=" + goods_currentPrice +
                ", goods_counts=" + goods_counts +
                ", goods_image='" + goods_image + '\'' +
                ", goods_singlePrice=" + goods_singlePrice +
                ", goods_totalPrice=" + goods_totalPrice +
                ", goods_remark='" + goods_remark + '\'' +
                ", goods_status='" + goods_status + '\'' +
                '}';
    }
}
