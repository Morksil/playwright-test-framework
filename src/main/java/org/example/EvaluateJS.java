package org.example;

public class EvaluateJS {
    public static void main(String[] args) throws InterruptedException {
        PageStarter pageStarter = new PageStarter();
        pageStarter.page.navigate("https://google.com");
        System.out.println(pageStarter.page.evaluate("document.location.href"));

        Thread.sleep(5000);

        pageStarter.page.evaluate("() => {" +
                "const textarea = document.createElement('textarea');" +
                "textarea.id = 'myTextarea';" +
                "document.body.append(textarea);" +
                "textarea.focus();" +
                "}");

        String text = "Tekst w nowoutworzonym polu tekstowym!";

        pageStarter.page.evaluate("(text) => {" +
                "document.getElementById('myTextarea').value = text;" +
                "}", text);

        Thread.sleep(2000);

        pageStarter.page.fill("#myTextarea", "Drugie wypełnienie!");

        Thread.sleep(5000);

        pageStarter.teardown();
    }
}
