
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class FillOutPage {


    //All web elements located on the page fill-out-form with locators and methods:
    public FillOutPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    //Locators
    @FindBy(how = How.ID, using = "et_pb_contact_name_1")
    WebElement NameField;

    @FindBy(how = How.ID, using = "et_pb_contact_message_1")
    WebElement MessageField;

    @FindBy(how = How.CLASS_NAME, using = "et_pb_contact_captcha_question")
    WebElement SumExpressionField;

    @FindBy(how = How.XPATH, using = "//div [@class = 'et_pb_column et_pb_column_1_2 et_pb_column_1    et_pb_css_mix_blend_mode_passthrough']//button")
    WebElement SubmitButton;

    @FindBy(how = How.NAME, using = "et_pb_contact_captcha_1")
    WebElement ResultField;

    @FindBy(how = How.XPATH, using = "//div[@id = 'et_pb_contact_form_1']//div[@class = 'et-pb-contact-message']")
    WebElement SuccessErrorField;
    //Using By because Expected Conditions in the Test class
    By SuccessErrorFieldBy = By.xpath("//div[@id = 'et_pb_contact_form_1']//div[@class = 'et-pb-contact-message']");




    //Actions on the web elements

    private void fillNameField(String name)
    {
        NameField.sendKeys(name);

    }


    private void fillMessageField(String message)
    {
        MessageField.sendKeys(message);
    }


    private void fillResultField(String result)
    {
        ResultField.sendKeys(result);
    }


    public void clickOnSubmitButton()
    {
        SubmitButton.click();
    }


    public String getSuccessErrorMsgText()
    {
        return SuccessErrorField.getText();
    }

    public String getSumExpressionText()
    {
        return SumExpressionField.getText();
    }

    //Method for filling the form
    public void fillingTheForm(String name, String message, String result)
    {
        fillNameField(name);
        fillMessageField(message);
        fillResultField(result);
    }
}
