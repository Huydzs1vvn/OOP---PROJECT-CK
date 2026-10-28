# WEEKLY REPORT 3
**Theme:** Features, patterns & refactoring

### WEEK 3 TASK ALLOCATION
**1. Vũ Thành Huy (Team Leader):**
- **Refactoring & Exceptions:** Refactor procedural `if/else` logic in `submit()` to use custom OOP exceptions (`QuizNotStartedException`, `AttemptExpiredException`).
- **Edge-case Testing:** Write and execute automated tests focusing on time boundaries (e.g., forcing expiration via Reflection) and state transition violations to prove strict encapsulation.
- **UML Update:** Revise the UML class diagram to match the updated Tuần 3 architecture, specifically including the new exceptions and interactive methods (`answerQuestion`, `printScoreBreakdown`).
- **Teach-back & AI Log:** Maintain personal AI log and prepare the individual teach-back document explaining the before/after refactoring process and how it improved encapsulation.

**2. Trần Hoàng Kha (Team Member):**
- **Score Calculation & Interactive Test:** Implement `printScoreBreakdown()` in `QuizGrader` to compute and display scores per question and overall. Develop the full interactive test using `Scanner` and multithreading to simulate a real exam environment.
- **Randomization:** Implement logic to randomize question order and choice order for each unique attempt.
- **Teach-back & AI Log:** Maintain personal AI log and document the individual teach-back section detailing the implementation of randomized features and interactive grading.

---

### A brief summary of what our team accomplished during WEEK 3
This week, our team successfully finalized the remaining core features, implemented edge-case testing, and significantly refactored the codebase to adhere more strictly to OOP principles. 

**Key Achievements:**
- **Refactoring & Custom Exceptions (Huy's focus):** We eliminated generic exceptions and procedural `if/else` checks for state validation. We introduced `QuizNotStartedException` and `AttemptExpiredException`. The `Attempt` class now throws these specific exceptions, strictly encapsulating its timing and state logic. We proved this by using Reflection in our edge-case test (Test Case 2.2) to simulate a time-out, which the system successfully rejected.
- **Interactive Exam & Randomization (Kha's focus):** We implemented a robust `printScoreBreakdown()` method in `QuizGrader` and built a fully functional interactive threaded test in `Main.java` that accepts user input via `Scanner` and correctly grades the attempt. We also added functionality to shuffle the question and choice orders for each new `Attempt`, preventing cheating in a multi-student scenario.
- **UML Synchronization:** The group's UML diagram (`UML.png`) was entirely redrawn to perfectly align with the current `Main.java` execution, reflecting the new Custom Exceptions and Tuần 3 methods.

**Test Plans Executed:**
+ Test Case 4: Score breakdown calculation verification.
+ Test Case 5: Question and choice order randomization verification.
+ Test Case 2.1 & 2.2: Edge-case validation testing (testing state protection and time boundary limits using Reflection).
+ Full Completed Test: End-to-end interactive exam simulation using console input and multithreading.
*(Detailed test output log has been extracted to `docs/test_output_week3.txt` and UML is updated as `UML.png` in the repository root).*

---

### Key Commits (Evidence of Work):
To verify our incremental progress, here are the direct links to our key commits for Week 3 tasks:

* [Commit 0e20dfb](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/0e20dfb): Refactor: Áp dụng Custom Exception cho class Attempt nhằm cải thiện tính Đóng gói (Encapsulation).
* [Commit 208f89a](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/208f89a): Cập nhật QuizGrader.java: Bổ sung thêm các methods calculateMaxScore và printScoreBreakdown.
* [Commit 42f1965](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/42f1965): Cập nhật Attempt.java: Thêm attribute choicesOrder nhằm mục đích xáo trộn thứ tự câu hỏi (Randomization).
* [Commit 7f629c8](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/7f629c8): Cập nhật Main.java: Bổ sung Test Case 2.2 giả lập hết giờ bằng Reflection, hoàn thiện full bộ test kịch bản lỗi.
* [Commit e4d0e66](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/e4d0e66): Cập nhật Main.java: Thực hiện FULL COMPLETED TEST (Interactive test bằng Scanner và multithreading).
* [Commit 6e21d2a](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/6e21d2a): Cập nhật UML.png: Đồng bộ kiến trúc Tuần 3, bổ sung Custom Exceptions và phương thức mới.
* [Commit efec36d](https://github.com/Huydzs1vvn/OOP---PROJECT-CK/commit/efec36d): Chốt minh chứng log test dưới dạng text file (`test_output_week3.txt`) thay cho ảnh.

---

### WEEK 4 PLAN
Moving forward to Week 4 (Theme: Extend, finalize & prepare defense), our team will focus on the final deliverables:

**1. Vũ Thành Huy (Team Leader):**
- **Extensibility Demo:** Implement a new feature/variant (e.g., adding a new question type like `FillInTheBlank`) to explicitly prove the Open/Closed Principle *without* editing existing `QuizGrader` or `Question` base classes.
- **Defense Preparation:** Prepare 10 self-quiz defense Q&A pairs focusing on encapsulation invariants and architectural trade-offs.

**2. Trần Hoàng Kha (Team Member):**
- **Final Report & Reflection:** Finalize the comprehensive group report, ensuring the mapping of each OOP principle to specific classes/methods is perfectly documented.
- **Defense Preparation:** Prepare responses addressing AI weaknesses, alternative designs considered, and compile the final AI Usage Log.
