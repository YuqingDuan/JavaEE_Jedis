package test02;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 测试连接池连接Redis
 */
public class testJedis02 {
    @Test
    public void testJedisPool() {
        // 1.获得连接池配置对象，设置配置项
        JedisPoolConfig config = new JedisPoolConfig();
        // 1.1最大连接数
        config.setMaxTotal(30);
        // 1.2最大空闲连接数
        config.setMaxIdle(10);

        // 2.获得连接池
        JedisPool jedisPool = new JedisPool(config, "192.168.98.128", 6379);

        // 3.获得核心对象
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();

            // 4.设置数据
            jedis.set("name", "itcast");
            // 5.获得数据
            String name = jedis.get("name");
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (jedis != null) {
                jedis.close();
            }
            // 虚拟机关闭时，释放pool资源
            jedisPool.close();
        }
    }
}
