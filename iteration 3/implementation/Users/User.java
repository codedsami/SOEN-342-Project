package Users;

public abstract class User{
    private String name;
    private int phoneNumber;

    public User(String name){
        this.name = name;
        this.phoneNumber = -1;
    }

    public User(String name, int phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void viewOfferings(){
        OfferingCatalogue.displayAllOfferings();
    }

    public String getName(){
        return name;
    }
}