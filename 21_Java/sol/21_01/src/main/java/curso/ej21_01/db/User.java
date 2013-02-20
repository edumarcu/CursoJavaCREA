package curso.ej21_01.db;

public class User {

    private long id;
    private String name;

    public User() {
        id = 0;
        name = null;
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Equals & HashCode

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    // to String

    @Override
    public String toString() {
        return "#" + id + " " + name;
    }

}
