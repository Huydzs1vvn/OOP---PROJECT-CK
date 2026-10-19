public abstract class Question {
    // TÍNH ĐÓNG GÓI (Encapsulation): 
    // Các thuộc tính được để private để bên ngoài không tự ý sửa đổi (ví dụ: hack thay đổi điểm tối đa)
    private String id;
    private String text;
    private double points;

    // Constructor để khởi tạo câu hỏi
    public Question(String id, String text, double points) {
        this.id = id;
        this.text = text;
        this.points = points;
    }

    // Các hàm Getter để cho phép bên ngoài đọc dữ liệu (nhưng không được ghi/sửa)
    public String getId() { return id; }
    public String getText() { return text; }
    public double getPoints() { return points; }

    // TÍNH ĐA HÌNH (Polymorphism): 
    // Hàm chấm điểm này là abstract (trừu tượng), không có thân hàm.
    // Nó ép buộc các class con (MultipleChoice, TrueFalse...) phải tự viết logic chấm điểm riêng.
    public abstract GradeResult grade(String studentAnswer);
}
