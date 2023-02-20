import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class CheckboxesTest extends BaseTest {
    /*
    проверить, что первый чекбокс unchecked,
    отметить первый чекбокс, проверить что он checked.
    Проверить, что второй чекбокс checked, сделать unhecked, проверить, что он unchecked
    Локатор By.cssSelector("[type=checkbox]")
     */
    List<WebElement> elementsOfCheckbox;
    private static final int AMOUNT_OF_CHECKBOX = 2;
    private WebElement firstCheckbox;
    private WebElement secondCheckbox;

    @BeforeClass
    public void getCheckboxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        elementsOfCheckbox = driver.findElements(By.cssSelector("[type=checkbox]"));
        firstCheckbox = elementsOfCheckbox.get(0);
        secondCheckbox = elementsOfCheckbox.get(1);
    }

    @Test
    public void amountElementsOfCheckbox() {
        Assert.assertEquals(elementsOfCheckbox.size(), AMOUNT_OF_CHECKBOX, "The number of checkboxes is %d");
    }

    @Test
    public void checkFirstCaseForCheckbox() {
        Assert.assertFalse(firstCheckbox.isSelected(), "First checkbox is not selected");
        firstCheckbox.click();
        Assert.assertTrue(firstCheckbox.isSelected(), "First checkbox is selected");
    }

    @Test
    public void checkSecondCaseForCheckbox() {
        Assert.assertTrue(secondCheckbox.isSelected(), "Second checkbox is selected");
        secondCheckbox.click();
        Assert.assertFalse(secondCheckbox.isSelected(), "Second checkbox is not selected");
    }
}