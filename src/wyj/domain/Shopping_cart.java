package wyj.domain;

/**
 * Create by wdb on 2018/1/13 21:09
 */

public class Shopping_cart {

    private int shopping_cart_id;  //购物车id
    private String  shopping_cart_username; //购物车用户名
    private int shopping_cart_goods_code;   //购物车商品编号
    private String shopping_cart_goods_name;    //购物车商品名
    private double shopping_cart_goods_currentPrice; //购物车商品当前价格
    private String shopping_cart_goods_specifications;  //购物车商品规格
    private int shopping_cart_goods_counts; //购物车商品数量
    private double shopping_cart_singleGoodsTotalPrice; //购物车单个商品总价格
    private double shopping_cart_totalPrice;    //购物车商品总价格
    private int shopping_cart_goods_stock;  //购物车商品库存
    private String shopping_cart_goods_image; //购物车商品图片

    public Shopping_cart() {
    }

    public Shopping_cart(String shopping_cart_username, int shopping_cart_goods_code, int shopping_cart_goods_counts) {
        this.shopping_cart_username = shopping_cart_username;
        this.shopping_cart_goods_code = shopping_cart_goods_code;
        this.shopping_cart_goods_counts = shopping_cart_goods_counts;
    }

    public Shopping_cart(String shopping_cart_username, int shopping_cart_goods_code, int shopping_cart_goods_counts, double shopping_cart_totalPrice) {

        this.shopping_cart_username = shopping_cart_username;
        this.shopping_cart_goods_code = shopping_cart_goods_code;
        this.shopping_cart_goods_counts = shopping_cart_goods_counts;
        this.shopping_cart_totalPrice = shopping_cart_totalPrice;

    }

    public Shopping_cart(String shopping_cart_username, int shopping_cart_goods_code, String shopping_cart_goods_name, double shopping_cart_goods_currentPrice, String shopping_cart_goods_specifications, int shopping_cart_goods_counts, int shopping_cart_goods_stock,String shopping_cart_goods_image) {
        this.shopping_cart_username = shopping_cart_username;
        this.shopping_cart_goods_code = shopping_cart_goods_code;
        this.shopping_cart_goods_name = shopping_cart_goods_name;
        this.shopping_cart_goods_currentPrice = shopping_cart_goods_currentPrice;
        this.shopping_cart_goods_specifications = shopping_cart_goods_specifications;
        this.shopping_cart_goods_counts = shopping_cart_goods_counts;
        this.shopping_cart_goods_stock = shopping_cart_goods_stock;
        this.shopping_cart_goods_image=shopping_cart_goods_image;
    }

    public int getShopping_cart_id() {
        return shopping_cart_id;
    }

    public void setShopping_cart_id(int shopping_cart_id) {
        this.shopping_cart_id = shopping_cart_id;
    }

    public String getShopping_cart_username() {
        return shopping_cart_username;
    }

    public void setShopping_cart_username(String shopping_cart_username) {
        this.shopping_cart_username = shopping_cart_username;
    }

    public int getShopping_cart_goods_code() {
        return shopping_cart_goods_code;
    }

    public void setShopping_cart_goods_code(int shopping_cart_goods_code) {
        this.shopping_cart_goods_code = shopping_cart_goods_code;
    }

    public String getShopping_cart_goods_name() {
        return shopping_cart_goods_name;
    }

    public void setShopping_cart_goods_name(String shopping_cart_goods_name) {
        this.shopping_cart_goods_name = shopping_cart_goods_name;
    }

    public double getShopping_cart_goods_currentPrice() {
        return shopping_cart_goods_currentPrice;
    }

    public void setShopping_cart_goods_currentPrice(double shopping_cart_goods_currentPrice) {
        this.shopping_cart_goods_currentPrice = shopping_cart_goods_currentPrice;
    }

    public String getShopping_cart_goods_specifications() {
        return shopping_cart_goods_specifications;
    }

    public void setShopping_cart_goods_specifications(String shopping_cart_goods_specifications) {
        this.shopping_cart_goods_specifications = shopping_cart_goods_specifications;
    }

    public int getShopping_cart_goods_counts() {
        return shopping_cart_goods_counts;
    }

    public void setShopping_cart_goods_counts(int shopping_cart_goods_counts) {
        this.shopping_cart_goods_counts = shopping_cart_goods_counts;
    }

    public double getShopping_cart_singleGoodsTotalPrice() {
        return shopping_cart_singleGoodsTotalPrice;
    }

    public void setShopping_cart_singleGoodsTotalPrice(double shopping_cart_singleGoodsTotalPrice) {
        this.shopping_cart_singleGoodsTotalPrice = shopping_cart_singleGoodsTotalPrice;
    }

    public double getShopping_cart_totalPrice() {
        return shopping_cart_totalPrice;
    }

    public void setShopping_cart_totalPrice(double shopping_cart_totalPrice) {
        this.shopping_cart_totalPrice = shopping_cart_totalPrice;
    }

    public int getShopping_cart_goods_stock() {
        return shopping_cart_goods_stock;
    }

    public void setShopping_cart_goods_stock(int shopping_cart_goods_stock) {
        this.shopping_cart_goods_stock = shopping_cart_goods_stock;
    }

    public String getShopping_cart_goods_image() {
        return shopping_cart_goods_image;
    }

    public void setShopping_cart_goods_image(String shopping_cart_goods_image) {
        this.shopping_cart_goods_image = shopping_cart_goods_image;
    }

    @Override
    public String toString() {
        return "shopping_cart{" +
                "shopping_cart_id=" + shopping_cart_id +
                ", shopping_cart_username='" + shopping_cart_username + '\'' +
                ", shopping_cart_goods_code=" + shopping_cart_goods_code +
                ", shopping_cart_goods_name='" + shopping_cart_goods_name + '\'' +
                ", shopping_cart_goods_currentPrice=" + shopping_cart_goods_currentPrice +
                ", shopping_cart_goods_specifications='" + shopping_cart_goods_specifications + '\'' +
                ", shopping_cart_goods_counts=" + shopping_cart_goods_counts +
                ", shopping_cart_singleGoodsTotalPrice=" + shopping_cart_singleGoodsTotalPrice +
                ", shopping_cart_totalPrice=" + shopping_cart_totalPrice +
                ", shopping_cart_goods_stock=" + shopping_cart_goods_stock +
                '}';
    }
}
