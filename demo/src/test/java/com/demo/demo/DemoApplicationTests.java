package com.demo.demo;

import com.demo.demo.service.Demo1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={DemoApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration
public class DemoApplicationTests {
    @Autowired
    private Demo1 demo1;

    @Test
    public void stage1_1() {
        this.demo1.individualDictionaryWords("ilikesamsungmobile");
    }

    @Test
    public void stage1_2() {
        this.demo1.individualDictionaryWords("ilikeicecreammango");
    }

    @Test
    public void stage2(){
        this.demo1.individualDictionaryWordsOnlyInput("{{i,like,sam,sung,mobile,icecream,man go,mango}",
                "ilikeicecreammango");
    }

    @Test
    public void stage2_mango(){
        this.demo1.individualDictionaryWordsOnlyInput("{{i,like,sam,sung,mobile,icecream,man go,mango}",
                "ilikemangoicecreammango");
    }

}
