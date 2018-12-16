package javalesson.patterns.creational;

public class Builder1Lesson {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new VisitCardWebsiteBuilder());
        Website website = director.buildWebsite();
        System.out.println(website);
    }
}
class Website{
    private String name;
    private Cms cms;
    private int price;

    public void setName(String name) {
        this.name = name;
    }
    public void setCms(Cms cms) {
        this.cms = cms;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Website{" +
                "name='" + name + '\'' +
                ", cms=" + cms +
                ", price=" + price +
                '}';
    }
}
enum Cms{
    WORDPRESS, ALIFRESCO
}
abstract class WebsiteBuilder{
    Website website;
    void createWebsite(){
        website = new Website();
    }
    abstract void buildName();
    abstract void buildCms();
    abstract void buildPrice();
    Website getWebsite(){
        return website;
    }
}
class VisitCardWebsiteBuilder extends WebsiteBuilder{
    @Override
    void buildName() {
        website.setName("Visit card");
    }

    @Override
    void buildCms() {
        website.setCms(Cms.WORDPRESS);
    }

    @Override
    void buildPrice() {
        website.setPrice(500);
    }
}
class Director{
    WebsiteBuilder builder;
    public void setBuilder(WebsiteBuilder builder) {
        this.builder = builder;
    }
    Website buildWebsite(){
        builder.createWebsite();
        builder.buildName();
        builder.buildCms();
        builder.buildPrice();
        Website website = builder.getWebsite();
        return website;
    }
}