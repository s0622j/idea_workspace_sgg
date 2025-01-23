package java08.morningtest;

public class Type {
    public int typeNo;
    public String typeName;
    public int typeLevel;

    public Type() {
    }

    public Type(int typeNo, String typeName, int typeLevel) {
        this.typeNo = typeNo;
        this.typeName = typeName;
        this.typeLevel = typeLevel;
    }

    public String getInfo(){
        return "分类编号："+typeNo+"，分类名称："
                +typeName+"，分类等级："+typeLevel;
    }
}
