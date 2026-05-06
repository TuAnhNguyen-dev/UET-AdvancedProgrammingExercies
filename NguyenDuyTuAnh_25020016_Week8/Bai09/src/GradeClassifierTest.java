import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GradeClassifierTest {

    @Test
    @DisplayName("Kiểm tra phân loại Yếu [0.0, 5.0)")
    void testFailGrade() {
        assertEquals("Yếu", GradeClassifier.classifyGrade(0.0));
        assertEquals("Yếu", GradeClassifier.classifyGrade(3.0));
        assertEquals("Yếu", GradeClassifier.classifyGrade(4.9));
    }

    @Test
    @DisplayName("Kiểm tra phân loại Trung bình [5.0, 6.5)")
    void testAverageGrade() {
        // Test case này sẽ FAIL!
        assertEquals("Trung bình", GradeClassifier.classifyGrade(5.0));
        assertEquals("Trung bình", GradeClassifier.classifyGrade(6.0));
    }

    @Test
    @DisplayName("Kiểm tra phân loại Khá [6.5, 8.0)")
    void testGoodGrade() {
        // Test case này cũng sẽ FAIL!
        assertEquals("Khá", GradeClassifier.classifyGrade(6.5));
        assertEquals("Khá", GradeClassifier.classifyGrade(7.0));
    }

    @Test
    @DisplayName("Kiểm tra phân loại Giỏi [8.0, 10.0]")
    void testExcellentGrade() {
        assertEquals("Giỏi", GradeClassifier.classifyGrade(8.0));
        assertEquals("Giỏi", GradeClassifier.classifyGrade(10.0));
    }
}