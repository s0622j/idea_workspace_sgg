package com.atguigu.zk;


import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * ZK的Java客户端
 * 1. 获取和ZK的连接对象
 * 2. 操作各种API
 * 3. 关闭资源
 */
public class TestZkClient {

    private ZooKeeper zk;


    /**
     *
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void testDeleteAll() throws KeeperException, InterruptedException {
        testDeleteNodes("/sanguo", zk);
    }
    /**
     * 递归删除非空节点
     * @param path
     * @param zk
     * @throws KeeperException
     * @throws InterruptedException
     */
    public void testDeleteNodes(String path, ZooKeeper zk) throws KeeperException, InterruptedException {
        Stat stat = zk.exists(path, false);
        if(stat != null){
            System.out.println("/sanguo 存在");
            // 先获取子节点
            List<String> children = zk.getChildren(path, false);
            if(children != null){
                // 递归删除
                for (String child : children) {
                    // 先删除子节点
                    testDeleteNodes(path + "/" + child, zk);
                }
                zk.delete(path, -1);
            }else {
                // 删除自己
                zk.delete(path,-1);
            }
        }else {
            System.out.println("/sanguo 不存在");
        }
    }

    /**
     * 测试删除空节点的值
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void testDelete() throws KeeperException, InterruptedException {
        String path = "/sanguo";
        Stat stat = zk.exists(path, false);
        if(stat != null){
            System.out.println("/sanguo 存在");
            // 删除空节点
            zk.delete(path, stat.getVersion());
        }else {
            System.out.println("/sanguo 不存在");
        }
    }

    @Test
    public void testSetData() throws KeeperException, InterruptedException {
        String path = "/sanguo";
        Stat stat = zk.exists("/sanguo", false);
        if(stat != null){
            System.out.println("/sanguo 存在");
            zk.setData(path, "yizhou".getBytes(), stat.getVersion());
        }else {
            System.out.println("/sanguo 不存在");
        }
    }


    /**
     * 获取子节点的数据
     * @throws KeeperException
     * @throws InterruptedException
     */
    @Test
    public void testGetData() throws KeeperException, InterruptedException {
        String path = "/sanguo";
        Stat stat = zk.exists("/sanguo", false);
        if(stat != null){
            System.out.println("/sanguo 存在");
            byte[] bytes = zk.getData(path, false, stat);
            System.out.println(new String(bytes));
        }else {
            System.out.println("/sanguo 不存在");
        }
    }


    /**
     * 判断节点是否存在
     */
    @Test
    public void testIsExists() throws KeeperException, InterruptedException {
        Stat stat = zk.exists("/sanguo1", false);
        if(stat != null){
            System.out.println("/sanguo 存在");
        }else {
            System.out.println("/sanguo 不存在");
        }
    }


    /**
     * 获取子节点
     */
    @Test
    public void testLsNode() throws KeeperException, InterruptedException {
        List<String> children = zk.getChildren("/sanguo", new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println("监听到/sanguo节点有变化！！！");
            }
        });

        for (String child : children) {
            System.out.println(child);
        }

        Thread.sleep(Long.MAX_VALUE);
    }


    /**
     * 创建节点
     */
    @Test
    public void testCreateNode() throws KeeperException, InterruptedException {
        String nodePath = zk.create("/sanguo2",
                "dongwu".getBytes(),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.PERSISTENT);
        System.out.println(nodePath);
    }

    @Before
    public void initZkClient() throws IOException {
        // 连接ZK集群的地址
        String connectionStr = "hadoop102:2181,hadoop103:2181,hadoop101:2181";
        // 超时时间
        int sessionTimeOut = 10000;
        zk = new ZooKeeper(connectionStr, sessionTimeOut, new Watcher() {
            public void process(WatchedEvent event) {
//                System.out.println("监听到有变化");
            }
        });
        System.out.println("======================================== zk ========================================" + zk);
    }

    @After
    public void closeZk() throws InterruptedException {
        System.out.println("====================================================");
        zk.close();
    }

    /**
     * 获取ZK的连接对象
     * @throws IOException
     */
    @Test
    public void testZkClient() throws IOException {
        // 连接ZK集群的地址
        String connectionStr = "hadoop102:2181,hadoop103:2181,hadoop101:2181";
        // 超时时间
        int sessionTimeOut = 10000;
        ZooKeeper zk = new ZooKeeper(connectionStr, sessionTimeOut, new Watcher() {
            public void process(WatchedEvent event) {
                System.out.println("监听到有变化");
            }
        });
        System.out.println(zk);

    }
}
