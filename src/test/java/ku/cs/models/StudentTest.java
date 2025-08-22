package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s;
    @BeforeEach
     void init(){
        Student s = new Student("62xxxx", "test");
    }

    @Test
    @DisplayName("เพิ่มคะแนนนิสิต 49 และ 2")
    void testAddScore(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(60);
        assertEquals("C", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเพิ่มคะแนน 85 คะแนน และให้ Object คำนวนเกรดออกมา")
    void testCalculateGrade(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        s.addScore(85);
        assertEquals("A", s.grade());
    }

    @Test
    @DisplayName("ทดสอบการเปลี่ยนชื่อนิสิต")
    void testChangeName(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        String name = " ";
        s.changeName("Julie");
        assertEquals("Julie", s.getName());

    }

    @Test
    @DisplayName("ตรวจสอบความถูกต้องของรหัสนิสิต")
    void testIsId(){
        Student s = new Student("6715555555", "StudentTest");
        assertTrue(s.isId("6715555555"));
        assertFalse(s.isId("StudentTest"));
        assertFalse(s.isId("6587754442"));
    }

    @Test
    @DisplayName("ตรวจสอบความถูกต้องของชื่อนิสิต")
    void testIsNameContains(){
        Student s = new Student("6xxxxxxxxx", "StudentTest");
        assertTrue(s.isNameContains("StudentTest"));
        assertTrue(s.isNameContains("STUDENTtest"));
        assertFalse(s.isNameContains("135791112"));
    }





}