package org.example;

public class KeyboardEvents {
    public static void main(String[] args) throws InterruptedException {
        PageStarter pageStarter = new PageStarter();

        pageStarter.page.navigate("https://login.yahoo.com");
        pageStarter.page.locator("#login-username").fill("Morksil");
        pageStarter.page.keyboard().press("Enter");
        pageStarter.page.keyboard().press("Control+A");
        pageStarter.page.keyboard().press("Control+C");

        Thread.sleep(2000);

        pageStarter.page.reload();

        Thread.sleep(2000);

        pageStarter.page.locator("#login-username");
        pageStarter.page.keyboard().press("Control+V");

        Thread.sleep(2000);

        pageStarter.page.keyboard().down("Shift");
        for(int i=0; i<3; i++){
            pageStarter.page.keyboard().press("ArrowLeft");
        }
        pageStarter.page.keyboard().up("Shift");

        Thread.sleep(5000);

        pageStarter.teardown();
    }
}
