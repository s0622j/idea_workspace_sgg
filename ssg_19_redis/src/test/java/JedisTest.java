import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author shenJie
 * @version 1.0.0
 * @ClassName JedisTest.java
 * @Description TODO
 * @createTime 2025-08-07 16:20:00
 */
public class JedisTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("hadoop101",6379);
        String ping = jedis.ping();
        System.out.println(ping);


        //Jedis jedis = new Jedis("hadoop101",6379);
        Jedis jedis2 = getJedis();
        String ping2 = jedis2.ping();
        System.out.println(ping2);
    }

    public static JedisPool pool =  null ;

    public static Jedis getJedis(){
        if(pool == null ){
            //主要配置
            JedisPoolConfig jedisPoolConfig =new JedisPoolConfig();
            jedisPoolConfig.setMaxTotal(10); //最大可用连接数
            jedisPoolConfig.setMaxIdle(5); //最大闲置连接数
            jedisPoolConfig.setMinIdle(5); //最小闲置连接数
            jedisPoolConfig.setBlockWhenExhausted(true); //连接耗尽是否等待
            jedisPoolConfig.setMaxWaitMillis(2000); //等待时间
            jedisPoolConfig.setTestOnBorrow(true); //取连接的时候进行一下测试 ping pong
            pool = new JedisPool(jedisPoolConfig,"hadoop101",6379) ;
        }

        return pool.getResource();
    }

}
