package org.example;

import com.microsoft.playwright.Download;
import com.microsoft.playwright.FrameLocator;

import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadingDownloadingFiles {
    public static void main(String[] args) throws InterruptedException {
        PageStarter pageStarter = new PageStarter();
        boolean oneFileCondition = false;
        boolean multipleFilesCondition = false;
        boolean downloadingFileCondition = true;

        if (oneFileCondition){
            pageStarter.page.navigate("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");
            pageStarter.page.locator("input[type='file']").setInputFiles(
                    Paths.get("F:/Bloons TD 6/thumbnails/SpicyIslands_Hard_Impoppable.png"));
        }
        if(multipleFilesCondition){
            pageStarter.page.navigate("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_multiple");
            FrameLocator frameLocator = pageStarter.page.frameLocator("#iframeResult");
            frameLocator.locator("#files").setInputFiles(
                    new Path[] {
                            Paths.get("F:/Bloons TD 6/thumbnails/SpicyIslands_Hard_CHIMPS.png"),
                            Paths.get("F:/Bloons TD 6/thumbnails/SpicyIslands_Hard_HalfCash.png")});
        }
        if(downloadingFileCondition){
            pageStarter.page.navigate("https://www.selenium.dev/downloads/");
            Download downloadedFile = pageStarter.page.waitForDownload(() -> {
                pageStarter.page.locator(
                        "body > div > main > div:nth-child(5) > div.col-sm-6.py-3.ps-0.pe-3 > " +
                                "div > div > p:nth-child(1) > a").click();
            });
            downloadedFile.saveAs(
                    Paths.get(
                            "C:/Users/Morksil/IdeaProjects/Playwright_Course_01/src/main/resources/files/selenium.jar"));
        }

        Thread.sleep(5000);
        pageStarter.teardown();
    }
}
