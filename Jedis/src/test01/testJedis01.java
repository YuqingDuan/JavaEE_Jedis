package test01;

import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * 测试单实例连接Redis
 */
public class testJedis01 {
    @Test
    public void testJedisSingle() {
        // 1.设置ip地址和端口
        Jedis jedis = new Jedis("192.168.98.128", 6379);
        // 2.设置数据
        jedis.set("name", "itheima");
        // 3.获得数据
        String name = jedis.get("name");
        System.out.println(name);
        // 4.释放资源
        jedis.close();
    }
}
