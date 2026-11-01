public class TrueFalse extends Question {
    private boolean correctChoice;

    public TrueFalse(String id, String text, double points, boolean correctChoice) {
        super(id, text, points);
        this.correctChoice = correctChoice;
    }

    @Override
    public GradeResult grade(String studentAnswer) {
        // Chuyển chuỗi trả lời (vd: "true") thành kiểu boolean và so sánh
        if (studentAnswer == null || studentAnswer.trim().isEmpty()) {
            return new GradeResult(0, getPoints(), false);
        }
        boolean parsedAnswer = Boolean.parseBoolean(studentAnswer.trim());
        boolean isCorrect = (parsedAnswer == correctChoice);
        double score = isCorrect ? getPoints() : 0;
        return new GradeResult(score, getPoints(), isCorrect);
    }
}
