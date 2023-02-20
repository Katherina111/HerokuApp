import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TyposTest extends BaseTest{

    @Test
    public void checkTypos() {
        driver.get("http://the-internet.herokuapp.com/typos");
        List<WebElement> paragraph = driver.findElements(By.tagName("p"));
        WebElement paraghraphTypos = paragraph.get(1);
        String lineWithoutParaghraph = "Sometimes you'll see a typo, other times you won't.";
        Assert.assertEquals(paraghraphTypos.getText(), lineWithoutParaghraph, "The line contains Typos");
    }
}
