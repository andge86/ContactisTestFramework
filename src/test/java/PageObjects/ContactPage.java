package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {



    public ContactPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "name")
    public WebElement nameTextField;

    @FindBy(id = "email")
    public  WebElement emailTextField;

    @FindBy(id = "phone")
    public  WebElement phoneTextField;

    @FindBy(id = "content")
    public  WebElement messageTextField;


    public ContactPage enterName(String name){
        nameTextField.sendKeys(name);
        return this;
    }

    public ContactPage enterEmail(String email){
        emailTextField.sendKeys(email);
        return this;
    }

    public ContactPage enterPhone(String phone){
        phoneTextField.sendKeys(phone);
        return this;
    }

    public ContactPage enterMessage(String message){
        messageTextField.sendKeys(message);
        return this;
    }
}
