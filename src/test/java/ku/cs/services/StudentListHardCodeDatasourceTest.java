package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

class StudentListHardCodeDatasourceTest {
    StudentHardCodeDatasource hardDs;
    StudentListHardCodeDatasource listHardDs;

    @BeforeEach
    void setUp() {
        hardDs = new StudentHardCodeDatasource();
        listHardDs = new StudentListHardCodeDatasource();
    }


    @Test
    void testListHardDatasource() {
        StudentList list = listHardDs.readData();

        assertEquals(10, list.getStudents().size());


        Student s = list.findStudentById("6710400005");
        assertNotNull(s);
        assertEquals("Fifth", s.getName());
    }

}