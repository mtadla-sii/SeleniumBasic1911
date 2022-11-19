import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DroppableTest extends TestBase{

    @Test
    public void shouldDragAndDrop(){
        driver.get("http://51.75.61.161:9102/droppable.php");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);

        actions.dragAndDrop(draggable, droppable)
                .perform();

        Assert.assertEquals(droppable.getText(), "Dropped!");
    }
}
