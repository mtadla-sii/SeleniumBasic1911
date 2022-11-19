import org.testng.annotations.Test;

public class FormTest extends TestBase{

    @Test
    public void shouldFillFormWithSuccess(){
        driver.get("http://51.75.61.161:9102/form.php");
    }
}
