package org.example;

import com.microsoft.playwright.*;

import java.util.ArrayList;

public class MaximizeWindow {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");
        Browser browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
                        .setArgs(arguments));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));
        Page page = browserContext.newPage();

        page.navigate("https://www.google.pl/");

        Thread.sleep(10000);

        page.close();
        playwright.close();
    }
}
