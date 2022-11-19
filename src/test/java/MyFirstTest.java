import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyFirstTest {

    @BeforeMethod
    public void setUp(){
        System.out.println("PRZED");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("PO");
    }

    @Test
    public void shouldCalculateValue(){
        System.out.println(">>> to jest moj test 1");
        Assert.assertEquals(4,5);
        System.out.println(">>>to jest koniec testu 1");
    }

    @Test
    public void shouldCalculateValue2(){
        System.out.println(">>> to jest moj test 2");
        Assert.assertEquals(add(2,3),5);
        System.out.println(">>>to jest koniec testu 2");
    }

    public int add(int a, int b){
        return a+b;
    }

}
