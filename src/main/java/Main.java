public class Main {
    private static Store newStore  = new Store();
    public static void main(String[] args) {
        System.out.println("Welcome to our store!");
        newStore.Create_Storage();
        newStore.search(1000);
        System.out.println("Goodbye! Have a nice day :-)");
    }
}