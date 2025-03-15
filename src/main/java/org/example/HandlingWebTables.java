package org.example;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class HandlingWebTables {
    public static void main(String[] args) throws InterruptedException {
        PageStarter ps = new PageStarter();
        ps.page.navigate("https://money.rediff.com/indices/nse/NIFTY-50?src=moneyhome_nseIndices");
        System.out.println("Liczba wierszy w tabeli " +
                ps.page.locator(".dataTable > tbody").locator("tr").count());
        System.out.println("Liczba kolumn w tabeli " +
                ps.page.locator(".dataTable > tbody").locator("tr:first-child")
                        .locator("td").count());
        assertThat(ps.page
                .locator(".dataTable > tbody")
                .locator("tr:nth-child(1)")
                .locator("td:nth-child(2)"))
                .hasText("Nifty");

        ps.page.locator(
                ".dataTable > tbody").allInnerTexts().forEach(
                        text -> System.out.println(text));

        Thread.sleep(5000);
        ps.teardown();
    }
}
