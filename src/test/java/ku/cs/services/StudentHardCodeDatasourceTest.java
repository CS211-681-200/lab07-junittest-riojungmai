package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    private StudentHardCodeDatasource hardCodeDs;
    private StudentListHardCodeDatasource listHardCodeDs;

    @BeforeEach
    void setUp() {
        hardCodeDs = new StudentHardCodeDatasource();
        listHardCodeDs = new StudentListHardCodeDatasource();
    }

    @Test
    void testStudentHardCodeDatasourceReturnsStudents() {
        StudentList list = hardCodeDs.readData();
        assertNotNull(list);
        assertEquals(4, list.getStudents().size());

        Student s = list.findStudentById("6710400001");
        assertNotNull(s);
        assertEquals("First", s.getName());
    }

    @Test
    void testStudentListHardCodeDatasourceReturnsStudents() {
        StudentList list = listHardCodeDs.readData();
        assertNotNull(list);
        assertEquals(10, list.getStudents().size());

        Student s = list.findStudentById("6710400005");
        assertNotNull(s);
        assertEquals("Fifth", s.getName());
    }

}