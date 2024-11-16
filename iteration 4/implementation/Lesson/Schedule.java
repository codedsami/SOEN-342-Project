package Lesson;

public class Schedule {
    private static int lastGeneratedID = 0;
    private int id;
    private String day;
    private String time;

    public Schedule(String day, String time) {
        this.id = ++lastGeneratedID;
        this.day = day;
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public int getId() {
        return id;
    }

}
