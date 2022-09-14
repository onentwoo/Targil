package test.examstimetable;

import examstimetable.TimeTable;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimeTableTest {

    @Test
    public void testTimeTableWithNoCourses() {
        TimeTable testTimeTable = new TimeTable();
        testTimeTable.produceTimeTable("0", null);


        // assertEquals("onetwo", result);

    }
}