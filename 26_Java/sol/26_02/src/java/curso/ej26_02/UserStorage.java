package curso.ej26_02;

import java.util.HashMap;

public class UserStorage {

    private static HashMap<String, User> users;

    static {
        users = new HashMap<String, User>();

        addUser(new User("fry", "timeTravel", "Phillip J. Fry"));
        addUser(new User("bencer", "shinyMetalAss", "Bender B. Rodriguez"));
        addUser(new User("leela", "cyclop", "Turanga Leela"));
        addUser(new User("zoidberg", "fish", "Doctor John A. Zoidberg"));
    }

    public static void addUser(User user) {
        users.put(user.getLogin(), user);
    }

    public static User getUserByLogin(String login) {
        return users.get(login);
    }

    public static User getUserByLoginAndPassword(String login, String password) {
        User user = users.get(login);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
