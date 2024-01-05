import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DeleteCustomerPageTest extends BaseTest{

    private DeleteCustomerPage deleteCustomerPage;
    private HomePage homePage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckDeleteCustomerButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnDeleteCustomerButton();
        String Expected = "Delete Customer Form";
        WebElement DeleteCustomerAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = DeleteCustomerAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //CustomerID
    @Test (priority = 1)
    public void CustomerID_IsRequired ()
    {
        deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.EnterCustomerID("");
        deleteCustomerPage.LeftClickOnThePage();
        String Expected = "Customer ID is required";
        WebElement CustomerID_Assertion = driver.findElement(By.xpath("//label[@id='message14']"));
        String Actual = CustomerID_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void CustomerID_SpecialCharactersAreNotAllowed()
    {
        deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.EnterCustomerID("@");
        String Expected = "Special characters are not allowed";
        WebElement CustomerID_Assertion = driver.findElement(By.xpath("//label[@id='message14']"));
        String Actual = CustomerID_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void CustomerID_CharactersAreNotAllowed()
    {
        deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.EnterCustomerID("A");
        String Expected = "Characters are not allowed";
        WebElement CustomerID_Assertion = driver.findElement(By.xpath("//label[@id='message14']"));
        String Actual = CustomerID_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void CustomerID_FirstCharacterCannotHaveSpace()
    {
        deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.EnterCustomerID(" ");
        String Expected = "First character can not have space";
        WebElement CustomerID_Assertion = driver.findElement(By.xpath("//label[@id='message14']"));
        String Actual = CustomerID_Assertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //ResetButton
    @Test (priority = 2)
    public void CheckResetButton ()
    {
        deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.EnterCustomerID("123456");
        deleteCustomerPage.ClickOnResetButton();
        WebElement CustomerID_Assertion = driver.findElement(By.xpath("//input[@name='cusid']"));
        String Actual = CustomerID_Assertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }


    //InvalidCustomerID
    @Test (priority = 3)
    public void InvalidCustomerID()
    {
        deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.EnterCustomerID("123456");
        deleteCustomerPage.ClickOnSubmitButton();
        String Actual1 = driver.switchTo().alert().getText();
        deleteCustomerPage.ClickOnAlert();
        String Expected1 = "Do you really want to delete this Customer?";
        String Actual2 = driver.switchTo().alert().getText();
        deleteCustomerPage.ClickOnAlert();
        String Expected2 = "Customer does not exist!!";
        Assert.assertEquals(Actual1,Expected1);
        Assert.assertEquals(Actual2,Expected2);
    }


    //HomeButton
    @Test (priority = 4)
    public void CheckHomeButton ()
    {
        deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
        homePage.ClickOnNewCustomerButton();
    }


    //DeleteCustomer
    @Test (priority = 5)
    public void DeleteCustomer()
    {
        deleteCustomerPage = new DeleteCustomerPage(driver);
        deleteCustomerPage.EnterCustomerID(NewCustomerID_Saved);
        deleteCustomerPage.ClickOnSubmitButton();
        String Actual1 = driver.switchTo().alert().getText();
        deleteCustomerPage.ClickOnAlert();
        String Expected1 = "Do you really want to delete this Customer?";
        String Actual2 = driver.switchTo().alert().getText();
        deleteCustomerPage.ClickOnAlert();
        String Expected2 = "Customer does not Exist!!!";
        Assert.assertEquals(Actual1,Expected1);
        Assert.assertEquals(Actual2,Expected2);
        deleteCustomerPage.ClickOnHomeButton();
    }

}
