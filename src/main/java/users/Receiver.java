package users;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Receiver implements User{
    private int id;
    String status;

    public Receiver() {
        this.id = IdCount.generateID();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public void update(String status) {
        if (status.equals("yes")){
            System.out.println("User " + id + ": Your flowers are waiting for you.");
        } else if (status.equals("no")){
            System.out.println("User " + id + ": Your order was not sent.");
        } else {
            System.out.println("Shrek");
        }
    }


}
