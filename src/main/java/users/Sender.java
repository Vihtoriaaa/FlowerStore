package users;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Sender implements User{
    private int id;

    public Sender() {
        this.id = IdCount.generateID();
    }
    @Override
    public void update(String status) {
        if (status.equals("yes")){
            System.out.println(status + ": User " + id + " your order have been successfully updated.\nSoon it will be delivered.");
        } else if (status.equals("no")){
            System.out.println(status + ": User " + id + " your order can't be send.");
        } else {
            System.out.println("Shrek");
        }
    }
    public int getId(int id) {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
