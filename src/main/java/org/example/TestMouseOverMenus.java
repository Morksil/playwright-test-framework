package org.example;

import com.microsoft.playwright.*;

public class TestMouseOverMenus {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));
        BrowserContext browserContext = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1920, 1080));
        Page page = browserContext.newPage();
        page.navigate("https://www.way2automation.com/");
        page.locator(
                "//li[@id='menu-item-27580']//span[@class='menu-text'][normalize-space()='All Courses']")
                .hover();
        page.locator(
                "//li[@id='menu-item-27592']//span[@class='menu-text'][normalize-space()='DevOps']")
                .click();

        Thread.sleep(5000);

        teardown(playwright, page, browser, browserContext);
    }

    public static void teardown(Playwright playwright, Page page, Browser browser, BrowserContext browserContext){

        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }
}
