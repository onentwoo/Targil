package examstimetable;

import java.util.ArrayList;
import java.util.List;

public class TimeTable {

    public List<Exam> produceTimeTable(String studentID, List<Course> courses) {
        List<Exam> studentExamsTable = new ArrayList<>();

        for (Course course : courses) {
            boolean foundAPlace = false;
            int i = 0;
            while (!foundAPlace && i < course.getExamList().size()) {
                Exam courseExam = course.getExamList().get(i);
                if (studentExamsTable.stream().filter(c -> doesExamsIntersect(c, courseExam)).count()>0) {
                    i++;
                } else {
                    studentExamsTable.add(courseExam);
                    foundAPlace = true;
                }
            }
            if (!foundAPlace) {
                System.out.println("No available timeslots for any exams in course "+course.getName());
            }
        }
        return studentExamsTable;

    }

    private boolean doesExamsIntersect(Exam exam1, Exam exam2) {
        if (exam1.getStartDate().after(exam2.getEndDate()) ) return false;
        if (exam2.getStartDate().after(exam1.getEndDate()) ) return false;
        return true;
    }
}
