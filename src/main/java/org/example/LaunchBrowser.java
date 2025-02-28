package org.example;

import com.microsoft.playwright.*;

import java.awt.*;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {

        // Używamy do pobrania rozdzielczości ekranu

        /*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        System.out.println("Rozdzielczosc ekranu");
        System.out.println(width + "---" + height);*/

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType
                        .LaunchOptions()
                            .setHeadless(false)
        );
        BrowserContext browserContext = browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize(1920,1080)
        );
        Page page1 = browserContext.newPage();
        page1.navigate("https://playwright.dev/java/");

        /*Page page2 = browserContext.newPage();
        page2.navigate("https://www.google.pl/");*/

        System.out.println(page1.title());

        Thread.sleep(10000);

        page1.close();
        /*page2.close();*/
        playwright.close();
    }
}