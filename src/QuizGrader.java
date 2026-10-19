import java.util.List;
import java.util.ArrayList;
import java.util.Map;
public class QuizGrader {
    public List<GradeResult> gradeAttempt(Attempt a) {
        List<Question> questions = a.getQuestionsOrder();   
        Map<String, String> answers = a.getAnswers();
        List<GradeResult> results = new ArrayList<>();
        for (Question q: questions) {
            String answer = answers.get(q.getId());
            GradeResult result = q.grade(answer);
            results.add(result);
        }
        return results;
    }

    public double calculateTotalScore(List<GradeResult> results) {
        double totalScore = 0.0;
        for (GradeResult result: results) {
            totalScore += result.getScoreAchieved();
        }
        return totalScore;
    }
}
