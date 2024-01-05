import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {

    protected WebDriver driver;
    LoginPage loginPage;
    protected String NewCustomerID_Saved;
    protected String NewAccountID_Saved;
    protected String NewAccountID_Saved2;
    SoftAssert softAssert = new SoftAssert();

    @BeforeTest
    public void OpenBrowser ()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/V4/index.php");
    }

    @BeforeTest
    public void ValidLogin ()
    {
        loginPage = new LoginPage(driver);
        loginPage.Add_UserID("mngr543685");
        loginPage.Add_Password("EsAnubU");
        loginPage.ClickOnLoginButton();
    }

    @AfterTest
    public void QuitBrowser ()
    {
        driver.quit();
    }

}
