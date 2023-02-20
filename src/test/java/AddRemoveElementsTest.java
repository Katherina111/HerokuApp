import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElementsTest extends BaseTest {

    private static final int AMOUNT_CLICK_REMOVE_BUTTON = 1;

    @Test
    public void addRemoveElementsTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement addButton = driver.findElement(By.xpath("//button[text()='Add Element']"));
        addButton.click();
        addButton.click();
        WebElement removeButton = driver.findElement(By.xpath("//button[text()='Delete']"));
        removeButton.click();
        List<WebElement> displayDeleteButton = driver.findElements(By.xpath("//button[text()='Delete']"));
        Assert.assertEquals(displayDeleteButton.size(), AMOUNT_CLICK_REMOVE_BUTTON,
                String.format("The number of display buttons Delete is equal to %d." +
                        "\n" +
                        "Expected Result - %d", displayDeleteButton.size(), AMOUNT_CLICK_REMOVE_BUTTON));
    }
}
