package org.example;

import com.microsoft.playwright.*;

public class HandlingTabsAndPopups {
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
        page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/email");
        Page tab1 = page.waitForPopup(() -> {
            page.locator("a[aria-label='Way2Automation\\'s Privacy Policy']").click(
                    new Locator
                            .ClickOptions()
                            .setTimeout(2000));
        });

        tab1.locator("#header-sign-up-btn").click(
                new Locator.ClickOptions()
                        .setTimeout(2000)
        );
        tab1.locator("#name").fill("Bartosz");
        Thread.sleep(2000);
        tab1.close();

        Thread.sleep(5000);

        teardrop(playwright, page);
    }

    public static void teardrop(Playwright playwright, Page page){
        page.close();
        playwright.close();
    }
}
