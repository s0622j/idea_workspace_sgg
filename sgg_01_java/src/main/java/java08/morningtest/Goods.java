package java08.morningtest;

public class Goods {
    public int goodsNo;
    public String goodsName;
    public int goodsNum;
    public double goodsPrice;
    public Type goodsType;

    public Goods() {
    }

    public Goods(int goodsNo, String goodsName, int goodsNum, double goodsPrice, Type goodsType) {
        this.goodsNo = goodsNo;
        this.goodsName = goodsName;
        this.goodsNum = goodsNum;
        this.goodsPrice = goodsPrice;
        this.goodsType = goodsType;
    }

    public String getInfo(){
        return "商品编号："+goodsNo+"，商品名称："+goodsName+"，商品数量："
                +goodsNum+"，商品单价："+goodsPrice+"商品分类："+goodsType.getInfo();
    }
}
