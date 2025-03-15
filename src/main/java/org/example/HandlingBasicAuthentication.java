package org.example;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;

public class HandlingBasicAuthentication {
    public static void main(String[] args) throws InterruptedException {
        PageStarter ps = new PageStarter("admin", "admin");
        ps.page.navigate("https://the-internet.herokuapp.com/basic_auth");
        ps.page.screenshot(new Page.ScreenshotOptions()
                .setPath(
                        Paths.get("C:/Users/Morksil/IdeaProjects/Playwright_Course_01/" +
                                "src/main/resources/screenshots/screenshot.png")
                ));

        Thread.sleep(5000);
        ps.teardown();
    }
}
