package org.example;

import com.microsoft.playwright.*;

import java.nio.file.Paths;

public class TraceViewer {
    public static void main(String[] args) throws InterruptedException {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType
                .LaunchOptions()
                .setHeadless(false));

        BrowserContext browserContext1 = browser.newContext(new Browser
                .NewContextOptions()
                .setViewportSize(1920,1080)
        );
        browserContext1.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));

        Page page1 = browserContext1.newPage();
        page1.navigate("https://gmail.com");
        //page1.locator("#identifierId").type("Bartosz");
        //page1.locator("[id='identifierId']").type("Bartosz");
        //page1.type("#identifierId", "Bartosz", new Page.TypeOptions().setDelay(100));
        page1.locator("[type='email']").fill("geek");
        //page1.click("text=Dalej");
        page1.click("button:has-text('Dalej')");
        browserContext1.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("trace.zip")));
        Thread.sleep(5000);

        page1.close();
        browserContext1.close();
        browser.close();
        playwright.close();
    }
}
