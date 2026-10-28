import java.util.Arrays;
import java.util.List;
import java.util.Map;
import exceptions.AttemptExpiredException;
import exceptions.QuizNotStartedException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== BẮT ĐẦU CHẠY TEST CASE ==========\n");

        runTestCase1_HappyPath();
        runTestCase2_ValidationError();
        runTestCase3_Polymorphism();
        runTestCase4_ScoreBreakDownAndCalculation();
        runTestCase5_QuestionOrderRandomization();
        runTestCase_FullCompletedTest();

        System.out.println("========== KẾT THÚC TEST ==========");
    }
    // TEST CASE 1: HAPPY PATH (End-to-End Scenario)
    // Chứng minh toàn bộ hệ thống ráp nối trơn tru, nộp bài thành công
    public static void runTestCase1_HappyPath() {
        System.out.println(">>> TEST CASE 1: HAPPY PATH (Luồng cơ bản)");
        try {
            // 1. Tạo câu hỏi
            Question q1 = new MultipleChoice("Q1", "1 + 1 = ?", 10.0, Arrays.asList("1", "2", "3"), "2");
            Question q2 = new TrueFalse("Q2", "Trái đất hình tròn?", 10.0, true);
            Question q3 = new ShortAnswer("Q3", "Viết tắt của Object Oriented Programming?", 10.0, "OOP");

            // 2. Tạo Quiz
            Quiz quiz = new Quiz("QUIZ_01", "Bài test cơ bản", 60, Arrays.asList(q1, q2, q3)); //bài quiz này gồm 3 câu hỏi mới tạo trên
            
            // 3. Tạo Attempt trống và Bắt đầu làm bài
            Map<String, String> emptyAnswers = new HashMap<>();
            Attempt attempt = new Attempt(null, null, null, quiz.getQuestions(), emptyAnswers);
            attempt.start();
            System.out.println("Trang thai học sinh A sau khi start: " + attempt.getState());

            // 4. Sinh viên A và B điền đáp án (DÙNG HÀM MỚI TẠO Ở BƯỚC 1)
            attempt.answerQuestion("Q1", "2");
            attempt.answerQuestion("Q2", "true");
            attempt.answerQuestion("Q3", "OOP");

            // 5. Nộp bài
            attempt.submit(quiz.getTimeLimit());
            System.out.println("- Trạng thái học sinh A sau khi nộp: " + attempt.getState());
        } 
        catch (Exception e) {
            System.out.println("Lỗi Test 1: " + e.getMessage());
            System.out.println("\n");
        }
    }

    // TEST CASE 2: VALIDATION / ERROR SCENARIO
    // Chứng minh Encapsulation: Cố tình nộp bài khi chưa bắt đầu làm (Lỗi State)
   public static void runTestCase2_ValidationError() {
    // --- KỊCH BẢN 2.1: Nộp bài khi CHƯA bắt đầu ---
    System.out.println(">>> TEST CASE 2.1: VALIDATION ERROR (Bảo vệ trạng thái - Chưa bắt đầu)");
    try {
        Quiz quiz = new Quiz("QUIZ_02", "Bài test bắt lỗi", 60, Arrays.asList(
            new TrueFalse("Q1", "Câu hỏi test", 10.0, true)
        ));
        Attempt attempt = new Attempt(null, null, null, quiz.getQuestions(), new HashMap<>());
        
        System.out.println("- Trạng thái hiện tại: " + attempt.getState());
        System.out.println("- Cố tình nộp bài khi CHƯA BẮT ĐẦU (chưa gọi start())...");
        
        attempt.submit(60); // Sẽ văng lỗi QuizNotStartedException ở đây
        
    } catch (QuizNotStartedException e) {
        System.out.println("- Bắt lỗi thành công: " + e.getMessage());
        System.out.println("=> THÀNH CÔNG: Tính đóng gói và bảo vệ trạng thái hoạt động đúng!\n");
    }

    // --- KỊCH BẢN 2.2: Nộp bài khi ĐÃ QUÁ GIỜ ---
    // --- KỊCH BẢN 2.2: Nộp bài khi ĐÃ QUÁ GIỜ ---
    System.out.println(">>> TEST CASE 2.2: VALIDATION ERROR (Bảo vệ thời gian làm bài)");
    try {
        Quiz quiz2 = new Quiz("QUIZ_TIMEOUT", "Bài test quá giờ", 60, Arrays.asList(
            new TrueFalse("Q2", "Câu hỏi test", 10.0, true)
        ));
        Attempt timeoutAttempt = new Attempt(null, null, null, quiz2.getQuestions(), new HashMap<>());
        
        timeoutAttempt.start(); 
        
        System.out.println("- Trạng thái hiện tại: " + timeoutAttempt.getState() + " nhưng giả lập đã hết giờ");
        System.out.println("- Cố tình nộp bài...");
        
        // HACK: Dùng Reflection tua thời gian bắt đầu (startedAt) về 65 phút trước
        java.lang.reflect.Field field = timeoutAttempt.getClass().getDeclaredField("startedAt");
        field.setAccessible(true);
        Object startTime = field.get(timeoutAttempt);
        if (startTime instanceof java.time.LocalDateTime) {
            field.set(timeoutAttempt, ((java.time.LocalDateTime) startTime).minusMinutes(65));
        } else if (startTime instanceof java.util.Date) {
            field.set(timeoutAttempt, new java.util.Date(((java.util.Date) startTime).getTime() - 65 * 60 * 1000));
        }
        
        // Truyền 60 phút như bình thường, hệ thống sẽ tự phát hiện đã trễ 5 phút
        timeoutAttempt.submit(60); 
        
    } catch (exceptions.AttemptExpiredException e) {
        System.out.println("- Bắt lỗi quá giờ thành công: " + e.getMessage());
        System.out.println("=> THÀNH CÔNG: Hệ thống chặn nộp bài trễ hạn xuất sắc!\n");
    } catch (Exception e) {
        System.out.println("- Lỗi không mong muốn: " + e.getMessage());
    }

    System.out.println("Chương trình tiếp tục chạy các test case khác...\n");
}

    // TEST CASE 3: POLYMORPHISM (Tính Đa hình)
    // Chứng minh hệ thống tự phân loại chấm điểm mà KHÔNG CẦN if/else
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
            System.out.println("\n");
        }
    }

    //TEST CASE 4: Score breakdown and calculation
    public static void runTestCase4_ScoreBreakDownAndCalculation() {
        System.out.println("TEST CASE 4: SCORE BREAKDOWN AND CALCULATION");
        try {
            Question q1 = new MultipleChoice("Q1", "1 + 1 = ?", 10.0, Arrays.asList("1","2","3"),"2");
            Question q2 = new TrueFalse("Q2", "Trái đất có hình tròn.", 10.0, false);
            Question q3 = new ShortAnswer("Q3", "Viết tắt của Object Oriented Programming?", 10.0, "OOP");

            List<Question> questions = Arrays.asList(q1,q2,q3);
            Map<String, String> answers = new HashMap<>();
            Attempt attempt = new Attempt(null, null, null, questions, answers);

            attempt.start();
            attempt.answerQuestion("Q1", "2");
            attempt.answerQuestion("Q2", "true");
            attempt.answerQuestion("Q3", "Oop");

            attempt.submit(60);

            QuizGrader grader = new QuizGrader();
            List<GradeResult> results = grader.gradeAttempt(attempt);
            grader.printScoreBreakdown(attempt, results);
        }
        catch (Exception e) {
            System.out.println("Lỗi Test 4: " + e.getMessage());
            System.out.println("\n");
        }
    }

    //TEST CASE 5: Question Order Randomization
    public static void runTestCase5_QuestionOrderRandomization() {
        System.out.println("TEST CASE 5: QUESTION ORDER RANDOMIZATION");
        try {
            //Tạo các câu hỏi
            Question q1 = new MultipleChoice("Q1", "Argentina đã vô địch World Cup bao nhiêu lần?", 10.0, Arrays.asList("A.1", "B.2", "C.3"), "3");
            Question q2 = new TrueFalse("Q2", "Mặt trời mọc đằng Đông lặn đằng Tây", 10.0, true);
            Question q3 = new ShortAnswer("Q3", "Thủ đô của Anh là gì?", 10.0, "London");
            //Tạo bài quiz bao gồm 3 câu hỏi ở trên
            List<Question> questions = Arrays.asList(q1,q2,q3);
            //Tạo hai Attempt doc lap cho 2 hai sinh viên A và B
            Attempt attemptA = new Attempt(null, null, null, questions, new HashMap<>());
            Attempt attemptB = new Attempt(null, null, null, questions, new HashMap<>());
            
            //Xáo trộn thứ tự các câu hỏi
            System.out.println("Thứ tự câu hỏi sinh viên A");
            for (Question q : attemptA.getQuestionsOrder()) {
                System.out.println(q.getId() + ": " + q.getText());
            }

            System.out.println("Thứ tự câu hỏi sinh viên B");
            for (Question q : attemptB.getQuestionsOrder()) {
                System.out.println(q.getId() + ": " + q.getText());
            }

            //Xáo trộn các lựa chọn(chỉ dùng cho nhóm câu hỏi MultipleChoice)
            System.out.println("Câu hỏi Q1: ");
            System.out.println(q1.getText());
            System.out.println("Sinh viên A chọn: ");
            List<String> choicesA = attemptA.getChoicesOrder("Q1");
            for (int i = 0; i < choicesA.size(); i++) {
                System.out.println(choicesA.get(i));
            }
            System.out.println("Sinh viên B chọn: ");
            List<String> choicesB = attemptB.getChoicesOrder("Q1");
            for (int i = 0; i < choicesB.size(); i++) {
                System.out.println(choicesB.get(i));
            }
        }
        catch (Exception e) {
            System.out.println("Lỗi test 5: " + e.getMessage());
        }
    }

    //TEST CASE: FULL COMPLETED TEST
    public static void runTestCase_FullCompletedTest() {
        System.out.println("FULL COMPLETED TEST");
        Question q1 = new MultipleChoice("Q1", "2 + 2 = ?", 10.0, Arrays.asList("A.1", "B.4", "C.3", "D.5"), "4");
        Question q2 = new TrueFalse("Q2", "1 + 1 = 2", 10.0, true);
        Question q3 = new ShortAnswer("Q3", "What is the capital of VietNam", 10.0, "HaNoi");
        List<Question> questions = Arrays.asList(q1,q2,q3);
        
        final int timeLimitMinutes = 1;
        Quiz quiz = new Quiz("Quiz Test", "Bai kiem tra giua ki", timeLimitMinutes, questions);
        Attempt attempt = new Attempt (null, null, null, quiz.getQuestions(), new HashMap<>());
        QuizGrader grader = new QuizGrader();

        final BlockingQueue<String> inputQueue = new LinkedBlockingQueue<>();
        Thread inputThread = new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNextLine()) {
                try {
                    inputQueue.put(scanner.nextLine());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        });
        inputThread.setDaemon(true);
        inputThread.start();

        try {
            attempt.start();
            long deadlineNanos = System.nanoTime() + TimeUnit.MINUTES.toNanos(quiz.getTimeLimit());
            System.out.println("Bai thi: " + quiz.getTitle());
            System.out.println("Thoi gian: " + quiz.getTimeLimit() + " phut");
            System.out.println("Nhap dap an cho tung cau.Het gio se tu ket thuc bai thi.");
            
            boolean timeExpired = false;
            for (Question question : attempt.getQuestionsOrder()) {
                long remainingNanos = deadlineNanos - System.nanoTime();
                if(remainingNanos <= 0) {
                    timeExpired = true;
                    break;
                }
                System.out.println(question.getId() + ": " + question.getText());
                if (question instanceof MultipleChoice) {
                    List<String> choices = attempt.getChoicesOrder(question.getId());
                    for (String choice : choices) {
                        System.out.println(choice);
                    }
                }
                System.out.println("Your answer: ");
                System.out.flush();

                remainingNanos = deadlineNanos - System.nanoTime();
                if (remainingNanos <= 0) {
                    timeExpired = true;
                    break;
                }
                String answer = inputQueue.poll(remainingNanos, TimeUnit.NANOSECONDS);
                if (answer == null) {
                    timeExpired = true;
                    break;
                }

                attempt.answerQuestion(question.getId(), answer.trim());
                System.out.println();
            }
            
            if(timeExpired || System.nanoTime() >= deadlineNanos) {
                while(!attempt.isExpired(quiz.getTimeLimit())) {
                    Thread.sleep(20);
                }
                System.out.println("HET GIO. BAI THI TU DONG KET THUC");
                System.out.println("Trang thai bai thi" + attempt.getState());
            }
            else {
                attempt.submit(quiz.getTimeLimit());
                System.out.println("NOP BAI THANH CONG");
                System.out.println("Trang thai bai thi" + attempt.getState());
            }
            List<GradeResult> results = grader.gradeAttempt(attempt);
            grader.printScoreBreakdown(attempt, results);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("TEST CASE BI GIAN DOAN" + e.getMessage());
        } catch (QuizNotStartedException | AttemptExpiredException e) {
            System.out.println("KHONG THE HOAN TAT BAI THI" + e.getMessage());
            List<GradeResult> results = grader.gradeAttempt(attempt);
            grader.printScoreBreakdown(attempt, results);
        } catch (Exception e) {
            System.out.println("LOI TEST" + e.getMessage());
        }
    }
}
