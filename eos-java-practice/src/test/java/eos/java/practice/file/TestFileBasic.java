package eos.java.practice.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by yanyuyu on 2017/3/15.
 */
public class TestFileBasic {
    @Test
    public void testSeparator() {
        System.out.println("File separator:" + File.separator);
        System.out.println("File pathSeparator:" + File.pathSeparator);
    }
}
