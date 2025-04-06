package com.atguigu.mr.partition3;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Demo {
    public static void main(String[] args) {
        String s = "abc";
        boolean matches = s.matches("^[a-p,A-P]*");
        System.out.println(matches);

    }
}
