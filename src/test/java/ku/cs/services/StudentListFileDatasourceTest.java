package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListFileDatasourceTest {
    private StudentHardCodeDatasource hardCodeDs;
    private StudentListHardCodeDatasource listHardCodeDs;

    @BeforeEach
    void setUp() {
        hardCodeDs = new StudentHardCodeDatasource();
        listHardCodeDs = new StudentListHardCodeDatasource();
    }

    @Test
    void testFileDatasource() throws Exception {
        String dir = "testdata";
        String file = "students.csv";

        StudentListFileDatasource fileDs = new StudentListFileDatasource(dir, file);

        // เขียนข้อมูลลงไฟล์
        StudentList writeList = new StudentList();
        writeList.addNewStudent("1001", "Alice", 80.0);
        writeList.addNewStudent("1002", "Bob", 60.0);
        fileDs.writeData(writeList);

        // อ่านกลับจากไฟล์
        StudentList readList = fileDs.readData();

        assertEquals(2, readList.getStudents().size());

        Student a = readList.findStudentById("1001");
        assertEquals("Alice", a.getName());
        assertEquals(80.0, a.getScore());
    }
}