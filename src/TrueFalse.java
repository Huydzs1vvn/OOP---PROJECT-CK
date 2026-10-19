public class TrueFalse extends Question {
    private boolean correctAnswer;

    public TrueFalse(String id, String text, double maxPoints, boolean correctAnswer) {
        super(id, text, maxPoints);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public GradeResult grade(String studentAnswer) {
        // Chuyển chuỗi trả lời (vd: "true") thành kiểu boolean và so sánh
        boolean parsedAnswer = Boolean.parseBoolean(studentAnswer.trim());
        boolean isCorrect = (parsedAnswer == correctAnswer);
        double points = isCorrect ? getMaxPoints() : 0;
        return new GradeResult(points, getMaxPoints(), isCorrect);
    }
}
