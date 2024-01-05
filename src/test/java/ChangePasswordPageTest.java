import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChangePasswordPageTest extends BaseTest{

    private ChangePasswordPage changePasswordPage;
    private HomePage homePage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckChangePasswordButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnChangePasswordButton();
        String Expected = "Change Password";
        WebElement ChangePasswordAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = ChangePasswordAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //OldPasswordTC
    @Test(priority = 1)
    public void OldPassword_MustNotBeBlank ()
    {
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.EnterOldPassword("");
        changePasswordPage.LeftClickOnThePage();
        String Expected = "Old Password must not be blank";
        WebElement OldPassword_Assertion = driver.findElement(By.xpath("//label[@id='message20']"));
        String Actual = OldPassword_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //NewPassword
    @Test (priority = 2)
    public void NewPassword_MustNotBeBlank ()
    {
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.EnterNewPassword("");
        changePasswordPage.LeftClickOnThePage();
        String Expected = "New Password must not be blank";
        WebElement NewPassword_Assertion = driver.findElement(By.xpath("//label[@id='message21']"));
        String Actual = NewPassword_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void NewPassword_MustHaveAtLeastOneNumericValue ()
    {
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.EnterNewPassword("@hmed");
        changePasswordPage.LeftClickOnThePage();
        String Expected = "Enter at-least one numeric value";
        WebElement NewPassword_Assertion = driver.findElement(By.xpath("//label[@id='message21']"));
        String Actual = NewPassword_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 2)
    public void NewPassword_MustHaveAtLeastOneSpecialCharacter ()
    {
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.EnterNewPassword("1ahmed");
        changePasswordPage.LeftClickOnThePage();
        String Expected = "Enter at-least one special character";
        WebElement NewPassword_Assertion = driver.findElement(By.xpath("//label[@id='message21']"));
        String Actual = NewPassword_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //ConfirmPasswordTC
    @Test (priority = 3)
    public void ConfirmPassword_MustNotBeBlank ()
    {
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.EnterConfirmPassword("");
        changePasswordPage.LeftClickOnThePage();
        String Expected = "Confirm Password must not be blank";
        WebElement ConfirmPassword_Assertion = driver.findElement(By.xpath("//label[@id='message22']"));
        String Actual = ConfirmPassword_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void ConfirmPassword_PasswordsDoNotMatch ()
    {
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.EnterNewPassword("@1ahmed");
        changePasswordPage.EnterConfirmPassword("@1ahm");
        String Expected = "Passwords do not Match";
        WebElement ConfirmPassword_Assertion = driver.findElement(By.xpath("//label[@id='message22']"));
        String Actual = ConfirmPassword_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    //ResetButtonTC
    @Test (priority = 4)
    public void CheckResetButton ()
    {
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.EnterOldPassword("@1ahmed");
        changePasswordPage.EnterNewPassword("@1ahmed");
        changePasswordPage.EnterConfirmPassword("@1ahmed");
        changePasswordPage.ClickOnResetButton();
        WebElement OldPassword_Assertion = driver.findElement(By.xpath("//input[@name='oldpassword']"));
        String Actual = OldPassword_Assertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }

    //HomeButton
    @Test (priority = 5)
    public void CheckHomeButton ()
    {
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
      //homePage.ClickOnChangePasswordButton();
    }


    //ChangePassword
    @Test (priority = 5,enabled = false)
    public void ChangePassword ()
    {
        changePasswordPage = new ChangePasswordPage(driver);
        changePasswordPage.EnterOldPassword("EsAnubU");
        changePasswordPage.EnterNewPassword("@1ahmed");
        changePasswordPage.EnterConfirmPassword("@1ahmed");
        changePasswordPage.ClickOnSubmitButton();
        String Actual = driver.switchTo().alert().getText();
        String Expected = "Password changed successfully";
        changePasswordPage.ClickOnAlert();
        Assert.assertEquals(Actual,Expected);
    }



}
