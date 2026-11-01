public class FillInTheBlank extends Question {
    private String expectedAnswer;

    // Constructor đã được tinh chỉnh khớp với `Question.java` (nhận id, text, points)
    public FillInTheBlank(String id, String text, double points, String expectedAnswer) {
        super(id, text, points); // Gọi constructor của class cha (id, text, points)
        this.expectedAnswer = expectedAnswer;
    }

    // Minh chứng tính Đa hình: Tự override hàm grade()
    @Override
    public GradeResult grade(String studentAnswer) {
        // Fix rào lỗi Null để bảo vệ an toàn (Encapsulation)
        if (studentAnswer == null || studentAnswer.trim().isEmpty()) {
            return new GradeResult(0.0, this.getPoints(), false); 
        }
        
        // Logic chấm điểm: cắt khoảng trắng và không phân biệt hoa thường
        boolean isCorrect = studentAnswer.trim().equalsIgnoreCase(this.expectedAnswer.trim());
        double scoreAchieved = isCorrect ? this.getPoints() : 0.0;
        
        // Trả về GradeResult đúng thứ tự (scoreAchieved, maxPoints, isCorrect)
        return new GradeResult(scoreAchieved, this.getPoints(), isCorrect); 
    }
}
