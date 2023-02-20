import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest extends BaseTest {
    /*
    Dropdown - Взять все элементы дроп-дауна и проверить их наличие.
    Выбрать первый, проверить, что он выбран, выбрать второй, проверить, что он выбран
    Локатор By.id("dropdown")
     */
    private static final int AMOUNT_OF_ELEMENTS = 3;
    List<WebElement> options;
    Select dropDown;

    @BeforeClass
    public void getDropDown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        dropDown = new Select(driver.findElement(By.id("dropdown")));
        options = dropDown.getOptions();
    }

    @Test
    public void getAmountOfOptions(){
        Assert.assertEquals(options.size(), AMOUNT_OF_ELEMENTS,
                "The number of elements in the dropdown does not match the expected result");
    }

    @Test
    public void checkAllElementsOfDropDown(){
        Assert.assertEquals(options.get(0).getText(), "Please select an option",
                "Error. The option is not found" );
        Assert.assertEquals(options.get(1).getText(), "Option 1",
                "Error. The option is not found" );
        Assert.assertEquals(options.get(2).getText(), "Option 2",
                "Error. The option is not found" );
    }

    @Test
    public void checkFirstElementsOfDropDown(){
        WebElement firstOption = options.get(1);
        Assert.assertFalse(firstOption.isEnabled(), "Option 1 is not displayed");
        dropDown.selectByValue("1");
        Assert.assertTrue(firstOption.isSelected(), "Option 1 is selected");
    }

    @Test
    public void checkSecondElementsOfDropDown(){
        WebElement secondOption = options.get(2);
        Assert.assertFalse(secondOption.isEnabled(), "Option 2 is not displayed");
        dropDown.selectByValue("2");
        Assert.assertTrue(secondOption.isSelected(), "Option 2 is selected");
    }
}