import java.util.List;
import java.util.ArrayList;
public class MultipleChoice extends Question {
    // TÍNH ĐÓNG GÓI: Đáp án đúng bị giấu đi, biến thành private. 
    // Tránh việc sinh viên dùng Inspect Element lấy đáp án.
    private String correctChoice;
    private List<String> choices;

    public MultipleChoice(String id, String text, double points, List<String> choices, String correctChoice) {
        super(id, text, points); // Gọi constructor của class cha (Question)
        this.choices = new ArrayList<>(choices);
        this.correctChoice = correctChoice;
    }

    public List<String> getChoices() { return choices; }

    // TÍNH ĐA HÌNH: Ghi đè hàm grade() để cung cấp logic chấm điểm riêng cho câu trắc nghiệm
    @Override
    public GradeResult grade(String studentAnswer) {
        // So sánh chuỗi có loại bỏ khoảng trắng (trim) và không phân biệt chữ hoa chữ thường
        boolean isCorrect = studentAnswer.trim().equalsIgnoreCase(correctChoice.trim());
        double score = isCorrect ? getPoints() : 0;
        return new GradeResult(score, getPoints(), isCorrect);
    }
}
