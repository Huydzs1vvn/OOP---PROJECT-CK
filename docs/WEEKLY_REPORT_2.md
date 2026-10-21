### WEEK 2 TASK ALLOCATION
**1. Vũ Thành Huy (Team Leader):**
- Implement Core Classes (Question Group): Code the abstract `Question` class and its three subclasses (`MultipleChoice`, `TrueFalse`, `ShortAnswer`), also `GradeResult` class. Ensure the inheritance hierarchy and the polymorphic `grade()` method function correctly.
- Write Unit Test 1 ("Happy path" end-to-end scenario): Verify that a student can successfully start an attempt, answer questions via `answerQuestion()`, and submit under normal conditions.
- Write Unit Test 2 (Validation / Invariant Test): Develop an automated test for the Validation/Error scenario: Attempt to call `submit()` when the exam is still in `NOT_STARTED` state (before calling `start()`) to prove the system rejects invalid state transitions (Encapsulation check).
- Write Unit Test 3 (Polymorphism / Grading Test): Develop an automated test verifying that the system can accurately grade a mixed list of different question types (`MultipleChoice`, `TrueFalse`, `ShortAnswer`) polymorphically, without relying on `if/else` type-checking logic.
- Individual Teach-back: Explain the specific data protected by the `Question` class and its subclasses (e.g., `correctChoice`, `correctAnswer`, `expectedAnswer`). Analyze the consequences: What would break or allow cheating if these fields were made `public`? Include a hand-traced worked example and relevant test output screenshots as evidence.
- AI Usage Log: Maintain personal AI log detailing tool, date, prompts, output summary, and specifically, the verification method and modifications made.

**2.Trần Hoàng Kha (Team Member):**
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

**Key Commits (Evidence of Work):**
To verify our incremental progress, here are the direct links to our key commits for Week 2 tasks:
* [Commit 15bff40](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/15bff4087f12): Implemented core classes (`Question`, `Attempt`, `QuizGrader`) and added the `answerQuestion()` method.
* [Commit 58531e7](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/58531e73eecb): Executed test plans and uploaded the test output image for the 3 required test cases.
* [Commit 4625ff3](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/4625ff3abdb2): Updated Syllabus Linkage and OOP Principles self-explanation.
* [Commit bdb50e0](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/bdb50e0875d9): Finalized and formatted the Week 2 report.

**AI error**
I used AI to assist in implementing the `Attempt` class, but I encountered a logic issue within the `isExpired(timeLimit)` method. The goal of this method is to determine whether an exam attempt has expired. Specifically, it calculates the time spent by a student—defined as the current time (`LocalDateTime.now`) minus the start time (`startedAt`), converted into seconds—and checks if this value exceeds the `timeLimit`. If it does, the method should return `true`, indicating that the time limit has been reached.
However, a problem arises because when a teacher enters the `timeLimit`, they typically provide the duration in minutes (e.g., 10 or 15 minutes). The program, however, interprets this input as seconds (10 or 15 seconds), which leads to unintended system behavior.
To resolve this, I will convert the `timeLimit` value into seconds by multiplying it by 60.

```java
int doTime = (int) Duration.between(startedAt, LocalDateTime.now()).getSeconds();
        //thời gian làm bài tính bằng = thời gian hiện tại - thời gian bắt đầu làm bài(chuyển về giây)
        if (doTime > timeLimit) {  => We fixed it: if(doTime > timeLimit * 60)
            this.state = AttemptState.EXPIRED;  //đánh dấu bài thi đã hết hạn
            return true;
```

### Syllabus Linkage & OOP Principles (Group Self-Explanation)
To perfectly align with our course syllabus and the specific project requirements, our Week 2 implementation actively demonstrates the following core OOP concepts:

* **Encapsulation:** We strictly encapsulated the internal states of our core classes. The `Attempt` class manages its own lifecycle (`AttemptState`) and timing internally, while the `Question` subclasses (`MultipleChoice`, `TrueFalse`, `ShortAnswer`) hide their specific answer keys. This prevents external entities from bypassing the exam rules or directly reading the correct answers to cheat.
* **Polymorphism:** We implemented an abstract `Question` class with an abstract `grade(String studentAnswer)` method. Each subclass overrides this method to provide its own grading logic. As a result, the system can grade a mixed list of questions polymorphically without relying on procedural `if/else` or `switch` statements to check the question type.
* **Open/Closed Principle (O/C):** Our grading engine (`QuizGrader`) is open for extension but closed for modification. Because the grading logic relies on the polymorphic `grade()` method of the `Question` abstraction, we can easily add new question types in the future (such as a `FillInTheBlank` or `Matching` question) by simply creating a new subclass. The existing `QuizGrader` engine will not require a single line of code edited to support these new types.

### WEEK 3 PLAN
Moving forward to Week 3 (Theme: Features, patterns & refactoring), our team will focus on the following tasks:

1. **Vũ Thành Huy (Team Leader):**
   * **Refactoring & Edge-case Testing:** Write additional unit tests focusing on edge cases (e.g., empty answers, boundary values for timing). Handle custom exceptions properly.
   * **UML Update:** Revise and finalize the UML class diagram to accurately reflect any new architectural changes made during implementation.

2. **Trần Hoàng Kha (Team Member):**
   * **Remaining Features:** Implement remaining exam features required by the prompt, such as randomizing question order and choice order per attempt.
   * **State & Persistence:** Refine the `AttemptState` lifecycle for handling auto-submission on expiration and mock a basic persistence/data-saving mechanism.
