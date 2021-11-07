package users;

public class IdCount {
    static int id;

    public static int generateID() {
        id += 1;
        return id;
    }
}