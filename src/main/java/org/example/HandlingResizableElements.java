package org.example;

import com.microsoft.playwright.*;

public class HandlingResizableElements {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));
        BrowserContext browserContext = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1920, 1080));
        Page page = browserContext.newPage();
        page.navigate("https://jqueryui.com/resources/demos/resizable/default.html");
        Locator resizableElementLocator = page.locator("//*[@id='resizable']/div[3]");

        Thread.sleep(2000);

        page.mouse().move(resizableElementLocator.boundingBox().x + resizableElementLocator.boundingBox().width/2,
                resizableElementLocator.boundingBox().y + resizableElementLocator.boundingBox().height/2);
        page.mouse().down();
        page.mouse().move(resizableElementLocator.boundingBox().x + 400,
                resizableElementLocator.boundingBox().y + 400);
        page.mouse().up();

        Thread.sleep(5000);

        teardown(playwright, browser, browserContext, page);


    }

    public static void teardown(Playwright playwright, Browser browser, BrowserContext browserContext, Page page){
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }
}
