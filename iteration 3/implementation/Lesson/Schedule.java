package Lesson;

public class Schedule {
    private String day;
    private String time;

    public Schedule(String day, String time) {
        this.day = day;
        this.time = time;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "day='" + day + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

}
