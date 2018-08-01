package javalesson.patterns.behavioral;

public class TemplateMethod1Lesson {
    public static void main(String[] args) {
        WebsiteTemplate welcomeWebsite = new WelcomePage();
        WebsiteTemplate newsWebsite = new NewsPage();
        welcomeWebsite.showPage();
        newsWebsite.showPage();
    }
}
class WelcomePage extends WebsiteTemplate{

    @Override
    public void showPageContent() {
        System.out.println("Welcome");
    }
}
class NewsPage extends WebsiteTemplate{

    @Override
    public void showPageContent() {
        System.out.println("News");
    }
}
abstract class WebsiteTemplate{
    public void showPage(){
        System.out.println("Header");
        showPageContent();
        System.out.println("Footer");
    }
    public abstract void showPageContent();
}
