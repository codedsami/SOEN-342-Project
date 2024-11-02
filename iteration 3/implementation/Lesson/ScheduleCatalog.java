package Lesson;
import java.util.ArrayList;

public class ScheduleCatalog {
    private static ScheduleCatalog instance = new ScheduleCatalog();
    private ArrayList<Schedule> scheduleList;

    private ScheduleCatalog() {
        scheduleList = new ArrayList<Schedule>();
    }

    public static ScheduleCatalog getInstance(){
        return instance;
    }

    public Schedule addSchedule(String day, String time){
        Schedule schedule = new Schedule(day,time);
        scheduleList.add(schedule);
        return schedule;
    }

}