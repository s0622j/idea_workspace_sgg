package java20.test2;

import java.io.Serializable;

public class ResultInfo implements Serializable {
    private boolean flag;
    private String info;

    public ResultInfo() {
    }

    public ResultInfo(boolean flag, String info) {
        this.flag = flag;
        this.info = info;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "flag=" + flag +
                ", info='" + info + '\'' +
                '}';
    }
}
