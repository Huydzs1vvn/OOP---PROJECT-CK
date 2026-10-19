import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== BẮT ĐẦU CHẠY 3 TEST CASE ==========\n");

        runTestCase1_HappyPath();
        runTestCase2_ValidationError();
        runTestCase3_Polymorphism();

        System.out.println("========== KẾT THÚC TEST ==========");
    }

    // ---------------------------------------------------------
    // TEST CASE 1: HAPPY PATH (End-to-End Scenario)
    // Chứng minh toàn bộ hệ thống ráp nối trơn tru, nộp bài thành công
    // ---------------------------------------------------------
    public static void runTestCase1_HappyPath() {
        System.out.println(">>> TEST CASE 1: HAPPY PATH (Luồng cơ bản)");
        try {
            // 1. Tạo câu hỏi (Huy)
            Question q1 = new MultipleChoice("Q1", "1 + 1 = ?", 10.0, Arrays.asList("1", "2", "3"), "2");
            Question q2 = new TrueFalse("Q2", "Trái đất hình tròn?", 10.0, true);
            Question q3 = new ShortAnswer("Q3", "Viết tắt của Object Oriented Programming?", 10.0, "OOP");

            // 2. Tạo Quiz (Kha)
            Quiz quiz = new Quiz("QUIZ_01", "Bài test cơ bản", 60, Arrays.asList(q1, q2, q3));
            
            // 3. Tạo Attempt và Bắt đầu làm bài (Kha)
            Map<String, String> answers = new HashMap<>();
            Attempt attempt = new Attempt(null, null, null, quiz.getQuestions(), answers);

            attempt.start();
            System.out.println("- Trạng thái Attempt sau khi start: " + attempt.getState());

            // 4. Sinh viên điền đáp án
            attempt.getAnswers().put("Q1", "2");
            attempt.getAnswers().put("Q2", "true");
            attempt.getAnswers().put("Q3", "OOP");

            // 5. Nộp bài
            attempt.submit(quiz.getTimeLimit());
            System.out.println("- Trạng thái Attempt sau khi nộp: " + attempt.getState());

            // 6. Chấm điểm
            QuizGrader grader = new QuizGrader();
            List<GradeResult> results = grader.gradeAttempt(attempt);
            double total = grader.calculateTotalScore(results);

            System.out.println("- Tổng điểm đạt được: " + total + "/30.0");
            System.out.println("=> THÀNH CÔNG: Chạy trọn vẹn luồng làm bài!\n");

        } catch (Exception e) {
            System.out.println("Lỗi Test 1: " + e.getMessage());
        }
    }

    // ---------------------------------------------------------
    // TEST CASE 2: VALIDATION / ERROR SCENARIO
    // Chứng minh Encapsulation: Cố tình nộp bài khi chưa bắt đầu làm (Lỗi State)
    // ---------------------------------------------------------
    public static void runTestCase2_ValidationError() {
        System.out.println(">>> TEST CASE 2: VALIDATION ERROR (Bảo vệ trạng thái)");
        try {
            Quiz quiz = new Quiz("QUIZ_02", "Bài test bắt lỗi", 60, Arrays.asList(
                new TrueFalse("Q1", "Câu hỏi test", 10.0, true)
            ));
            
            Attempt attempt = new Attempt(null, null, null, quiz.getQuestions(), new HashMap<>());
            
            System.out.println("- Trạng thái hiện tại: " + attempt.getState());
            System.out.println("- Cố tình nộp bài khi CHƯA BẮT ĐẦU (chưa gọi start())...");
            
            // Cố tình gọi submit khi state đang là NOT_STARTED (Sẽ bị Kha chặn lại)
            attempt.submit(quiz.getTimeLimit());
            
            System.out.println("=> THẤT BẠI: Lẽ ra hệ thống phải báo lỗi!");
        } catch (IllegalStateException e) {
            // Hệ thống ném ra exception đúng như Kha viết trong Attempt.java
            System.out.println("- Bắt lỗi thành công: " + e.getMessage());
            System.out.println("=> THÀNH CÔNG: Tính đóng gói và bảo vệ trạng thái hoạt động đúng!\n");
        }
    }

    // ---------------------------------------------------------
    // TEST CASE 3: POLYMORPHISM (Tính Đa hình)
    // Chứng minh hệ thống tự phân loại chấm điểm mà KHÔNG CẦN if/else
    // ---------------------------------------------------------
    public static void runTestCase3_Polymorphism() {
        System.out.println(">>> TEST CASE 3: POLYMORPHISM (Tính Đa hình)");
        try {
            List<Question> questions = Arrays.asList(
                new MultipleChoice("Q1", "Thủ đô VN?", 10.0, Arrays.asList("Hà Nội", "Huế"), "Hà Nội"),
                new TrueFalse("Q2", "Java là OOP?", 10.0, true),
                new ShortAnswer("Q3", "Môn học tên gì?", 10.0, "Object Oriented Programming")
            );

            // Giả lập chuỗi đáp án (có cái đúng, cái sai, cái chứa khoảng trắng)
            String[] studentAnswers = {"Hà Nội", "false", "  oBject Oriented pRogramming  "};

            System.out.println("- Hệ thống tự động gọi đúng hàm grade() của từng class con:");
            for (int i = 0; i < questions.size(); i++) {
                Question q = questions.get(i);
                String ans = studentAnswers[i];
                
                // GỌI ĐA HÌNH Ở ĐÂY
                GradeResult result = q.grade(ans); 
                
                System.out.println("  + " + q.getClass().getSimpleName() + " chấm chuỗi '" + ans + "' -> " + 
                                   (result.isCorrect() ? "ĐÚNG" : "SAI") + " (" + result.getScoreAchieved() + "đ)");
            }
            System.out.println("=> THÀNH CÔNG: Đa hình hoạt động xuất sắc!\n");

        } catch (Exception e) {
            System.out.println("Lỗi Test 3: " + e.getMessage());
        }
    }
}
