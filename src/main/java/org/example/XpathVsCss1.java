package org.example;

import com.microsoft.playwright.*;

public class XpathVsCss1 {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType
                        .LaunchOptions()
                        .setHeadless(false));
        BrowserContext browserContext = browser.newContext(
                new Browser
                        .NewContextOptions()
                        .setViewportSize(1920,1080));

        Page page = browserContext.newPage();
        page.navigate("https://gmail.com");

        page.locator("//input[@id='identifierId']").type("Bartosz");
        Thread.sleep(5000);

        page.close();
        playwright.close();
    }
}