package org.example;

import com.microsoft.playwright.*;

public class HandlingLinks {
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

        page.navigate("https://wikipedia.org");

        //szukamy po label "a"

        Locator links = page.locator("a");
        System.out.println(links.count());
        for(int i=0; i< links.count();i++){
            System.out.println(links.nth(i).innerText() + " ______ " + links.nth(i).getAttribute("href"));
        }

        // Szukamy wewnątrz bloku
        System.out.println("^&^&^&^&^&^&^&^&^&^&^&^&^&^&^&^&^&^&^&^&^&^");
        Locator block = page.locator("[aria-label='Other projects']");
        Locator insideBlock = block.locator("a");
        System.out.println("Ilość elementów wewnątrz bloku: " + insideBlock.count());
        for(int i = 0; i < insideBlock.count(); i++){
            System.out.println(insideBlock.nth(i).innerText() + " ()()()()() " + insideBlock.nth(i).getAttribute("href"));
        }

        insideBlock.nth(3).click();

        Thread.sleep(5000);

        page.close();
        playwright.close();
    }
}
