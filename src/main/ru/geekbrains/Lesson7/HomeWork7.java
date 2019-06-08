package main.ru.geekbrains.Lesson7;

public class HomeWork7 {

    @BeforeSuite
    public int methodSum(int a, int b) {
        return a+b;
    }

    @Test(priority = 8)
    public int methodCube(int a, int b) {
        return (int) Math.pow(a,b);
    }

    @Test(priority = 4)
    public int methodSub(int a, int b) {
        return a-b;
    }

    @Test(priority = 6)
    public int methodDiv(int a, int b) {
        if (b!=0) {
            return a/b;
        } else {
            return 0;
        }
    }

    @AfterSuite
    public int methodMult(int a, int b) {
        return a*b;
    }

    /*@BeforeSuite
    public int method3(int a, int b) {
        return a*b;
    }*/
}
