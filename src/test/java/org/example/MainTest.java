package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
    @BeforeEach
    void setup(){
    }
    @Test
    void addTest(){
        Main main = new Main();
        Assertions.assertEquals(4,main.add(2,2));
    }
    @Test
    void addTest2(){
        Main main=new Main();
        Assertions.assertNotEquals(5,main.add(2,2));
    }
}
