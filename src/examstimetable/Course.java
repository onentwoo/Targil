package examstimetable;

import java.util.List;

public class Course {

    private List<Exam> examList;
    private String name;

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, List<Exam> examList) {
        this.examList = examList;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }


}
