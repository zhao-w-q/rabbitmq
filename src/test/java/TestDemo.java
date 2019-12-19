import com.dfbz.rabbitmq.RabbitmqApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitMessagingTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Zhao
 * @description
 * @date 2019/12/18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RabbitmqApplication.class)
public class TestDemo {
    @Autowired
    private RabbitMessagingTemplate rabbitTemplate;

    @Test
    public void test1(){
        //给xiaobiao发送一条消息
        rabbitTemplate.convertAndSend("xiaobiao","小标你好吗？");
    }
    @Test
    public void test2(){ //分列模式
        rabbitTemplate.convertAndSend("dfbz","","东方标准呼叫小标小准！");
    }
    @Test
    public void test3(){ //主题模式
        rabbitTemplate.convertAndSend("topicdfbz","article.new","主题模式呼叫全体员工！");
    }
    @Test
    public void test4(){ //直连模式
        // 谁也收不到消息,路由不生效
//        rabbitTemplate.convertAndSend("test1","test1.aaa","测试直接模式routeKey");

        // xiaozhun收到消息，即未绑定routeKey的收到消息
//        rabbitTemplate.convertAndSend("test1","","测试直接模式routeKey");

        // 直接发给交换机，交换机也不会转发给对应的queue,谁也收不到消息
        rabbitTemplate.convertAndSend("test1","测试直接模式routeKey");
    }
    @Test
    public void test5(){ //分列模式
        //全都收到消息，routeKey没有起到作用
//        rabbitTemplate.convertAndSend("dfbz","xxxx","测试分列模式routeKey");

        //谁也收不到消息,直接发送给交换机不生效，因为绑定的queue中都存在了路由规则
        rabbitTemplate.convertAndSend("dfbz","测试分列模式routeKey");
    }
}
