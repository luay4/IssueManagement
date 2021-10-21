package demo;

public class Issue {

    private String description;

    public Issue(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
