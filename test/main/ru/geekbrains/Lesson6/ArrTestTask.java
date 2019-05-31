package main.ru.geekbrains.Lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ArrTestTask {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new int[]{1,2,3,4},new int[] {}},
                {new int[]{4,5,6,7,4,5,6,3,4,5,6,7,8}, new int[]{5,6,7,8}},
                {new int[]{1,2,3,-4,5,4},new int[] {}}
        });
    }

    private Lesson6Task lesson6Task;

    private int[] in;
    private int[] out;

    public ArrTestTask(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    @Before
    public void setUp() {
        lesson6Task = new Lesson6Task();

    }

    @Test
    public void TestArr() {
        Assert.assertArrayEquals(out, lesson6Task.arrModify(in));
    }

    @Test(expected = RuntimeException.class)
    public void TestArrRuntime() {
        int[] in3 = {1,1,1,6,3,1,5,6,7};
        int[] out3 = {6,3,1,5,6,7};
        Assert.assertArrayEquals(out3, lesson6Task.arrModify(in3));
    }

}

