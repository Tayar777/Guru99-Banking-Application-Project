import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewAccountPageTest extends BaseTest {

    private NewAccountPage newAccountPage;
    private HomePage homePage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckNewAccountButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnNewAccountButton();
        String Expected = "Add new account form";
        WebElement NewAccountAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = NewAccountAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //CustomerID_TC
    @Test(priority = 1)
    public void CustomerID_IsRequired ()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterCustomerID("");
        newAccountPage.LeftClickOnThePage();
        String Expected = "Customer ID is required";
        WebElement CustomerID_Assertion = driver.findElement(By.xpath("//label[@id='message14']"));
        String Actual = CustomerID_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void CustomerID_SpecialCharactersAreNotAllowed()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterCustomerID("@");
        String Expected = "Special characters are not allowed";
        WebElement CustomerID_Assertion = driver.findElement(By.xpath("//label[@id='message14']"));
        String Actual = CustomerID_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void CustomerID_CharactersAreNotAllowed()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterCustomerID("A");
        String Expected = "Characters are not allowed";
        WebElement CustomerID_Assertion = driver.findElement(By.xpath("//label[@id='message14']"));
        String Actual = CustomerID_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void CustomerID_FirstCharacterCannotHaveSpace()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterCustomerID(" ");
        String Expected = "First character can not have space";
        WebElement CustomerID_Assertion = driver.findElement(By.xpath("//label[@id='message14']"));
        String Actual = CustomerID_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //AccountTypeTC
    @Test (priority = 2)
    public void AccountType ()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.SelectAccountType(1);
    }


    //InitialDeposit_TC
    @Test(priority = 3)
    public void InitialDeposit_MustNotBeBlank ()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterInitialDeposit("");
        newAccountPage.LeftClickOnThePage();
        String Expected = "Initial Deposit must not be blank";
        WebElement InitialDeposit_Assertion = driver.findElement(By.xpath("//label[@id='message19']"));
        String Actual = InitialDeposit_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void InitialDeposit_SpecialCharactersAreNotAllowed()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterInitialDeposit("@");
        String Expected = "Special characters are not allowed";
        WebElement InitialDeposit_Assertion = driver.findElement(By.xpath("//label[@id='message19']"));
        String Actual = InitialDeposit_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void InitialDeposit_CharactersAreNotAllowed()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterInitialDeposit("A");
        String Expected = "Characters are not allowed";
        WebElement InitialDeposit_Assertion = driver.findElement(By.xpath("//label[@id='message19']"));
        String Actual = InitialDeposit_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 3)
    public void InitialDeposit_FirstCharacterCannotHaveSpace()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterInitialDeposit(" ");
        String Expected = "First character can not have space";
        WebElement InitialDeposit_Assertion = driver.findElement(By.xpath("//label[@id='message19']"));
        String Actual = InitialDeposit_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    // CheckResetButton
    @Test (priority = 4)
    public void CheckResetButton ()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterCustomerID("123456");
        newAccountPage.SelectAccountType(1);
        newAccountPage.EnterInitialDeposit("500");
        newAccountPage.ClickOnResetButton();
        WebElement CustomerID_Assertion = driver.findElement(By.xpath("//input[@name='cusid']"));
        String Actual = CustomerID_Assertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }


    // InvalidCustomerID
    @Test (priority = 5)
    public void InvalidCustomerID ()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterCustomerID("123456");
        newAccountPage.SelectAccountType(0);
        newAccountPage.EnterInitialDeposit("500");
        newAccountPage.ClickOnSubmitButton();
        String Actual = driver.switchTo().alert().getText();
        newAccountPage.ClickOnAlert();
        String Expected = "Customer does not exist!!";
        Assert.assertEquals(Actual,Expected);
    }


    // CheckHomeButton
    @Test (priority = 6)
    public void CheckHomeButton ()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
        homePage.ClickOnNewAccountButton();
    }

    //GenerateNewAccount
    @Test (priority = 7)
    public void NewAccount1 ()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterCustomerID(NewCustomerID_Saved);
        newAccountPage.SelectAccountType(0);
        newAccountPage.EnterInitialDeposit("500");
        newAccountPage.ClickOnSubmitButton();
        WebElement NewAccount_Assertion = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = NewAccount_Assertion.getText();
        String Expected = "Account Generated Successfully!!!";
        Assert.assertEquals(Actual,Expected);
        WebElement AccountID_Element = driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]"));
        NewAccountID_Saved = AccountID_Element.getText();
        System.out.println(NewAccountID_Saved);
        newAccountPage.ClickOnHomeButton();
        homePage.ClickOnNewAccountButton();
    }

    @Test (priority = 8)
    public void NewAccount2 ()
    {
        newAccountPage = new NewAccountPage(driver);
        newAccountPage.EnterCustomerID(NewCustomerID_Saved);
        newAccountPage.SelectAccountType(0);
        newAccountPage.EnterInitialDeposit("500");
        newAccountPage.ClickOnSubmitButton();
        WebElement NewAccount_Assertion = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = NewAccount_Assertion.getText();
        String Expected = "Account Generated Successfully!!!";
        Assert.assertEquals(Actual,Expected);
        WebElement AccountID_Element = driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[4]/td[2]"));
        NewAccountID_Saved2 = AccountID_Element.getText();
        System.out.println(NewAccountID_Saved2);
        newAccountPage.ClickOnHomeButton();
    }


}
