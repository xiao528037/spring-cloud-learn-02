package com.xiao.cloud.cloudstreamrabbitconsumer8802;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.Consumer;

@SpringBootTest
class CloudStreamRabbitConsumer8802ApplicationTests {

    @Test
    void contextLoads() {

        test((name) -> {
            System.out.println(name + "?????");
        });
    }


    public void test(Consumer<String> consumer) {
        consumer.accept("123");
    }
}
