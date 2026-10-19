import java.util.List;
import java.util.ArrayList;
public class Quiz {
    private String id;                  //mã của bài thi
    private String title;               //tiêu đề
    private int timeLimit;              //thời gian làm bài
    private List<Question> questions;   //lưu danh sách các câu hỏi

    public Quiz(String id, String title, int timeLimit, List<Question> questions) {
        if (timeLimit <= 0) {
            throw new IllegalArgumentException("Time limit must be greater than 0");
        }
        if (id == null || id.isEmpty() || title == null || title.isEmpty() || questions == null || questions.isEmpty()) {
            throw new IllegalArgumentException("Invalid input parameters");
        }
        this.id = id;
        this.title = title;
        this.timeLimit = timeLimit;
        this.questions = new ArrayList<>(questions);
    }

    public void addQuestion(Question q) {
        if (q == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }
        this.questions.add(q);
    }

    public void removeQuestion(Question q) {
        if (q == null) {
            throw new IllegalArgumentException("Question cannot be null");
        }
        this.questions.remove(q);
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public int getTimeLimit() {
        return timeLimit;
    }
    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }
}
