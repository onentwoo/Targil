package examstimetable;

import java.util.ArrayList;
import java.util.List;

public class ExamTimeTable {
/*
Assume a system in which different students are enrolled into different courses.

Task:
Implement the logical component for planning an exam timetable in which there are no two exams at the same time for the same student.
 */

    public static void main(String[] args) {
        String studentID = "0332114";
        List<Course> courses = new ArrayList<>();
        List<Exam> courseExams = new ArrayList<>();
        courseExams.add(new Exam("Genes", "Thu, Dec 31 1998 14:00:50", "Thu, Dec 31 1998 15:00:50"));
        courseExams.add(new Exam("Genes", "Thu, Dec 31 1998 15:00:50", "Thu, Dec 31 1998 16:00:50"));
        courses.add(new Course("Genetics",courseExams));
        List<Exam> course2Exams = new ArrayList<>();
        course2Exams.add(new Exam("String Theory", "Thu, Dec 31 1998 14:00:50", "Thu, Dec 31 1998 15:00:50"));
        course2Exams.add(new Exam("String Theory", "Thu, Dec 31 1998 15:05:50", "Thu, Dec 31 1998 16:00:50"));
        courses.add(new Course("Physics",course2Exams));
        TimeTable tt = new TimeTable();
        List<Exam> studentExamTable = tt.produceTimeTable(studentID,courses);
        studentExamTable.forEach(exam ->  System.out.println(String.format("Exam %s start Date %s end Date %s",exam.getName(),exam.getStartDate(),exam.getEndDate())));
    }



    /*
        1. put courses with only one exam date first, thant 2 date etc.

     */


}


