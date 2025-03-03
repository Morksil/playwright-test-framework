package org.example;

import com.microsoft.playwright.*;

public class HandlingFrames {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType
                        .LaunchOptions()
                        .setHeadless(false));
        BrowserContext browserContext = browser.newContext(
                new Browser
                        .NewContextOptions()
                        .setViewportSize(1920, 1080));
        Page page = browserContext.newPage();

        Locator.ClickOptions clickOptions_01 =
                new Locator
                        .ClickOptions()
                        .setTimeout(2000);

        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

        page.locator("#accept-choices").click(clickOptions_01);
        Locator frames = page.locator("iframe");
        System.out.println("Number of frames: " + frames.count());
        for(int i = 0; i < frames.count(); i++){
            System.out.println(frames.nth(i).getAttribute("id"));
        }
        page.frameLocator("[name='iframeResult']")
                .locator("body > button")
                .click(clickOptions_01);

        Thread.sleep(5000);

        teardrop(page, playwright);
    }

    public static void teardrop(Page page, Playwright playwright){
        page.close();
        playwright.close();
    }
}

