package java08.morningtest;

public class TestGoods {
    public static void main(String[] args) {
//        Goods goods = new Goods();
//        goods.goodsNo = 1;
//        goods.goodsName = "小米手机";
//        goods.goodsNum = 100;
//        goods.goodsPrice = 4000;

        Type type = new Type(1,"智能手机",2);
        Goods goods = new Goods(2,"小米手机",100,4000.5,type);
//        goods.goodsType = type;
        System.out.println(goods);
        System.out.println(goods.getInfo());
//        type.typeNo = 1;
//        type.typeName = "智能手机";
//        type.typeLevel = 2;
//        String s = type.getInfo();
//        System.out.println(s);
        System.out.println(type.getInfo());
        System.out.println(type);
    }
}
