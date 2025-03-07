package org.example;

import com.microsoft.playwright.Page;

public class HandlingShadowRootElements {
    public static void main(String[] args) throws InterruptedException {
        PageStarter pageStarter = new PageStarter();

        pageStarter.page.navigate("https://books-pwakit.appspot.com/explore?q=");
        pageStarter.page.locator("#input").fill("Java");


        Thread.sleep(5000);

        pageStarter.teardown();
    }

}
