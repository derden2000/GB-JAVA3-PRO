package main.ru.geekbrains.Lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrBooleanTrue {


    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,1,1,1,1,4,4,4,4,5}},
                {new int[]{-1,1,1,1,1,4,4,4,4}},
                {new int[]{0,0}},
                {new int[]{1,1,1,1,1,4,4,4,4}},
                {new int[]{1,4}},
        });
    }

    private Lesson6Task lesson6Task;

    private int[] in;


    public ArrBooleanTrue(int[] in) {
        this.in = in;
    }

    @Before
    public void setUp() {
        lesson6Task = new Lesson6Task();
    }

    @Test
    public void findNumsTrue() {
        Assert.assertTrue(Lesson6Task.findNums(in));
    }

}
