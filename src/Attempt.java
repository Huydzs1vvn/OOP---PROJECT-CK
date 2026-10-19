import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.time.Duration;
public class Attempt {
    LocalDateTime startedAt;        //thời gian bắt đầu làm bài
    LocalDateTime submittedAt;      //thời gian nộp bài
    AttemptState state;             //tình trạng bài thi
    List<Question> questionsOrder;  //lưu thứ tự các câu hỏi (có thể dùng để random thứ tự)
    Map<String, String> answers;    //lưu các câu trả lời của học sinh

    public Attempt(LocalDateTime startedAt, LocalDateTime submittedAt, AttemptState state, List<Question> questionsOrder, Map<String, String> answers) {
        this.startedAt = startedAt;
        this.submittedAt = submittedAt;
        this.state = AttemptState.NOT_STARTED;  //đặt là chưa bắt đầu làm bài thi
        this.questionsOrder = new ArrayList<>(questionsOrder);
        this.answers = new HashMap<>(answers);
    }

    public void start() {
        if (state != AttemptState.NOT_STARTED) {
            throw new IllegalStateException("The exams has already started or submitted.");
        }
        this.startedAt = LocalDateTime.now();   //đánh dấu thời gian bắt đầu làm bài
        this.state = AttemptState.IN_PROGRESS;  //đánh dấu bắt đầu làm bài thi
    }

    public boolean isExpired(int timeLimit) {
        if (timeLimit <= 0) {
            throw new IllegalArgumentException("Time limit must be greater than 0");
        }
        if (state != AttemptState.IN_PROGRESS || startedAt == null) {
            return false;       
        }
        int doTime = (int) Duration.between(startedAt, LocalDateTime.now()).getSeconds();
        //thời gian làm bài tính bằng = thời gian hiện tại - thời gian bắt đầu làm bài(chuyển về giây)
        if (doTime > timeLimit * 60) {
            this.state = AttemptState.EXPIRED;  //đánh dấu bài thi đã hết hạn
            return true;
        } else {
            return false;
        }
    }

    public void submit(int timeLimit) {
        if (state != AttemptState.IN_PROGRESS) {
            throw new IllegalStateException("Only submitted exams when you're in progress.");
        }
        if (isExpired(timeLimit)) this.state = AttemptState.EXPIRED;
        else {
            this.submittedAt = LocalDateTime.now();   //đánh dấu thời gian nộp bài
            this.state = AttemptState.SUBMITTED;      //đánh dấu bài thi đã nộp
        }
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }
    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }
    public AttemptState getState() {
        return state;
    }
    public List<Question> getQuestionsOrder() {
        return new ArrayList<>(questionsOrder);
    }
    public Map<String, String> getAnswers() {
        return new HashMap<>(answers);
    }
}