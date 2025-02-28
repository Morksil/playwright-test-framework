package org.example;

import com.microsoft.playwright.*;

public class HandlingAlerts {
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
        page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");
        page.onDialog(dialog ->  {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            dialog.accept();

            System.out.println(dialog.message());
        });
        page.locator("[type='submit']").click();
        Thread.sleep(5000);

        page.close();
        playwright.close();
    }
}
