package webservice.entity;

public class Issue {
    private String name;

    public Issue() {
    }

    public Issue(String name, String type) {

        this.name = name;
        this.type = type;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
