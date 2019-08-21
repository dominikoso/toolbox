package me.dominikoso.toolbox.tools;

public class DeveloperResource {
    private final String name;
    private final String url;

    public DeveloperResource(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}