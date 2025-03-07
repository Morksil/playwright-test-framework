package org.example;

import com.microsoft.playwright.Locator;

public class HandlingDragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        PageStarter page = new PageStarter();
        page.page.navigate("https://jqueryui.com/resources/demos/droppable/default.html");

        Locator draggableLocator = page.page.locator("#draggable");
        Locator droppableLocator = page.page.locator("#droppable");
        page.page.mouse().move(draggableLocator.boundingBox().x + draggableLocator.boundingBox().width/2,
                draggableLocator.boundingBox().y + draggableLocator.boundingBox().height/2);
        page.page.mouse().down();

        Thread.sleep(2000);

        page.page.mouse().move(droppableLocator.boundingBox().x + droppableLocator.boundingBox().width/2,
                droppableLocator.boundingBox().y +droppableLocator.boundingBox().height/2);
        page.page.mouse().up();

        Thread.sleep(5000);

        page.teardown();
    }
}
