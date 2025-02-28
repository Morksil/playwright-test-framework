package org.example;

import com.microsoft.playwright.*;

import java.util.List;

public class HandlingCheckboxes {
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

        page.navigate("http://tizag.com/htmlT/htmlcheckboxes.php");

        // /html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]

        // body > table:nth-child(3) > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr > td > div:nth-child(9)

        Locator block = page.locator("//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[4]");

        Locator checkboxes = block.locator("[type='checkbox']");

        for(int i = 0; i < checkboxes.count(); i++){
            checkboxes.nth(i).click();
        }

        System.out.println(checkboxes.count());

        Thread.sleep(5000);

        page.close();
        playwright.close();
    }
}
