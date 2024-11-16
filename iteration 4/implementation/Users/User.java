package Users;

import Lesson.OfferingCatalog;

public abstract class User{
    private static int lastGeneratedID = 0;
    private int id;
    private String name;
    private int phoneNumber;

    public User(String name){
        this.id = ++lastGeneratedID;
        this.name = name;
        this.phoneNumber = -1;
    }

    public User(String name, int phoneNumber){
        this.id = ++lastGeneratedID;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public void viewOfferings(){
        OfferingCatalog.displayAllOfferings();
    }

    public String getName(){
        return name;
    }

    public int getId() {
        return id;
    }
}