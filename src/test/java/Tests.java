import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class Tests
{

//This class consist of tests. Also consist setUp and tearDown methods which are
//used to set up test with necessarily preconditions which will be executed before each test and to set up conditions
//which will be executed after each test

    private FillOutPage FillOutFormPage;
    private WebDriver driver;

    //Necessary preconditions executed before every test
    @BeforeMethod
    public void SetUp()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\AutomationTests\\Java Selenium\\Ultimate QA\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.ultimateqa.com/filling-out-forms/");
        driver.manage().window().maximize();
        FillOutFormPage = new FillOutPage(driver);
    }

    //Code executed after every test
    @AfterMethod
    public void TearDown()
    {
        driver.close();
        //driver.quit();
    }

    //This test will fill out form but in the 'Result' field will pass negative 1 which will result in the error msg.
    //At the end it verifies that sum expression before clicking on the 'Submit' button is different than the sum expression
    //after clicking on the 'Submit button'

    @Test
    public void Test_verifySumExpressionsAreNotEqual()
    {
        System.out.println("*********Running test Verify Sum Expressions Are Not Equal: "+ "\n");
        FillOutFormPage.fillingTheForm("Test name", "Test message", "-1");
        String sumExpressionBeforeSubmit = FillOutFormPage.getSumExpressionText();
        System.out.println("Sum expression before submit is " + "'" + sumExpressionBeforeSubmit + "'");
        FillOutFormPage.clickOnSubmitButton();
        String sumExpressionAfterSubmit = FillOutFormPage.getSumExpressionText();
        System.out.println("Sum expression before submit is " + "'" + sumExpressionAfterSubmit + "'");
        Assert.assertNotEquals(sumExpressionBeforeSubmit, sumExpressionAfterSubmit, "Sum expressions are equal!!!");


    }

    //This test will fill out form and it will fill out correct 'Result' which will result showing the success msg to
    //the user.At the end it verifies that success msg is equal to 'Success'

    @Test
    public void Test_verifySuccessMsg()
    {
        System.out.println("*********Running test Verify Success Msg: "+ "\n");
        String sumExpressionBeforeSubmit = FillOutFormPage.getSumExpressionText();
        System.out.println("Sum expression before submit is " + "'" + sumExpressionBeforeSubmit + "'");
        int correctResult = Calculation.Addition(sumExpressionBeforeSubmit);
        System.out.println("Correct result is " + correctResult);
        FillOutFormPage.fillingTheForm("Test name", "Test message", String.valueOf(correctResult));
        FillOutFormPage.clickOnSubmitButton();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(FillOutFormPage.SuccessErrorFieldBy));
        System.out.println("Success msg is " + "'" + FillOutFormPage.getSuccessErrorMsgText() + "'\n");
        Assert.assertEquals("Success", FillOutFormPage.getSuccessErrorMsgText());
    }

}
