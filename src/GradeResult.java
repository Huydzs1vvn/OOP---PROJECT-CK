public class GradeResult {
    // Thuộc tính lưu trữ điểm số và trạng thái
    private double pointsAchieved;
    private double maxPoints;
    private boolean isCorrect;

    // Constructor
    public GradeResult(double pointsAchieved, double maxPoints, boolean isCorrect) {
        this.pointsAchieved = pointsAchieved;
        this.maxPoints = maxPoints;
        this.isCorrect = isCorrect;
    }

    // Các hàm Getter để lấy thông tin
    public double getPointsAchieved() { return pointsAchieved; }
    public double getMaxPoints() { return maxPoints; }
    public boolean isCorrect() { return isCorrect; }
}
