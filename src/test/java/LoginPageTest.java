import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage ;

    @Test (priority = 3)
    public void ValidLogin1 ()
    {
        loginPage = new LoginPage(driver);
        loginPage.Add_UserID("mngr543685");
        loginPage.Add_Password("EsAnubU");
        loginPage.AddWait();
        loginPage.ClickOnLoginButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement ValidLoginAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = ValidLoginAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void InValidLogin_IncorrectUserID ()
    {
        loginPage = new LoginPage (driver);
        loginPage.Add_UserID("mn3685");
        loginPage.Add_Password("EsAnubU");
        loginPage.AddWait();
        loginPage.ClickOnLoginButton();
        loginPage.AddWait();
        String Actual = driver.switchTo().alert().getText();
        loginPage.ClickOnAlert();
        String Expected = "User or Password is not valid";
        Assert.assertTrue(Actual.contains(Expected));
    }

    @Test (priority = 2)
    public void InValidLogin_IncorrectPassword ()
    {
        loginPage = new LoginPage(driver);
        loginPage.Add_UserID("mngr543685");
        loginPage.Add_Password("EsAnubU123");
        loginPage.AddWait();
        loginPage.ClickOnLoginButton();
        loginPage.AddWait();
        String Actual = driver.switchTo().alert().getText();
        loginPage.ClickOnAlert();
        String Expected = "User or Password is not valid";
        Assert.assertTrue(Actual.contains(Expected));
    }

    @Test (priority = 2)
    public void InValidLogin_IncorrectUserIDandPassword ()
    {
        loginPage = new LoginPage(driver);
        loginPage.Add_UserID("mngr5436");
        loginPage.Add_Password("EsAnubU12");
        loginPage.AddWait();
        loginPage.ClickOnLoginButton();
        loginPage.AddWait();
        String Actual = driver.switchTo().alert().getText();
        loginPage.ClickOnAlert();
        String Expected = "User or Password is not valid";
        Assert.assertTrue(Actual.contains(Expected));
    }

    @Test (priority = 1)
    public void UserID_MustNotBeBlank ()
    {
        loginPage = new LoginPage(driver);
        loginPage.ClickOnUserID_TextBox();
        loginPage.ClickOnPassword_TextBox();
        String Expected = "User-ID must not be blank";
        WebElement InValidUserID_Element = driver.findElement(By.xpath("//label[@id='message23']"));
        String Actual = InValidUserID_Element.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void Password_MustNotBeBlank ()
    {
        loginPage = new LoginPage(driver);
        loginPage.ClickOnPassword_TextBox();
        loginPage.ClickOnUserID_TextBox();
        String Expected = "Password must not be blank";
        WebElement InValidPassword_Element = driver.findElement(By.xpath("//label[@id='message18']"));
        String Actual = InValidPassword_Element.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void CheckResetButton ()
    {
        loginPage = new LoginPage(driver);
        loginPage.Add_UserID("mngr543685");
        loginPage.Add_Password("EsAnubU");
        loginPage.AddWait();
        loginPage.ClickOnResetButton();
        String Actual1 = loginPage.UserID_TextBox_Element.getText();
        String Actual2 = loginPage.Password_TextBox_Element.getText();
        String Expected1 = "";
        String Expected2 = "";
        Assert.assertEquals(Actual1,Expected1);
        Assert.assertEquals(Actual2,Expected2);
    }

}
