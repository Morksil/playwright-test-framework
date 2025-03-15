package org.example;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class TestAssertions {
    public static void main(String[] args) throws InterruptedException {
        PageStarter ps = new PageStarter();
        ps.page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");
        assertThat(ps.page).hasURL("http://www.tizag.com/htmlT/htmlcheckboxes.php");
        assertThat(ps.page).hasTitle("HTML Tutorial - Checkboxes");
        assertThat(ps.page.locator("#menu > a:nth-child(29)")).hasText("HTML - Tags");
        assertThat(ps.page.locator(
                "//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]/input[1]")).isChecked();
        assertThat(ps.page.locator(
                "//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]/input[2]")).isVisible();
        assertThat(ps.page.locator(
                "//html/body/table[3]/tbody/tr[1]/td[2]/table/tbody/tr/td/div[6]/input[3]")).isChecked();

        Thread.sleep(5000);
        ps.teardown();
    }
}
