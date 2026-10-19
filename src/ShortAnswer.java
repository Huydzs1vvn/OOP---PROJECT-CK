public class ShortAnswer extends Question {
    private String expectedAnswer;

    public ShortAnswer(String id, String text, double points, String expectedAnswer) {
        super(id, text, points);
        this.expectedAnswer = expectedAnswer;
    }

    @Override
    public GradeResult grade(String studentAnswer) {
        // Xử lý chống lỗi nếu sinh viên nộp bài trống
       if (studentAnswer == null || studentAnswer.trim().isEmpty()) {
            return new GradeResult(0, getPoints(), false);
        }

        // Logic đặc biệt: Xóa khoảng trắng 2 đầu và so sánh không phân biệt hoa thường
        String cleanedStudentAnswer = studentAnswer.trim();
        String cleanedExpectedText = expectedAnswer.trim();

        boolean isCorrect = cleanedStudentAnswer.equalsIgnoreCase(cleanedExpectedText);
        double score = isCorrect ? getPoints() : 0;
        return new GradeResult(score, getPoints(), isCorrect);
    }
}
