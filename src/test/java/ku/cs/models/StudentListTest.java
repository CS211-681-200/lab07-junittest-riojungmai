package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList studentList;

    @BeforeEach
    void init(){
        studentList = new StudentList();
    }

    @Test
    @DisplayName("ทดสอบเพิ่มนิสิตแบบไม่มีคะแนนสอบ")
    void testAddNewStudentWithoutScore(){
        studentList.addNewStudent("6710451003", "riojungmai");
        Student found = studentList.findStudentById("6710451003");

        assertNotNull(found);
        assertEquals("6710451003", found.getId());
        assertEquals("riojungmai", found.getName());
    }

    @Test
    @DisplayName("ทดสอบเพิ่มนิสิตแบบมีคะแนนสอบ")
    void testAddNewStudentWithScore(){
        studentList.addNewStudent("6710451003", "riojungmai", 85.0);
        Student found = studentList.findStudentById("6710451003");

        assertNotNull(found);
        assertEquals("6710451003", found.getId());
        assertEquals("riojungmai", found.getName());
        assertEquals(85.0, found.getScore());
    }

    @Test
    @DisplayName("ทดสอบค้นหาด้วยชื่อ")
    void testFilterByName() {
        studentList.addNewStudent("201", "John");
        studentList.addNewStudent("202", "Jonathan");
        studentList.addNewStudent("203", "Emma");

        StudentList filtered = studentList.filterByName("Jo");

        assertEquals(2, filtered.getStudents().size());
    }

    @Test
    @DisplayName("ทดสอบให้คะแนนและแสดงเกรด")
    void testGiveScoreAndViewGrade() {
        studentList.addNewStudent("301", "Frank", 40.0);
        studentList.giveScoreToId("301", 20.0);

        Student found = studentList.findStudentById("301");
        assertEquals(60.0, found.getScore());

        String grade = studentList.viewGradeOfId("301");
        assertNotNull(grade);
        assertEquals("C", grade);
    }

}
