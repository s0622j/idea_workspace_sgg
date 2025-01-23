package java08.morningtest;

public class TestGoodsTools {
    public static void main(String[] args) {
        GoodsTools goodsTools = new GoodsTools();
        // Type type = new Type(2,"智能手机",3);
        Goods goods = new Goods(1,"小米手机",100,5000.5,new Type(2,"智能手机",3));
        goodsTools.showGoods(goods);
    }
}
