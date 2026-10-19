public class GradeResult {
    // Thuộc tính lưu trữ điểm số và trạng thái
    private double scoreAchieved;
    private double maxPoints;
    private boolean isCorrect;

    // Constructor
    public GradeResult(double scoreAchieved, double maxPoints, boolean isCorrect) {
        this.scoreAchieved = scoreAchieved;
        this.maxPoints = maxPoints;
        this.isCorrect = isCorrect;
    }

    // Các hàm Getter để lấy thông tin
    public double getScoreAchieved() { return scoreAchieved; }
    public double getMaxPoints() { return maxPoints; }
    public boolean isCorrect() { return isCorrect; }
}
