package org.example;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class NonIncognitoWindowTest {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType
                        .LaunchOptions()
                        .setHeadless(false)
        );
        BrowserContext browserContext1 = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1920,1080)
        );
        BrowserContext browserContext2 = playwright.chromium().launchPersistentContext(
                Paths.get(""),
                new BrowserType.LaunchPersistentContextOptions()
                        .setHeadless(false)
                        .setViewportSize(1920, 1080));
        Page page1 = browserContext2.newPage();
        page1.navigate("https://playwright.dev/java/");

        page1.navigate("https://www.google.pl/");

        page1.goBack(new Page.GoBackOptions().setTimeout(500));

        page1.goForward(new Page.GoForwardOptions().setTimeout(500));

        page1.close();
        playwright.close();
    }
}
