package org.example;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class HandlingDropdownList {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(
                new BrowserType
                        .LaunchOptions()
                        .setHeadless(false)
        );
        BrowserContext browserContext = browser.newContext(
                new Browser
                        .NewContextOptions()
                        .setViewportSize(1920, 1080));
        Page page1 = browserContext.newPage();

        page1.navigate("https://www.wikipedia.org/");
//        page1.click("#searchLanguage");


        /*Select by value*/
//        page1.selectOption("select", "Eesti");
//        page1.selectOption("select", "nan");
//        Thread.sleep(5000);
//        page1.selectOption("select", "Cymraeg");

        /*Select by text*/
        page1.selectOption("select", new SelectOption()
                .setLabel("Eesti"));
        Thread.sleep(2000);
        page1.selectOption("select", new SelectOption()
                .setLabel("Afrikaans"));
        Thread.sleep(2000);

        /*Select by index*/
        page1.selectOption("select", new SelectOption()
                .setIndex(10));

        Locator values = page1.locator("select > option");
        System.out.println(values.count());

        for(int i = 0; i<values.count(); i++){
            System.out.println(values.nth(i).innerText() + "------" + values.nth(i).getAttribute("value"));
        }

        List<ElementHandle> values2 = page1.querySelectorAll("select > option");
        System.out.println(values2.size());

        for(int i=0; i<values2.size(); i++){
            System.out.println(values2.get(i).innerText() + "----" + values2.get(i).getAttribute("lang"));
        }
        System.out.println("**************************************************");
        for(ElementHandle value: values2){
            System.out.println(value.innerText() + "____" + value.getAttribute("lang"));
        }

        page1.close();
        playwright.close();
    }
}
