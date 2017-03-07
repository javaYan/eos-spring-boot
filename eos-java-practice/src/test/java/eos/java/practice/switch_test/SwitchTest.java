package eos.java.practice.switch_test;

import org.junit.Test;

/**
 * Created by yanyuyu on 2017/3/7.
 */
public class SwitchTest {
    @Test
    public void testString() {
        String str = "cd";
        switch (str) {
            case "ab": System.out.println("abab"); break;
            case "cd": System.out.println("cdcd"); break;
            case "ef": System.out.println("efef"); break;
            case "gh": System.out.println("ghgh"); break;
            case "hi": System.out.println("hihi"); break;
        }
    }
}
