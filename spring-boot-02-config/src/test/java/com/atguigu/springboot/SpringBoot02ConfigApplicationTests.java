package com.atguigu.springboot;

import com.atguigu.springboot.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 可以在测试期间很方便的类似编码一样进行自动注入等容器的功能
 */
@SpringBootTest
class SpringBoot02ConfigApplicationTests {

    @Autowired
    Person person;

    @Test
    void contextLoads() {
        System.out.println(person.toString());
    }

}
