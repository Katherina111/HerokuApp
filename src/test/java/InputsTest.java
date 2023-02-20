import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class InputsTest extends BaseTest {
    private WebElement input;

    @BeforeClass
    public void getInput() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        input = driver.findElement(By.tagName("input"));
    }

    @BeforeMethod(alwaysRun = true)
    public void clearField () {
        input.clear();
    }

    @Test
    public void inputArrowUpDown(){
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), "1", "Check inputted value");
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), "0", "Check inputted value");
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), "-1", "Check inputted value");
    }

    @Test
    public void inputIntDigits() {
        input.sendKeys("123");
        assertEquals(input.getAttribute("value"), "123", "Error. Check the inputted value.");
    }

    @Test
    public void inputFloatDigits() {
        input.sendKeys("12.56");
        assertEquals(input.getAttribute("value"), "12.56", "Error. Check the inputted value.");
    }

    @Test
    public void inputLettersDigits() {
        input.sendKeys("abc");
        assertEquals(input.getAttribute("value"), "abc", "Error. Check the inputted value.");
    }

    @Test
    public void inputSpecialSymbols() {
        input.sendKeys("@#");
        assertEquals(input.getAttribute("value"), "@#", "Error. Check the inputted value.");
    }
}