package org.example;

import com.microsoft.playwright.*;

public class TestLocators {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType
                .LaunchOptions()
                .setHeadless(false));

        BrowserContext browserContext1 = browser.newContext(new Browser
                .NewContextOptions()
                .setViewportSize(1920,1080)
        );

        Page page1 = browserContext1.newPage();
        page1.navigate("https://gmail.com");
        //page1.locator("#identifierId").type("Bartosz");
        //page1.locator("[id='identifierId']").type("Bartosz");
        //page1.type("#identifierId", "Bartosz", new Page.TypeOptions().setDelay(100));
        page1.locator("[type='email']").fill("geek");
        //page1.click("text=Dalej");
        page1.click("button:has-text('Dalej')");
        Thread.sleep(5000);
        page1.close();
        playwright.close();
    }
}
