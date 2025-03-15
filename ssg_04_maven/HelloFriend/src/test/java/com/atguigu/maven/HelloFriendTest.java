package com.atguigu.maven;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HelloFriendTest {
    @Test
    public void testHelloFriend(){
        HelloFriend helloFriend = new HelloFriend();
        String results = helloFriend.sayHelloToFriend("Maven");
        System.out.println("================================== test 结果 AA ==================================");
        assertEquals("Hello Maven! I am Idea",results);
    }

}
