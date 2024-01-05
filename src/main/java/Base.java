import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Base {

    // Attributes
    protected WebDriver driver;

    // Constructors
    public Base (WebDriver driver)
    {
        this.driver = driver;
    }

    // Methods
    public static void Clicking (WebElement Element)
    {
        Element.click();
    }
    public static void SendText (WebElement element, String text)
    {
        element.sendKeys(text);
    }
    public static void ClearText (WebElement element)
    {
        element.clear();
    }
    public void AddWait ()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public void ClickOnAlert ()
    {
        driver.switchTo().alert().accept();
    }
    public void SelectDropDown (WebElement element, int Index)
    {
        Select DropDown = new Select(element);
        DropDown.selectByIndex(Index);
    }





}
