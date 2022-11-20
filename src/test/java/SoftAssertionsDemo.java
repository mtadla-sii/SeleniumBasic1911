import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionsDemo {

    @Test
    public void hardAssert(){
        String name = "Jan";
        String lastName = "Kowalski";
        int age = 30;

        Assert.assertEquals(name, "Jan");
        Assert.assertEquals(lastName, "Nowak");
        Assert.assertEquals(age, 44);
    }
    @Test
    public void softAssert(){
        String name = "Jan";
        String lastName = "Kowalski";
        int age = 30;

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(name, "Jan");
        softAssert.assertEquals(lastName, "Nowak");
        softAssert.assertEquals(age, 44);

        softAssert.assertAll();

    }
}
