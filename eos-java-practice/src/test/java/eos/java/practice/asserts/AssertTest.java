package eos.java.practice.asserts;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Mr_yyy on 2017/3/26.
 */
public class AssertTest {
    @Test
    public void testAssert() {
        assert(10>10);
    }

    @Test
    public void testAssertTrue() {
        Assert.assertTrue(false);
    }
}
