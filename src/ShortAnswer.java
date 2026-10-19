public class ShortAnswer extends Question {
    private String expectedText;

    public ShortAnswer(String id, String text, double maxPoints, String expectedText) {
        super(id, text, maxPoints);
        this.expectedText = expectedText;
    }

    @Override
    public GradeResult grade(String studentAnswer) {
        // Xử lý chống lỗi nếu sinh viên nộp bài trống
        if (studentAnswer == null || studentAnswer.trim().isEmpty()) {
            return new GradeResult(0, getMaxPoints(), false);
        }

        // Logic đặc biệt: Xóa khoảng trắng 2 đầu và so sánh không phân biệt hoa thường
        String cleanedStudentAnswer = studentAnswer.trim();
        String cleanedExpectedText = expectedText.trim();

        boolean isCorrect = cleanedStudentAnswer.equalsIgnoreCase(cleanedExpectedText);
        double points = isCorrect ? getMaxPoints() : 0;
        return new GradeResult(points, getMaxPoints(), isCorrect);
    }
}
