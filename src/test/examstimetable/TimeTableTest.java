package test.examstimetable;

import examstimetable.Exam;
import examstimetable.TimeTable;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TimeTableTest {

    @Test
    public void testTimeTableWithNoCourses() {
        TimeTable testTimeTable = new TimeTable();
        List<Exam> examList =  testTimeTable.produceTimeTable("0", null);


        assertEquals(null, examList);

    }
}