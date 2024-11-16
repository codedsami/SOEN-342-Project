package Lesson;
import java.sql.ResultSet;
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
        DBController.getInstance().insertSchedule(schedule);
        return schedule;
    }

    public void populateScheduleCatalog(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                String day = resultSet.getString("day");
                String time = resultSet.getString("time");
                Schedule schedule = new Schedule(day, time);
                scheduleList.add(schedule);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Schedule getById(int schedule) {
        for (Schedule s : scheduleList) {
            if (s.getId() == schedule) {
                return s;
            }
        }
        return null;
    }
}