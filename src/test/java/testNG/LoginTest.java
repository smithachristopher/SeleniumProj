package testNG;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.example.driver.BaseClass;
import org.example.pages.LoginPage;

import java.io.IOException;

import static org.example.driver.BaseClass.driver;

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
        Assert.assertEquals(loginPage.confirmation.getText(),"Du bist nun bei Contorion angemeldet.");

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
        Assert.assertEquals(loginPage.error.getText(),"Bitte gib dein aktuelles Passwort ein.");
    }

}
