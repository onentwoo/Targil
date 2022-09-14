package examstimetable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exam {

    private Date startDate;
    private Date endDate;

    public Exam() {

    }

    public Exam(String name, Date startDate, Date endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Exam(String name, String startDate, String endDate) {
        this.name = name;
        SimpleDateFormat dateFormatter =new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");
        try {
            this.startDate = dateFormatter.parse(startDate);
            this.endDate = dateFormatter.parse(endDate);
        } catch (ParseException e) {
            System.out.println("Exam dates format cannot be parsed");
            e.printStackTrace();
        }

    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }




}
