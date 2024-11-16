package Lesson;

public class Location {
    private static int lastGeneratedID = 0;
    private int id;
    private String name;
    private String address;
    private String city;

    public Location(String name, String address, String city) {
        this.id = ++lastGeneratedID;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getId() {
        return id;
    }

}
