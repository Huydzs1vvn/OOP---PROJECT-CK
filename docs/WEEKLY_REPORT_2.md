### WEEK 2 TASK ALLOCATION
1.Vũ Thành Huy (Team Leader):
* **Implement Core Classes (Question Group):** Code the abstract `Question` class and its three subclasses (`MultipleChoice`, `TrueFalse`, `ShortAnswer`), also `GradeResult` class. Ensure the inheritance hierarchy and the polymorphic `grade()` method function correctly.
* **Write Unit Test 1 ("Happy path" end-to-end scenario):** Verify that a student can successfully complete a quiz attempt under normal conditions and receive an accurate score.
* **Write Unit Test 2 (Validation / Invariant Test): Develop an automated test for the Validation/Error scenario: Attempt to call submit() when the exam is still in NOT_STARTED state (before calling start()) to prove the system rejects invalid state transitions.
* **Write Unit Test 3 (Invariant Test):** Develop an automated test for the Validation/Error scenario: Set a `timeLimit` of 1 second, simulate a 2-second delay, and call the submit function to prove the system successfully rejects late submissions (Encapsulation check).
* **Individual Teach-back:** Explain the specific data protected by the `Question` class and its subclasses (e.g., `correctAnswer`). Analyze the consequences: *What would break or allow cheating if this field were made `public`?* Include relevant test output screenshots as evidence.
* **AI Usage Log:** Maintain personal AI log detailing tool, date, prompts, output summary, and specifically, the verification method and modifications made.

2.Trần Hoàng Kha (Team Member):**
* **Implement Core Classes (Quiz Management Group):** Code the `Quiz` class, the `Attempt` class, the `QuizGrader` and enumeration `AttemptState`
* **Group AI Error Report:** Identify and document at least one instance where the AI generated incorrect logic or over-engineered code during development. Explain how the team identified the flaw and the steps taken to correct it for the weekly report.
* **Individual Teach-back:** Explain the invariants protected by the `Attempt` class. Analyze the consequences: *What would happen if the `timeLimit` or `AttemptState` fields were changed to `public` (how could a student cheat)?* Include relevant test output screenshots as evidence.
* **AI Usage Log:** Maintain personal AI log detailing tool, date, prompts, output summary, verification method, and modifications made.



**A brief summary of what our team accomplished during WEEK 2**
This week, our team developed the foundational software structure in Java, based on the UML diagrams defined last week.
Essentially, we have implemented the core classes of the codebase. Additionally, we made two changes/additions to the original UML design: in the `Attempt` class, we added a new method, `public void answerQuestion()`, to allow students to input their answers while taking a quiz. In the `Quiz` class, we introduced a new attribute, `private List<Question> questions`, to store the list of questions.
Finally, we executed three test plans:
+ Test plan 1: "Happy path" end-to-end scenario – testing whether the system functions smoothly.
+ Test plan 2: Validation/error scenario – testing a case involving an invalid state during the quiz-taking process.
+ Test plan 3: Polymorphism/inheritance scenario – verifying the system's use of polymorphism and inheritance, ensuring that the program can automatically categorize and grade responses rather than relying on `if/else` statements.
*TEST CASE IMAGE HAS BEEN UPLOADED (file test_output.png)


**AI error**
I used AI to assist in implementing the `Attempt` class, but I encountered a logic issue within the `isExpired(timeLimit)` method. The goal of this method is to determine whether an exam attempt has expired. Specifically, it calculates the time spent by a student—defined as the current time (`LocalDateTime.now`) minus the start time (`startedAt`), converted into seconds—and checks if this value exceeds the `timeLimit`. If it does, the method should return `true`, indicating that the time limit has been reached.
However, a problem arises because when a teacher enters the `timeLimit`, they typically provide the duration in minutes (e.g., 10 or 15 minutes). The program, however, interprets this input as seconds (10 or 15 seconds), which leads to unintended system behavior.
To resolve this, I will convert the `timeLimit` value into seconds by multiplying it by 60.

int doTime = (int) Duration.between(startedAt, LocalDateTime.now()).getSeconds();
        //thời gian làm bài tính bằng = thời gian hiện tại - thời gian bắt đầu làm bài(chuyển về giây)
        if (doTime > timeLimit) {  => We fixed it: if(doTime > timeLimit * 60)
            this.state = AttemptState.EXPIRED;  //đánh dấu bài thi đã hết hạn
            return true;
