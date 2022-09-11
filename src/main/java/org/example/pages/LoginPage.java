package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.example.driver.BaseClass;

public class LoginPage extends BaseClass {

    @FindBy(xpath="//button[@id=\"popin_tc_privacy_button\"]")
    public  WebElement privacy;

    @FindBy(xpath="//*[@data-qa=\"loginButtonSubmit\"]")
     public  WebElement loginButton;

    @FindBy(xpath="//input[@id='login_email']")
    public WebElement email;

    @FindBy(xpath ="//input[@id='login_password']" )
    public WebElement password;

    @FindBy(xpath ="//div[contains(text(),\"Du bist nun bei Contorion angemeldet.\")]" )
    public WebElement confirmation;

    @FindBy(xpath ="//div[contains(text(),\"Bitte gib dein aktuelles Passwort ein.\")]" )
    public WebElement error;





    public LoginPage(WebDriver driver){
    this.driver= driver;
        PageFactory.initElements(driver,this);

 }

}
