package testNG;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.example.driver.BaseClass;
import org.example.pages.LoginPage;

import java.io.IOException;


public class LoginTest extends BaseClass {
public WebDriver driver;

    @Test(priority = 1)
    public void validLogin() throws InterruptedException, IOException {
        driver=initialization();
        LoginPage loginPage= new LoginPage(driver);
        loginPage.privacy.click();
        loginPage.email.sendKeys("smitha.aries88@gmail.com");
        loginPage.password.sendKeys("Test@1234");
        loginPage.loginButton.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(loginPage.confirmation.getText(),"");

    }

    @Test(priority = 2)
    public void invalidLogin() throws InterruptedException, IOException {
        driver=initialization();
        LoginPage loginPage= new LoginPage(driver);
        loginPage.privacy.click();
        loginPage.email.sendKeys("smitha.aries88@gmail.com");
        loginPage.password.sendKeys("xxxx");
        loginPage.loginButton.click();
        System.out.println(driver.getCurrentUrl());
        Assert.assertEquals(loginPage.error.getText(),"");
    }

}
