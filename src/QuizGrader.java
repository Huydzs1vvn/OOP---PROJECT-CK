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

    public double calculateMaxScore(List<GradeResult> results) {
        double maxScore = 0.0;
        for (GradeResult result : results) {
            maxScore += result.getMaxPoints();
        }
        return maxScore;
    }

    public void printScoreBreakdown(Attempt a, List<GradeResult> results) {
        List<Question> questions = a.getQuestionsOrder();
        if (questions.size() != results.size()) {
            throw new IllegalArgumentException("Questions and grading results must have the same numbers");
        }
        System.out.println("SCORE BREAKDOWN");
        for (int i = 0; i < questions.size(); i++) {
            Question q = questions.get(i);
            GradeResult result = results.get(i);

            String answer = a.getAnswers().get(q.getId());
            if (answer == null || answer.trim().isEmpty()) {
                System.out.printf("%s | Chưa trả lời | Score: %.2f / %.2f | Correct: No", q.getId(), result.getScoreAchieved(), result.getMaxPoints());
            }
            else {
                System.out.printf("%s | Score: %.2f / %.2f | Correct: %s%n", q.getId(), result.getScoreAchieved(), result.getMaxPoints(), result.isCorrect() ? "Yes" : "No");
            }
        }
        System.out.println();
        System.out.printf("Total score: %.2f / %.2f%n", calculateTotalScore(results), calculateMaxScore(results));
    }
}
