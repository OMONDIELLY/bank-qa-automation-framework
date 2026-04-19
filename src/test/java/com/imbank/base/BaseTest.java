package com.imbank.base;
import com.microsoft.playwright.*;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;  


public class BaseTest {
    protected static Playwright playwright;
    protected static Browser browser;
    protected static Page page;
    protected static RequestSpecification reqSpec;

    @BeforeSuite
    public void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        reqSpec = RestAssured.given().baseUri("https://api.bank.co.ke/v2");
        
    }

    @AfterSuite
    public void tearDown() {
        if (page != null) page.close();
        if (browser != null) browser.close();
    }
}
