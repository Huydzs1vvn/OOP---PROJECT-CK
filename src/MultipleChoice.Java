import java.util.List;

public class MultipleChoice extends Question {
    // TÍNH ĐÓNG GÓI: Đáp án đúng bị giấu đi, biến thành private. 
    // Tránh việc sinh viên dùng Inspect Element lấy đáp án.
    private String correctAnswer;
    private List<String> options;

    public MultipleChoice(String id, String text, double maxPoints, List<String> options, String correctAnswer) {
        super(id, text, maxPoints); // Gọi constructor của class cha (Question)
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public List<String> getOptions() { return options; }

    // TÍNH ĐA HÌNH: Ghi đè hàm grade() để cung cấp logic chấm điểm riêng cho câu trắc nghiệm
    @Override
    public GradeResult grade(String studentAnswer) {
        // So sánh chuỗi có loại bỏ khoảng trắng (trim) và không phân biệt chữ hoa chữ thường
        boolean isCorrect = studentAnswer.trim().equalsIgnoreCase(correctAnswer.trim());
        double points = isCorrect ? getMaxPoints() : 0;
        return new GradeResult(points, getMaxPoints(), isCorrect);
    }
}
