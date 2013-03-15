package demo32;

public class User {
    private int id;

    private String name;

    public User() {
    }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // getters & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // to JSON

    public String toJSON() {
        return String.format("{\"id\": %d, \"name\": \"%s\"}",
                    this.id,
                    this.name);
    }
}
