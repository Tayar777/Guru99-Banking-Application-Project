import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewCustomerPageTest extends BaseTest {

    private NewCustomerPage newCustomerPage;
    private HomePage homePage;
    private DeleteCustomerPage deleteCustomerPage;


    @BeforeTest (dependsOnMethods = "ValidLogin")
    public void CheckNewCustomerButton ()
    {
        homePage = new HomePage(driver);
        homePage.ClickOnNewCustomerButton();
        String Expected = "Add New Customer";
        WebElement NewCustomerAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = NewCustomerAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
    }


    // CustomerNameTC
    @Test (priority = 1)
    public void CustomerName_MustNotBeBlank ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCustomerName("");
        newCustomerPage.EnterAddress("");
        String Expected = "Customer name must not be blank";
        WebElement CustomerNameAssertion = driver.findElement(By.xpath("//label[@id='message']"));
        String Actual = CustomerNameAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void CustomerName_SpecialCharactersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCustomerName("@");
        String Expected = "Special characters are not allowed";
        WebElement CustomerNameAssertion = driver.findElement(By.xpath("//label[@id='message']"));
        String Actual = CustomerNameAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void CustomerName_NumbersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCustomerName("1");
        String Expected = "Numbers are not allowed";
        WebElement CustomerNameAssertion = driver.findElement(By.xpath("//label[@id='message']"));
        String Actual = CustomerNameAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 1)
    public void CustomerName_FirstCharacterCannotHaveSpace()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCustomerName(" ");
        String Expected = "First character can not have space";
        WebElement CustomerNameAssertion = driver.findElement(By.xpath("//label[@id='message']"));
        String Actual = CustomerNameAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    // Gender
    @Test (priority = 2)
    public void SelectMaleGender ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.SelectMaleGender();
        WebElement MaleGenderAssertion = driver.findElement(By.xpath("//input[@value='m']"));
        boolean Actual = MaleGenderAssertion.isSelected();
        Assert.assertTrue(true);
    }

    @Test (priority = 2)
    public void SelectFemaleGender ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.SelectFemaleGender();
        WebElement FemaleGenderAssertion = driver.findElement(By.xpath("//input[@value='f']"));
        boolean Actual = FemaleGenderAssertion.isSelected();
        Assert.assertTrue(true);
    }


    // DateOfBirthTC
    @Test (priority = 3)
    public void DateOfBirth_MustNotBeBlank ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterDateOfBirth("");
        newCustomerPage.EnterAddress("");
        String Expected = "Date Field must not be blank";
        WebElement DateOfBirthAssertion = driver.findElement(By.xpath("//label[@id='message24']"));
        String Actual = DateOfBirthAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    //AddressTC
    @Test (priority = 4)
    public void Address_MustNotBeBlank ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterAddress("");
        newCustomerPage.EnterCity("");
        String Expected = "Address Field must not be blank";
        WebElement AddressAssertion = driver.findElement(By.xpath("//label[@id='message3']"));
        String Actual = AddressAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 4)
    public void Address_SpecialCharactersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterAddress("@");
        String Expected = "Special characters are not allowed";
        WebElement AddressAssertion = driver.findElement(By.xpath("//label[@id='message3']"));
        String Actual = AddressAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 4)
    public void Address_FirstCharacterCannotHaveSpace()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterAddress(" ");
        String Expected = "First character can not have space";
        WebElement AddressAssertion = driver.findElement(By.xpath("//label[@id='message3']"));
        String Actual = AddressAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    // CityTC
    @Test (priority = 5)
    public void City_MustNotBeBlank ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCity("");
        newCustomerPage.EnterState("");
        String Expected = "City Field must not be blank";
        WebElement CityAssertion = driver.findElement(By.xpath("//label[@id='message4']"));
        String Actual = CityAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 5)
    public void City_SpecialCharactersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCity("@");
        String Expected = "Special characters are not allowed";
        WebElement CityAssertion = driver.findElement(By.xpath("//label[@id='message4']"));
        String Actual = CityAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 5)
    public void City_NumbersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCity("1");
        String Expected = "Numbers are not allowed";
        WebElement CityAssertion = driver.findElement(By.xpath("//label[@id='message4']"));
        String Actual = CityAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 5)
    public void City_FirstCharacterCannotHaveSpace()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCity(" ");
        String Expected = "First character can not have space";
        WebElement CityAssertion = driver.findElement(By.xpath("//label[@id='message4']"));
        String Actual = CityAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    // StateTC
    @Test (priority = 6)
    public void State_MustNotBeBlank ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterState("");
        newCustomerPage.EnterPIN("");
        String Expected = "State must not be blank";
        WebElement StateAssertion = driver.findElement(By.xpath("//label[@id='message5']"));
        String Actual = StateAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 6)
    public void State_SpecialCharactersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterState("@");
        String Expected = "Special characters are not allowed";
        WebElement StateAssertion = driver.findElement(By.xpath("//label[@id='message5']"));
        String Actual = StateAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 6)
    public void State_NumbersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterState("1");
        String Expected = "Numbers are not allowed";
        WebElement StateAssertion = driver.findElement(By.xpath("//label[@id='message5']"));
        String Actual = StateAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 6)
    public void State_FirstCharacterCannotHaveSpace()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterState(" ");
        String Expected = "First character can not have space";
        WebElement StateAssertion = driver.findElement(By.xpath("//label[@id='message5']"));
        String Actual = StateAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    // PIN_TC
    @Test (priority = 7)
    public void PIN_MustNotBeBlank ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterPIN("");
        newCustomerPage.EnterMobileNumber("");
        String Expected = "PIN Code must not be blank";
        WebElement PINAssertion = driver.findElement(By.xpath("//label[@id='message6']"));
        String Actual = PINAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 7)
    public void PIN_SpecialCharactersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterPIN("@");
        String Expected = "Special characters are not allowed";
        WebElement PINAssertion = driver.findElement(By.xpath("//label[@id='message6']"));
        String Actual = PINAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 7)
    public void PIN_CharactersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterPIN("A");
        String Expected = "Characters are not allowed";
        WebElement PINAssertion = driver.findElement(By.xpath("//label[@id='message6']"));
        String Actual = PINAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 7)
    public void PIN_FirstCharacterCannotHaveSpace()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterPIN(" ");
        String Expected = "First character can not have space";
        WebElement PINAssertion = driver.findElement(By.xpath("//label[@id='message6']"));
        String Actual = PINAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 7)
    public void PIN_CodeMustHave6Digits()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterPIN("123");
        String Expected = "PIN Code must have 6 Digits";
        WebElement PINAssertion = driver.findElement(By.xpath("//label[@id='message6']"));
        String Actual = PINAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    // MobileNumberTC
    @Test (priority = 8)
    public void MobileNumber_MustNotBeBlank ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterMobileNumber("");
        newCustomerPage.EnterEmail("");
        String Expected = "Mobile no must not be blank";
        WebElement MobileNumberAssertion = driver.findElement(By.xpath("//label[@id='message7']"));
        String Actual = MobileNumberAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 8)
    public void MobileNumber_SpecialCharactersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterMobileNumber("@");
        String Expected = "Special characters are not allowed";
        WebElement MobileNumberAssertion = driver.findElement(By.xpath("//label[@id='message7']"));
        String Actual = MobileNumberAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 8)
    public void MobileNumber_CharactersAreNotAllowed()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterMobileNumber("A");
        String Expected = "Characters are not allowed";
        WebElement MobileNumberAssertion = driver.findElement(By.xpath("//label[@id='message7']"));
        String Actual = MobileNumberAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 8)
    public void MobileNumber_FirstCharacterCannotHaveSpace()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterMobileNumber(" ");
        String Expected = "First character can not have space";
        WebElement MobileNumberAssertion = driver.findElement(By.xpath("//label[@id='message7']"));
        String Actual = MobileNumberAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    // EmailTC
    @Test (priority = 9)
    public void Email_MustNotBeBlank ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterEmail("");
        newCustomerPage.EnterPassword("");
        String Expected = "Email-ID must not be blank";
        WebElement EmailAssertion = driver.findElement(By.xpath("//label[@id='message9']"));
        String Actual = EmailAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 9)
    public void Email_FirstCharacterCannotHaveSpace()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterEmail(" ");
        String Expected = "First character can not have space";
        WebElement EmailAssertion = driver.findElement(By.xpath("//label[@id='message9']"));
        String Actual = EmailAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 9)
    public void Email_IsNotValid()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterEmail("AhmedTarek@");
        String Expected = "Email-ID is not valid";
        WebElement EmailAssertion = driver.findElement(By.xpath("//label[@id='message9']"));
        String Actual = EmailAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }

    @Test (priority = 14)
    public void Email_AlreadyExists ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCustomerName("Ahmed Tarek");
        newCustomerPage.SelectMaleGender();
        newCustomerPage.EnterDateOfBirth("02/15/2000");
        newCustomerPage.EnterAddress("Makkah Street");
        newCustomerPage.EnterCity("Maadi");
        newCustomerPage.EnterState("Cairo");
        newCustomerPage.EnterPIN("123456");
        newCustomerPage.EnterMobileNumber("01023885538");
        newCustomerPage.EnterEmail("Ahmeddtarekk777@gmail.com");
        newCustomerPage.EnterPassword("123456");
        newCustomerPage.ClickOnSubmitButton();
        driver.switchTo().alert().getText();
        String Actual = driver.switchTo().alert().getText();
        String Expected = "Email Address Already Exist !!";
        newCustomerPage.ClickOnAlert();
        Assert.assertEquals(Actual,Expected);
        newCustomerPage.AddWait();
        WebElement NewCustomerAssertionElement = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual1 = NewCustomerAssertionElement.getText();
        String Expected2 = "Add New Customer";
        Assert.assertEquals(Actual,Expected);
    }


    // PasswordTC
    @Test (priority = 10)
    public void Password_MustNotBeBlank ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterPassword("");
        newCustomerPage.EnterEmail("");
        String Expected = "Password must not be blank";
        WebElement PasswordAssertion = driver.findElement(By.xpath("//label[@id='message18']"));
        String Actual = PasswordAssertion.getText();
        Assert.assertEquals(Actual,Expected);
    }


    // ResetButton
    @Test (priority = 11)
    public void CheckResetButton()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCustomerName("Ahmed Tarek");
        newCustomerPage.SelectMaleGender();
        newCustomerPage.EnterDateOfBirth("02/15/2000");
        newCustomerPage.EnterAddress("Makkah Street");
        newCustomerPage.EnterCity("Maadi");
        newCustomerPage.EnterState("Cairo");
        newCustomerPage.EnterPIN("123456");
        newCustomerPage.EnterMobileNumber("01023885538");
        newCustomerPage.EnterEmail("Ahmeddtarekk777@gmail.com");
        newCustomerPage.EnterPassword("123456");
        newCustomerPage.ClickOnResetButton();
        WebElement PasswordAssertion = driver.findElement(By.xpath("//label[@id='message18']"));
        String Actual = PasswordAssertion.getText();
        String Expected = "";
        Assert.assertEquals(Actual,Expected);
    }


    //Alert_FillAllFields
    @Test (priority = 12)
    public void CheckFillAllFieldsAlert ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.ClickOnSubmitButton();
        driver.switchTo().alert().getText();
        String Actual = driver.switchTo().alert().getText();
        String Expected = "please fill all fields";
        newCustomerPage.ClickOnAlert();
        Assert.assertEquals(Actual,Expected);
    }


    // HomeButton
    @Test (priority = 13)
    public void CheckHomeButton ()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.ClickOnHomeButton();
        String Expected = "Welcome To Manager's Page of Guru99 Bank";
        WebElement HomeButtonAssertionElement = driver.findElement(By.xpath("//marquee[@class='heading3']"));
        String Actual = HomeButtonAssertionElement.getText();
        Assert.assertEquals(Actual,Expected);
        homePage.ClickOnNewCustomerButton();
    }


    //AddNewCustomer
    @Test (priority = 15)
    public void AddNewCustomer()
    {
        newCustomerPage = new NewCustomerPage(driver);
        newCustomerPage.EnterCustomerName("Ahmed Tarek");
        newCustomerPage.SelectMaleGender();
        newCustomerPage.EnterDateOfBirth("02/15/2000");
        newCustomerPage.EnterAddress("Makkah Street");
        newCustomerPage.EnterCity("Maadi");
        newCustomerPage.EnterState("Cairo");
        newCustomerPage.EnterPIN("123456");
        newCustomerPage.EnterMobileNumber("01023885538");
        newCustomerPage.EnterEmail("Tayarrr77@gmail.com");
        newCustomerPage.EnterPassword("123456");
        newCustomerPage.ClickOnSubmitButton();
        newCustomerPage.AddWait();
        WebElement AdditionAssertion = driver.findElement(By.xpath("//p[@class='heading3']"));
        String Actual = AdditionAssertion.getText();
        String Expected = "Customer Registered Successfully!!!";
        Assert.assertEquals(Actual,Expected);
        WebElement CustomerID_Element = driver.findElement(By.xpath("//*[@id=\"customer\"]/tbody/tr[4]/td[2]"));
        NewCustomerID_Saved = CustomerID_Element.getText();
        System.out.println(NewCustomerID_Saved);
        newCustomerPage.ClickOnHomeButton();
    }




}
