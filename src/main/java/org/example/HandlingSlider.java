package org.example;

import com.microsoft.playwright.*;

public class HandlingSlider {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false));
        BrowserContext browserContext = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1920,1080));
        Page page = browserContext.newPage();

        page.navigate("https://jqueryui.com/resources/demos/slider/default.html");
        Locator sliderLocator = page.locator("#slider");
        page.mouse().move(sliderLocator.boundingBox().x + sliderLocator.boundingBox().width/2,
                sliderLocator.boundingBox().y + sliderLocator.boundingBox().height/2);
        page.mouse().down();
        page.mouse().move(sliderLocator.boundingBox().x + 1200,
                sliderLocator.boundingBox().y + sliderLocator.boundingBox().height/2);
        page.mouse().up();

        Thread.sleep(5000);

        teardown(page, browserContext, browser, playwright);
    }

    public static void teardown(Page page, BrowserContext browserContext, Browser browser, Playwright playwright){
        page.close();
        browserContext.close();
        browser.close();
        playwright.close();
    }
}
