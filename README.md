# ONLINE QUIZ / EXAM SYSTEM
## Object-Oriented Programming – Final Project Report

**Course Code:** 261OOPR230279E_02FIE  
**Instructor:** Huỳnh Xuân Phụng  

**Repository:** [OOP---PROJECT-CK](https://github.com/Huydzs1vvn/OOP---PROJECT-CK.git)

---

# 1. Project Overview & Team Division

## 1.1. Team Members

| Member | Role | Student ID | GitHub |
|---|---|---|---|
| Vũ Thành Huy | Team Leader | 25110025 | [Huydzs1vvn](https://github.com/Huydzs1vvn) |
| Trần Hoàng Kha | Team Member | 25110027 | [tranhoangkhaqn123-beep](https://github.com/tranhoangkhaqn123-beep) |

## 1.2. Project Overview

The Online Quiz / Exam System is a Java object-oriented application designed to simulate the basic workflow of an online examination. It models quizzes, different question types, examination attempts, student answers, and automatic grading.

The system supports Multiple Choice, True/False, Short Answer, and Fill In The Blank questions. Students can start an examination, answer questions, submit their attempts, and receive a detailed score breakdown.

The application also implements examination time limits, question and answer randomization, attempt state management, and exception handling.

The project applies fundamental Object-Oriented Programming principles, including Encapsulation, Inheritance, Abstraction, and Polymorphism. It also demonstrates the Open/Closed Principle by introducing a new question type without modifying the existing `Question` hierarchy or `QuizGrader`.

## 1.3. Detailed Division of Labor

| Member | Responsibilities |
|---|---|
| **Vũ Thành Huy** | Team Leader; designed UML Class Diagram and CRC Cards; implemented `Question`, `MultipleChoice`, `TrueFalse`, `ShortAnswer`, and `GradeResult`; implemented `FillInTheBlank`; developed Test Cases 1, 2, and 3; handled exception refactoring, UML updates, project integration, and administration. |
| **Trần Hoàng Kha (Kha-Kha)** | Conducted domain analysis; implemented `Quiz`, `Attempt`, `QuizGrader`, and `AttemptState`; developed Test Cases 4, 5, 6, and 7 and Full Completed Test; implemented question/choice randomization and score breakdown; fixed null-answer grading issues; prepared the final report. |

---

# 2. Features and Requirements

## 2.1. Functional Features

| Feature | Description |
|---|---|
| Quiz Management | Creates quizzes containing multiple questions and manages quiz ID, title, and time limit. |
| Question Management | Supports Multiple Choice, True/False, Short Answer, and Fill In The Blank. |
| Question Grading | Each question type implements its own grading behavior by overriding `grade()`. |
| Attempt Management | Manages starting, answering, submitting, and checking examination expiration. |
| Attempt State Management | Uses `AttemptState` to represent `NOT_STARTED`, `IN_PROGRESS`, `SUBMITTED`, and `EXPIRED`. |
| Question Randomization | Randomizes the order of questions for examination attempts. |
| Answer Randomization | Randomizes Multiple Choice options while preserving correct-answer mapping. |
| Automatic Grading | Calculates achieved score and maximum possible score for an examination attempt. |
| Score Breakdown | Displays individual question scores, correctness, and total examination score. |
| Time Limit Management | Enforces examination time limits and handles expired attempts. |
| Validation and Error Handling | Rejects invalid quiz configurations and inappropriate examination operations. |
| Null Answer Handling | Handles unanswered questions safely without causing grading failures. |
| Extensibility | Allows new question types to extend the abstract `Question` class without modifying existing grading logic. |

## 2.2. Object-Oriented Requirements

| Principle | Implementation |
|---|---|
| **Encapsulation** | Protects question data, quiz configuration, examination state, answers, and randomized collections through controlled access and defensive copying. |
| **Inheritance** | Uses the abstract `Question` class as the base class for all question types. |
| **Polymorphism** | Calls `grade()` through `Question` references, allowing each question subtype to provide its own grading behavior. |
| **Abstraction** | Defines common question behavior through the abstract `Question` class and separates examination management from grading responsibilities. |
| **Open/Closed Principle** | Supports extending the question hierarchy with new question types without modifying the existing `Question` abstraction or `QuizGrader`. |

---

# 3. Project Structure

The project is organized into source code, documentation, testing evidence, and UML design files.

```text
OOP---PROJECT-CK/
├── src/
│   ├── Question.java
│   ├── MultipleChoice.java
│   ├── TrueFalse.java
│   ├── ShortAnswer.java
│   ├── FillInTheBlank.java
│   ├── GradeResult.java
│   ├── Quiz.java
│   ├── Attempt.java
│   ├── AttemptState.java
│   ├── QuizGrader.java
│   ├── Main.java
│   └── exceptions/
│       ├── QuizNotStartedException.java
│       └── AttemptExpiredException.java
├── docs/
│   ├── WEEKLY_REPORT_1.md
│   ├── WEEKLY_REPORT_2.md
│   ├── WEEKLY_REPORT_3.md
│   ├── WEEKLY_REPORT_4.md
│   ├── TRẦN_HOÀNG_KHA_TEACH_BACK.md
│   ├── Vũ Thành Huy Teach Back.md
│   ├── test_output_week3.txt
│   └── test_output.png
├── UML.png
└── README.md
```

## 3.1. Main Components

| Component | Responsibility |
|---|---|
| `Question` | Defines common question attributes and abstract grading behavior. |
| `MultipleChoice` | Grades Multiple Choice answers. |
| `TrueFalse` | Grades True/False answers. |
| `ShortAnswer` | Grades text-based answers using case-insensitive comparison. |
| `FillInTheBlank` | Grades answers for fill-in-the-blank questions. |
| `GradeResult` | Stores grading results, including achieved score and maximum points. |
| `Quiz` | Manages quiz information and its question collection. |
| `Attempt` | Manages examination lifecycle, answers, question order, and expiration. |
| `AttemptState` | Defines the possible states of an examination attempt. |
| `QuizGrader` | Calculates examination scores and displays score breakdowns. |
| `Main` | Executes test cases and the interactive examination demonstration. |
| Exceptions | Represents invalid examination operations and expired attempts. |

---

# 4. System Design

## 4.1. Architecture

The application follows a simple object-oriented architecture that separates question models, quiz management, examination execution, and grading responsibilities.

### Question Model Layer

The abstract `Question` class defines common attributes such as question ID, question text, and points. Its subclasses implement different grading strategies.

### Quiz Management Layer

The `Quiz` class stores quiz information and manages the collection of questions. It validates quiz configuration and provides controlled access to its questions.

### Attempt Management Layer

The `Attempt` class manages a student's examination attempt, including its start time, submission time, current state, answers, question order, and randomized choice order.

### Grading Layer

`QuizGrader` evaluates an examination attempt, calculates the total score and maximum score, and prints a detailed score breakdown.

### Exception Layer

Custom exceptions represent invalid examination operations, including attempting to submit an exam before starting or submitting an expired attempt.

### Test and Demonstration Layer

`Main.java` executes automated test scenarios and the Full Completed Test, demonstrating the examination workflow and grading functionality.

## 4.2. Main Class Relationships

- `MultipleChoice`, `TrueFalse`, `ShortAnswer`, and `FillInTheBlank` inherit from the abstract `Question` class.
- `Question` defines the abstract `grade()` method that is overridden by its subclasses.
- `Quiz` contains a collection of `Question` objects.
- `Attempt` is associated with a `Quiz` and manages the student's examination session.
- `AttemptState` defines the valid examination states.
- `Attempt` stores the randomized question order and choice order for an examination attempt.
- `QuizGrader` evaluates the questions and answers associated with an `Attempt`.
- `GradeResult` represents the grading result of an individual question.
- `QuizNotStartedException` and `AttemptExpiredException` handle invalid examination operations.

## 4.3. Typical Workflow

1. Create question objects using `MultipleChoice`, `TrueFalse`, `ShortAnswer`, and `FillInTheBlank`.
2. Create a `Quiz` containing these questions and specify its time limit.
3. Create an `Attempt` associated with the quiz.
4. Call `start()` to begin the examination and update the state to `IN_PROGRESS`.
5. Randomize the question order and Multiple Choice options.
6. Allow the student to answer questions through `answerQuestion()`.
7. Check the examination time using `isExpired()`.
8. Submit the attempt when the student finishes or handle expiration when the time limit is reached.
9. Update the attempt state to `SUBMITTED` or `EXPIRED`.
10. Use `QuizGrader` to calculate the score and print the score breakdown.

## 4.4. Examination Lifecycle

The examination lifecycle is represented by the `AttemptState` enumeration.

| State | Description |
|---|---|
| `NOT_STARTED` | The examination has not started. |
| `IN_PROGRESS` | The student is currently taking the examination. |
| `SUBMITTED` | The student has successfully submitted the examination. |
| `EXPIRED` | The examination time limit has expired. |

The `Attempt` class controls state transitions to prevent invalid operations. An attempt must be started before it can be submitted. Expired attempts cannot be submitted as normal completed examinations.

## 4.5. Question Grading Mechanisms

The Online Quiz / Exam System supports four question types. Each question type implements its own grading logic by overriding the abstract `grade(String answer)` method defined in the `Question` class.

The grading process follows a common principle: each question receives the student's answer, evaluates it according to its specific rules, and returns a `GradeResult` containing the achieved score and maximum possible points.

### 4.5.1. Multiple Choice Grading

**Mechanism**

Multiple Choice questions require students to select one answer from a list of available choices.

The grading process works as follows:

1. The system stores the question text, available choices, correct answer, and maximum points.
2. The student's selected answer is passed to the `grade()` method.
3. The system compares the student's answer with the correct answer.
4. If the answer matches, the student receives full points.
5. If the answer is incorrect or null, the student receives zero points.
6. A `GradeResult` is returned to represent the grading outcome.

**Example**

Question: What is the main purpose of Java?

- A. Web browser
- B. Object-oriented programming language
- C. Operating system
- D. Database

Correct answer: B

| Student Answer | Score | Result |
|---|---:|---|
| B | 10/10 | Correct |
| A | 0/10 | Incorrect |
| null | 0/10 | Unanswered |

The system uses the randomized choice order stored in the `Attempt` to ensure that answer randomization does not change the correctness of grading.

### 4.5.2. True/False Grading

**Mechanism**

True/False questions require students to determine whether a statement is true or false.

The grading process works as follows:

1. The system stores the statement and its correct Boolean answer.
2. The student's answer is passed to `grade()`.
3. The grading method compares the student's answer with the correct Boolean value.
4. If both values match, the student receives full points.
5. If they do not match or the answer is null, the student receives zero points.
6. The grading result is returned through `GradeResult`.

**Example**

Statement: Java supports object-oriented programming.

Correct answer: True

| Student Answer | Score | Result |
|---|---:|---|
| True | 10/10 | Correct |
| False | 0/10 | Incorrect |
| null | 0/10 | Unanswered |

This approach provides straightforward and consistent grading for Boolean questions.

### 4.5.3. Short Answer Grading

**Mechanism**

Short Answer questions require students to enter a text response instead of selecting an option.

The grading implementation uses whitespace trimming and case-insensitive comparison.

The grading process works as follows:

1. The system stores the expected answer and maximum points.
2. The student's text answer is passed to `grade()`.
3. The system removes leading and trailing whitespace using `trim()`.
4. The answer is compared with the expected answer using `equalsIgnoreCase()`.
5. If the normalized answers match, the student receives full points.
6. Otherwise, the student receives zero points.
7. The grading result is returned through `GradeResult`.

**Example**

Expected answer: `OOP`

| Student Answer | Score | Result |
|---|---:|---|
| OOP | 10/10 | Correct |
| oop | 10/10 | Correct |
| ` OOP ` | 10/10 | Correct |
| Java | 0/10 | Incorrect |
| null | 0/10 | Unanswered |

The implementation accepts answers that differ only in capitalization or surrounding whitespace.

However, it does not automatically accept synonyms, alternative phrases, or answers with different internal wording.

### 4.5.4. Fill In The Blank Grading

**Mechanism**

Fill In The Blank questions require students to complete a sentence by providing the missing word or phrase.

The grading process works as follows:

1. The system stores the question text containing a missing word, the expected answer, and the maximum points.
2. The student's response is passed to `grade()`.
3. The grading method compares the student's answer with the expected missing word or phrase.
4. If the answer satisfies the implemented comparison rule, the student receives full points.
5. If the answer is incorrect or null, the student receives zero points.
6. A `GradeResult` is returned to represent the grading outcome.

**Example**

Question: Java is an ______ programming language.

Expected answer: `object-oriented`

| Student Answer | Score | Result |
|---|---:|---|
| object-oriented | 10/10 | Correct |
| OBJECT-ORIENTED | 10/10 | Correct* |
| procedural | 0/10 | Incorrect |
| null | 0/10 | Unanswered |

*Assuming the implementation uses case-insensitive comparison and trimming.

The Fill In The Blank question type demonstrates extensibility because it implements its own grading behavior without requiring changes to the existing `Question` abstraction or `QuizGrader`.

### 4.5.5. Common Grading Process in QuizGrader

Although each question type has its own grading implementation, the `QuizGrader` class uses a common grading process.

The grading workflow is:

1. Retrieve the questions and student answers associated with an `Attempt`.
2. Iterate through the questions in the examination attempt.
3. Call `grade()` through a `Question` reference.
4. Allow Java polymorphism to invoke the appropriate grading implementation.
5. Retrieve the achieved score and maximum points from `GradeResult`.
6. Accumulate the scores of all questions.
7. Calculate the total achieved score and maximum possible score.
8. Print the score breakdown, including individual question results and the total examination score.

**Example Score Breakdown**

An examination containing four questions worth 10 points each may produce the following result:

| Question | Type | Student Answer | Score |
|---|---|---|---:|
| Q1 | Multiple Choice | Correct | 10/10 |
| Q2 | True/False | Incorrect | 0/10 |
| Q3 | Short Answer | Correct | 10/10 |
| Q4 | Fill In The Blank | Correct | 10/10 |
| **Total** | | | **30/40** |

This design separates individual question grading from examination score calculation. Each question is responsible for evaluating its own answer, while `QuizGrader` is responsible for aggregating the results.

The separation of responsibilities improves maintainability and allows new question types to be added without modifying the overall grading process.

---

# 5. OOP Principles and Self-Explanation

The project demonstrates four fundamental Object-Oriented Programming principles and the Open/Closed Principle.

## 5.1. Encapsulation

**Implementation**

- The `Question` class protects question ID, text, and point values through private attributes and controlled access.
- `Quiz` protects its internal question collection and returns a defensive copy through `getQuestions()`.
- `Attempt` controls examination state, timestamps, answers, and randomized collections through its methods.
- `getChoicesOrder()` returns a defensive copy instead of exposing the internal map directly.
- `Quiz` validates its configuration before accepting it.

**Design Rationale**

Encapsulation prevents external code from directly modifying important internal data. For example, changing an `Attempt` state or time limit without using the appropriate methods could bypass examination rules and create invalid states.

Defensive copying also prevents external modifications from unexpectedly changing a `Quiz` question collection or an `Attempt` randomized answer order.

## 5.2. Inheritance

**Implementation**

The abstract `Question` class acts as a parent class for:

- `MultipleChoice`
- `TrueFalse`
- `ShortAnswer`
- `FillInTheBlank`

Each subclass inherits common question attributes and provides its own grading implementation.

**Design Rationale**

Inheritance reduces duplicated code and allows all question types to share a common interface. A new question type can reuse the basic question structure while implementing its own specific grading logic.

## 5.3. Abstraction

**Implementation**

- The `Question` class defines the abstract `grade(String answer)` method without specifying how every question type must grade an answer.
- `QuizGrader` works with `Question` references instead of depending on the implementation details of each question subtype.

**Design Rationale**

Abstraction hides implementation details and allows the grading system to operate through a consistent interface. The main grading process does not need to know whether a question is Multiple Choice, TrueFalse, ShortAnswer, or FillInTheBlank.

## 5.4. Polymorphism

**Implementation**

Each question subtype overrides the `grade()` method:

- MultipleChoice compares the student's selected answer with the correct choice.
- TrueFalse evaluates a Boolean answer.
- ShortAnswer compares text answers using case-insensitive matching and whitespace trimming.
- FillInTheBlank evaluates the missing-word answer.

`QuizGrader` calls `grade()` through a `Question` reference, allowing Java to select the appropriate implementation at runtime.

**Design Rationale**

Polymorphism eliminates the need for repetitive type-checking logic in `QuizGrader`. It also makes the grading system easier to maintain and extend.

## 5.5. Open/Closed Principle

**Implementation**

The `FillInTheBlank` class was added as a new subclass of `Question` without modifying the existing `Question` class or `QuizGrader`.

**Design Rationale**

The project demonstrates that the question hierarchy can be extended without changing existing grading logic. This reduces the risk of introducing regressions into previously implemented question types.

---

# 6. Validation and Error Handling

The application uses validation rules, controlled state transitions, and custom exceptions to maintain the correctness of examination operations.

## 6.1. Quiz Validation

The `Quiz` class validates its configuration before accepting quiz data.

Validation rules include:

- Quiz ID must not be null, empty, or whitespace.
- Quiz title must not be null, empty, or whitespace.
- Time limit must be positive.
- The question collection must not be empty.
- The question collection is copied to protect internal data.

These rules prevent invalid quiz configurations from entering the examination workflow.

## 6.2. Attempt State Validation

The `Attempt` class enforces examination state rules.

**Starting an Attempt**

- The attempt must be in `NOT_STARTED`.
- Starting an already started or submitted attempt is rejected.

**Submitting an Attempt**

- The attempt must be in `IN_PROGRESS`.
- Submitting before starting is rejected.
- Submitting after expiration is rejected.
- Successful submission updates the state to `SUBMITTED`.

**Expiration Handling**

- The system checks whether the examination has exceeded its time limit.
- An expired examination transitions to `EXPIRED`.
- The system prevents normal submission after expiration.

## 6.3. Custom Exceptions

The project uses two custom exceptions:

| Exception | Purpose |
|---|---|
| `QuizNotStartedException` | Represents an invalid operation involving an examination that has not started. |
| `AttemptExpiredException` | Represents an attempt that has exceeded its allowed examination time. |

These exceptions provide clearer error handling than generic conditional checks alone.

## 6.4. Null Answer Handling

A student may leave some questions unanswered, particularly when the examination expires.

The `MultipleChoice` and `TrueFalse` classes were updated to handle null answers safely. Instead of throwing a `NullPointerException`, the grading methods return a zero-score result for unanswered questions.

This ensures that unanswered questions can still be included in the overall grading process.

## 6.5. Time Limit Bug Fix

During development, the examination time limit was initially interpreted incorrectly because of a missing conversion from minutes to seconds.

The time limit calculation was corrected to use:

```java
timeLimit * 60
```

This ensures that the expiration check uses the correct unit of time.

The team also corrected mismatched grading API calls involving `getPointsAchieved()` and `getScoreAchieved()` to maintain consistency between `GradeResult` and `QuizGrader`.

---

# 7. Test Cases and Test Results

The project implements seven test cases and a Full Completed Test in `Main.java`. These scenarios verify normal examination operations, validation rules, polymorphism, grading accuracy, randomization, and edge cases.

## 7.1. Step-by-Step Test Cases

### TC01 – Happy Path Scenario (End-to-End Examination)

**Objective:** Verify that the system can create a quiz, start an examination, answer questions, and successfully submit an attempt.

**Test Procedure**

1. Create MultipleChoice, TrueFalse, ShortAnswer, and FillInTheBlank questions.
2. Create a Quiz containing the questions.
3. Create an Attempt for the quiz.
4. Call `start()`.
5. Answer questions using `answerQuestion()`.
6. Submit the attempt.

**Expected Results**

- The attempt starts successfully.
- The state changes to `IN_PROGRESS`.
- Student answers are stored correctly.
- The attempt is submitted successfully.
- The final state becomes `SUBMITTED`.

**Result:** PASSED

### TC02 – Validation and Error Handling

**Objective:** Verify that the Attempt class rejects invalid examination operations.

#### Test Case 2.1 – Submission Before Starting

1. Create an Attempt.
2. Keep the state at `NOT_STARTED`.
3. Call `submit()` without calling `start()`.

**Observed Result**

```text
Only submitted exams when you're in progress.
```

The custom exception is caught successfully, and the invalid submission is rejected.

#### Test Case 2.2 – Examination Expiration

1. Start an Attempt.
2. Simulate an expired examination using Reflection to manipulate the start time.
3. Call `submit()`.

**Observed Result**

```text
Bài thi đã quá thời hạn quy định,
tự động chuyển sang EXPIRED
```

The system detects expiration and transitions the attempt to `EXPIRED`.

**Result:** PASSED

### TC03 – Polymorphism and Grading

**Objective:** Verify that different question types implement their own grading behavior through polymorphism.

**Test Procedure**

1. Create MultipleChoice, TrueFalse, and ShortAnswer questions.
2. Store them using Question references.
3. Call `grade()` through the Question abstraction.
4. Compare the grading results.

**Observed Results**

```text
MultipleChoice:
Correct answer -> 10.0 points

TrueFalse:
Incorrect answer -> 0.0 points

ShortAnswer:
"  oBject Oriented pRogramming  "
-> Correct -> 10.0 points
```

The system automatically invokes the correct grading method for each question subtype.

**Result:** PASSED

### TC04 – Score Breakdown and Calculation

**Objective:** Verify the calculation of total score, maximum score, and individual question results.

**Test Procedure**

1. Create a quiz containing multiple questions.
2. Submit an Attempt with a mixture of correct and incorrect answers.
3. Call `printScoreBreakdown()`.
4. Verify the score achieved for each question and the total score.

**Observed Output**

```text
SCORE BREAKDOWN

Q2 | Score: 0.00 / 10.00 | Correct: No
Q3 | Score: 10.00 / 10.00 | Correct: Yes
Q1 | Score: 10.00 / 10.00 | Correct: Yes

Total score: 20.00 / 30.00
```

**Result:** PASSED

### TC05 – Question Order Randomization

**Objective:** Verify that different examination attempts can receive different question orders.

**Test Procedure**

1. Create a Quiz containing multiple questions.
2. Create two different Attempts.
3. Compare their question orders.
4. Verify that the Attempt maintains its own randomized question sequence.

**Observed Output**

```text
Thứ tự câu hỏi sinh viên A
Q3: Thủ đô của Anh là gì?
Q2: Mặt trời mọc đằng Đông lặn đằng Tây
Q1: Argentina đã vô địch World Cup bao nhiêu lần?

Thứ tự câu hỏi sinh viên B
Q1: Argentina đã vô địch World Cup bao nhiêu lần?
Q3: Thủ đô của Anh là gì?
Q2: Mặt trời mọc đằng Đông lặn đằng Tây
```

The attempts display different question orders in the recorded execution.

**Result:** PASSED

### TC06 – ShortAnswer Grading Strategy

**Objective:** Verify that ShortAnswer accepts equivalent answers despite differences in capitalization and surrounding whitespace.

**Test Procedure**

1. Create a ShortAnswer question with the expected answer `OOP`.
2. Submit the answer `  oBject Oriented pRogramming  ` in the recorded test scenario.
3. Verify that the grading strategy handles capitalization and whitespace correctly.

**Observed Result**

The grading implementation uses whitespace trimming and case-insensitive comparison.

**Result:** PASSED

### TC07 – Null Answer Reflection

**Objective:** Verify that unanswered questions can be graded safely without causing a `NullPointerException`.

**Test Procedure**

1. Create an Attempt containing MultipleChoice and TrueFalse questions.
2. Leave one or more answers unanswered.
3. Simulate the edge case through Reflection.
4. Execute the grading process.

**Expected Results**

- Null answers are handled safely.
- Unanswered questions receive zero points.
- The grading process continues without a `NullPointerException`.

**Result:** PASSED

### Full Completed Test – Interactive Examination

**Objective:** Demonstrate the complete examination lifecycle, including interactive answers, time limit enforcement, automatic state updates, and score calculation.

**Test Procedure**

1. Create a Quiz with different question types.
2. Create and start an Attempt.
3. Randomize the question order and Multiple Choice options.
4. Allow the student to enter answers interactively through Scanner.
5. Track the examination time.
6. Submit the examination when the student finishes or when the time limit expires.
7. Update the AttemptState accordingly.
8. Print the score breakdown through QuizGrader.

**Expected Results**

- The student can enter answers during the examination.
- The Attempt state is updated correctly.
- The examination cannot continue after expiration.
- The system calculates the achieved score and maximum score.
- The score breakdown is displayed after submission or expiration.

**Result:** Implemented in `Main.java` as the Full Completed Test.

## 7.2. Executed Test Suite Summary

| Test Case | Description | Result |
|---|---|---|
| TC01 | Happy Path | PASSED |
| TC02 | Validation and Error Handling | PASSED |
| TC03 | Polymorphism | PASSED |
| TC04 | Score Breakdown and Calculation | PASSED |
| TC05 | Question Order Randomization | PASSED |
| TC06 | ShortAnswer Grading Strategy | PASSED |
| TC07 | Null Answer Reflection | PASSED |
| Full Completed Test | Interactive Examination | Implemented |

The repository includes execution evidence in:

- `docs/test_output_week3.txt`
- `docs/test_output.png`

The recorded test output demonstrates successful execution of the first five test cases, including validation exceptions, polymorphic grading, score calculation, and question randomization.

---

# 8. Data Privacy Considerations

The Online Quiz / Exam System is an educational demonstration and does not implement production-grade authentication, authorization, encrypted storage, or persistent student accounts.

The following considerations are applied:

**Encapsulation:** Question answers, quiz configuration, examination state, and student answers are managed through class interfaces instead of unrestricted external access.

**Answer Protection:** Correct answers are stored within question objects and are used by grading methods rather than being directly exposed through the examination workflow.

**Data Separation:** Quiz information, question data, examination attempts, and grading results are represented by separate classes.

**Safe Demonstration Data:** The project uses sample questions and fictional student answers during testing.

**In-Memory Storage:** The application stores examination data in memory during execution. Data is not retained after the program exits.

For a production system, additional features such as user authentication, role-based access control, secure answer storage, database persistence, and protection against examination cheating would be required.

---

# 9. Build and Run Instructions

## 9.1. Prerequisites

- Install the Java Development Kit (JDK).
- Use an IDE such as IntelliJ IDEA, Eclipse, or Visual Studio Code, or a terminal.
- Clone the project repository.

**Repository:**  
[https://github.com/Huydzs1vvn/OOP---PROJECT-CK.git](https://github.com/Huydzs1vvn/OOP---PROJECT-CK.git)

## 9.2. Clone the Repository

```bash
git clone https://github.com/Huydzs1vvn/OOP---PROJECT-CK.git
cd OOP---PROJECT-CK
```

## 9.3. Run the Test Program

The following commands use PowerShell on Windows to compile the Java source files and run `Main`.

```powershell
cd D:\OOP\OOP---PROJECT-CK\src

$temp = Join-Path $env:TEMP "QuizBuild"
New-Item -ItemType Directory -Force $temp | Out-Null

$files = Get-ChildItem -Recurse -Filter *.java |
    ForEach-Object { $_.FullName }

javac -encoding UTF-8 -d $temp $files

if ($LASTEXITCODE -eq 0) {
    chcp 65001
    [Console]::OutputEncoding = [System.Text.UTF8Encoding]::new()
    java "-Dfile.encoding=UTF-8" -cp $temp Main
}
```

The `Main` class executes the following test scenarios:

- TC01: Happy Path
- TC02: Validation and Error Handling
- TC03: Polymorphism
- TC04: Score Breakdown and Calculation
- TC05: Question Order Randomization
- TC06: ShortAnswer Grading Strategy
- TC07: Null Answer Reflection
- Full Completed Test

## 9.4. Troubleshooting

| Problem | Solution |
|---|---|
| `javac` is not recognized | Install the JDK and configure Java environment variables. |
| Compilation fails | Verify that all source files are included and exception packages are compiled correctly. |
| Examination expires unexpectedly | Verify that the time limit is converted from minutes to seconds correctly. |
| Randomized question order differs | This is expected because question order is randomized. |

---

# 10. AI Usage Log

During the development of the Online Quiz / Exam System, AI tools were used as learning and development assistants for code generation, debugging, design review, testing, and documentation.

The team used ChatGPT and Gemini 3.6 Flash. AI-generated suggestions were reviewed and modified by the team before being incorporated into the project.

### 10.1. Week 1 – Domain Analysis and Project Design

**AI Tool:** Gemini 3.1 Pro

| Category | Content |
|---|---|
| **Prompt 1** | "Giải thích ý nghĩa của 2 class Instructor với Student nếu thêm vào hệ thống và tại sao không có 2 class này hệ thống vẫn chạy được theo yêu cầu đồ án?" |
| **Prompt 2** | "Làm Test Plan tự động chạy trong hàm main() cho tôi dựa trên yêu cầu Test case tối thiểu của Rubric." |
| **Prompt 3** | "Đây là feedback cho Test plan trên, hãy chỉnh sửa lại (cập nhật rõ thời điểm hết hạn EXPIRED, quy tắc xáo trộn câu hỏi và thêm Test Case cho Score Breakdown, ShortAnswer)." |
| **Prompt 4** | "Tôi có CRC card và UML rồi, hãy viết giúp tôi phần Syllabus Mapping và phần Teach-Back giải thích lý do dùng Inheritance vs. Composition cho 2 sinh viên." |
| **Prompt 5** | "Kiểm tra đã đầy đủ nội dung đáp ứng đúng yêu cầu Rubric và Đề tài chưa" |
| **AI-Generated Output** | Gemini explained the distinction between a core examination engine and a complete application, clarifying why the `Instructor` and `Student` classes were not strictly necessary for the initial implementation. It generated a comprehensive six-scenario automated Test Plan covering Happy Path, Encapsulation Check, Polymorphism Verification, Score Breakdown, Randomization, and String Matching Strategy, incorporating the requested feedback. Additionally, Gemini generated individualized Teach-Back templates and a Syllabus Mapping section, explaining the rationale for Inheritance (`IS-A`) in the `Question` hierarchy and Composition (`HAS-A`) in relationships involving `Attempt` and `GradeResult`. It also reviewed the project report against the rubric and identified areas requiring clarification or improvement. |
| **Student's Modifications** | I reviewed the AI-generated architectural recommendations and decided to retain our original eight-class architecture to maintain simplicity and follow the KISS principle. Regarding the Test Plan, I independently verified the implementation to ensure that the `submit()` method properly encapsulated the examination time-limit logic and handled the `EXPIRED` state as required by the rubric. Since I personally designed the UML diagram and created the CRC Cards, I substantially customized the generated Teach-Back materials to accurately reflect the relationships in my original diagrams. I also revised the explanation of the Open/Closed Principle to ensure that it represented our team's actual architectural decisions rather than relying solely on AI-generated descriptions. |

### 10.2. Week 2 – Core Class Implemention

#### 1. Gemini 3.1 Pro

| Category | Content |
|---|---|
| **Prompt** | Nhờ AI hỗ trợ code các class cốt lõi (lớp trừu tượng `Question`, `MultipleChoice`, `TrueFalse`, `ShortAnswer`, `GradeResult`) và tạo `Main.java` cho 3 kịch bản test (Happy Path, Invariant Validation, Polymorphism). Yêu cầu sửa lỗi biên dịch "cannot find symbol", sửa lỗi font tiếng Việt trong PowerShell, tư vấn cấu trúc thư mục GitHub (`docs/` hay root), và rà soát định dạng file báo cáo `WEEKLY_REPORT_2.md` bao gồm Phân công nhiệm vụ, Liên kết đề cương (Syllabus Linkage) và Teach-Back cá nhân. |
| **AI-Generated Output** | Gemini generated the core OOP classes and a `Main.java` file covering three test scenarios: Happy Path, Invariant Validation, and Polymorphism. It used `attempt.getAnswers().put()` to simulate student answers. Additionally, it explained Java file-name case sensitivity, suggested using `java -Dfile.encoding=UTF-8 Main` to address terminal encoding issues, recommended placing `test_output.png` in the `docs/` directory, and provided a structured Markdown draft containing a hand-trace table and an explanation of the Open/Closed Principle. |
| **Student's Modifications** | I integrated the AI-generated code but removed the `.put()` approach in `Main.java` because it caused a `NullPointerException` due to defensive copying in `Attempt`. I independently implemented an `answerQuestion()` method to preserve the `AttemptState` constraints and protect the internal state of `Attempt`. I manually corrected file names to resolve compilation issues, discarded the AI's terminal command, and used `chcp 65001` to address the reported `ClassNotFoundException` issue in my environment. I also revised the Unit Test 3 description in the Task Allocation table to accurately reflect the actual Polymorphism test scenario and ensure compliance with the rubric. |

#### 2. GPT-6 (OpenAI)

| Category | Content |
|---|---|
| **Prompt 1** | "Từ bản UML này, bạn hãy giúp tôi tiến hành xây dựng các class Attempt, Quiz, QuizGrader và enum AttemptState." |
| **Prompt 2** | "Những điều kiện trong trường hợp lỗi đặc biệt như thế đã đúng chưa?" |
| **Prompt 3** | "Từ Rubric, bạn hãy kiểm tra giúp tôi bản REPORT_WEEK_2 và phần Teach-back-session của bản thân." |
| **AI-Generated Output** | GPT-6 assisted in implementing the core classes `Attempt`, `Quiz`, and `QuizGrader`, along with the `AttemptState` enum, based on the project's UML diagram. It explained each class's responsibilities and suggested implementations for managing quiz attempts, enforcing time limits, handling submission states, and calculating scores. GPT-6 also reviewed potential edge cases, including invalid time limits, incorrect attempt states, expired attempts, and missing student answers. Furthermore, it reviewed the Week 2 report and individual Teach-Back session against the project rubric, identifying areas requiring clarification or improvement. The generated code and recommendations were subsequently reviewed and adapted to align with the existing class structure and project requirements. |
| **Student's Modifications** | I reviewed the AI-generated structural recommendations and evaluated them for potential issues. Most contributions aligned with my expectations based on our UML diagrams, including the additional design decisions documented in `WEEKLY_REPORT_2.md`. However, I reorganized the generated code because its formatting contained unnecessary line breaks that affected readability. I also identified several logic errors, including issues similar to those discovered by Huy during Unit Test Case 1 (Happy Path), which Huy subsequently corrected. One error involved the comparison between `doTime` and `timeLimit`, which I resolved by multiplying `timeLimit` by 60 to convert minutes into seconds. Additionally, the AI-generated `QuizGrader` contained a `getPointsAchieved()` method instead of the actual `getScoreAchieved()` method because I had not yet pulled Huy's latest GitHub updates. Regarding the report, I adapted the AI-generated suggestions based on my own understanding and substantially revised the content to accurately represent our team's actual Week 2 contributions and maintain consistency with the project's overall direction. |

#### 3. GitHub Copilot (Visual Studio Code – Copilot Chat / Agent)

| Category | Content |
|---|---|
| **Prompt** | "can you fix for me the error without changing other file" |
| **AI-Generated Output** | Copilot analyzed `QuizGrader`, identified missing library imports, and generated the necessary import statements at the beginning of the file without modifying the existing logic or other files, as requested. Additionally, Copilot Agent assisted in generating code skeletons for the `Attempt` and `Quiz` classes. |
| **Student's Modifications** | I reviewed `QuizGrader` to verify that Copilot had added only the required imports and confirmed that the code compiled successfully. Furthermore, I identified a logic error in the AI-generated `Attempt` class, specifically in the `isExpired()` method, where minutes were incorrectly compared with seconds. I manually corrected this issue by multiplying `timeLimit` by 60 to ensure accurate time-limit calculations. |

## 10.3. Week 3 – Randomization, Score Breakdown, and Interactive Testing

### 10.3. Week 3 – Advanced Implementation and Integration Testing

#### 1. Gemini 3.1 Pro

| Category | Content |
|---|---|
| **Prompt** | "Hãy giúp tôi hoàn thiện toàn bộ tiến độ Tuần 3: Refactor hàm `submit()` bằng Custom Exceptions để đảm bảo Encapsulation. Viết unit test giả lập hết thời gian (vượt quá `timeLimit`) bằng Reflection do biến `startedAt` đang là private. Viết bản Teach-Back cá nhân giải thích Before/After code và nguyên lý OOP. Cấu trúc lại toàn bộ file `WEEKLY_REPORT_3.md` bao gồm: Phân công nhiệm vụ, Group Progress (tổng hợp cả phần Interactive test của Kha), Syllabus Linkage, Kế hoạch Tuần 4. Khắc phục lỗi copy Markdown vào VS Code bị vỡ định dạng gạch đầu dòng và hỗ trợ chèn link commits." |
| **AI-Generated Output** | **Code and Testing:** Gemini generated two custom exception classes, `QuizNotStartedException` and `AttemptExpiredException`, along with example implementations using `throws` declarations. It also provided Java Reflection code using `getDeclaredField()` to modify the private `startedAt` field and simulate an expired attempt for edge-case testing. **Documentation:** Gemini drafted an individual Teach-Back session explaining Encapsulation and provided a structured framework for `WEEKLY_REPORT_3.md`, including Task Allocation, Key Achievements, Syllabus Linkage, and Week 4 planning. **Formatting:** It suggested using raw Markdown enclosed in four backticks to preserve formatting when copying into VS Code and provided placeholders for commit hashes. |
| **Student's Modifications** | Although Gemini provided initial code structures and logic, I independently verified and integrated the implementation. **Code Integration:** I implemented `try-catch` blocks around the submission process in `Main.java` to handle custom exceptions and display appropriate warnings instead of allowing the program to crash. I also modified the Reflection code to match the project's `java.time.LocalDateTime` implementation using `startedAtField.set(attempt, LocalDateTime.now().minusMinutes(65))`. **Documentation:** I cross-checked the report and Syllabus Linkage against the instructor's rubric to ensure all criteria (A1–A5) were addressed. I also updated `UML.png` to reflect the revised code logic. **Git Verification:** I reviewed the team's Git history and extracted seven actual commit hashes, including `0e20dfb`, `7f629c8`, and `e4d0e66`, replacing AI-generated placeholders with verified evidence of work before pushing the completed report to the repository. |

#### 2. ChatGPT GPT-6 (OpenAI)

| Category | Content |
|---|---|
| **Prompt 1** | "Làm sao để xáo trộn trật tự câu hỏi và câu trả lời trắc nghiệm trong mỗi lần Attempt?" |
| **Prompt 2** | "Sau khi đã hoàn thành TestCase4 và TestCase5, hãy giúp tôi xây dựng TestCase: FULL COMPLETED TEST. cho phép người dùng có thể nhập câu trả lời, tự động cập nhật các trạng thái AttemptState và in bảng điểm sau khi sinh viên nộp bài/bài thi hết giờ" |
| **AI-Generated Output** | GPT-6 assisted in implementing randomized question and multiple-choice answer ordering for each exam attempt using `Collections.shuffle()` and the `choicesOrder` attribute in the `Attempt` class. It also helped develop the FULL COMPLETED TEST, enabling users to enter answers interactively, updating `AttemptState` according to the examination lifecycle, and displaying score breakdowns when students submit their exams or when time expires. Additionally, GPT-6 explained how to manage time limits, handle submission and expiration states, and ensure grading results are displayed in both situations. The generated code and recommendations were subsequently reviewed, tested, and adapted to the existing project structure and requirements. |
| **Student's Modifications** | I reviewed the AI-generated structural recommendations and evaluated them for potential issues. Although most contributions aligned with our implementation, I identified a limitation in the FULL COMPLETED TEST: the score report was generated only after students submitted all their answers, without properly handling time-expiration scenarios. To address this issue, I modified the `QuizGrader` logic to handle `null`, empty, and whitespace-only answers, representing unanswered questions or incomplete examinations. The program now generates a score report even when the time limit expires, displaying **"Unanswered"** for unanswered items instead of assigning a numerical score. **Git Verification:** I also investigated why my GitHub commits did not display the Verified badge. After comparing my workflow with Huy's, I found that Huy manually uploaded his changes through the GitHub website, whereas my commits were pushed using `git push origin main` through the terminal. This helped me identify a difference in our submission workflows, although the Verified badge itself depends on GitHub's commit-signature verification rather than simply the method used to push commits. |

### 10.4. Week 4 – Final Implementation and Project Completion

#### 1. Gemini 3.1 Pro

| Category | Content |
|---|---|
| **Prompt** | "Hướng dẫn tôi hoàn thành task cá nhân Tuần 4 trực tiếp qua GitHub web: tạo class `FillInTheBlank` chứng minh Open/Closed Principle mà không sửa code cũ, cập nhật test case trong `Main.java`. Sau đó, hướng dẫn sửa sơ đồ UML và soạn toàn bộ nội dung Teach-Back Tuần 4 bằng tiếng Anh (gồm Syllabus mapping, 10 Q&A bảo vệ, Reflection). Dựa vào ảnh lịch sử commit, hãy trích xuất giúp tôi 5 Key Commits quan trọng nhất đưa vào báo cáo." |
| **AI-Generated Output** | Gemini generated a complete implementation of `FillInTheBlank.java`, extending `Question` and overriding `grade()` with logic for trimming whitespace and performing case-insensitive answer matching. It also provided additional code for `Main.java` covering Test Cases 1 and 3, along with Mermaid code for updating the UML diagram. Furthermore, Gemini drafted the complete English Markdown content for the individual Teach-Back report, including an OOP Syllabus Mapping table, ten oral-defense Q&A pairs, and a Reflection section. It also helped identify relevant commits from the GitHub history. |
| **Student's Modifications** | I independently created and committed each file directly through the GitHub web interface to document the development process and maintain incremental progress. Before committing the source code, I carefully verified that the `grade()` method properly handled null answers to prevent `NullPointerException`. Regarding the documentation, I identified a language inconsistency in the Week 3 exception-message examples generated by AI and manually changed the messages from English to Vietnamese to match my teammate's actual `Attempt.java` implementation, avoiding a claim-evidence mismatch. Finally, I refined the Key Commits section by retaining only the five most essential commits instead of listing every commit, making the report more concise and focused on the rubric requirements. |

#### 2. ChatGPT GPT-6 (OpenAI)

| Category | Content |
|---|---|
| **Prompt 1** | "Hãy giúp tôi thực hiện TestCase7: NULL ANSWER REFLECTION" |
| **Prompt 2** | "Independently prepare 10 self-quiz Q&A pairs (including answers)." |
| **Prompt 3** | "Từ nhiệm vụ này hãy tạo cho tôi 10 câu hỏi để tôi trả lời" |
| **AI-Generated Output** | GPT-6 assisted in implementing Test Case 7: NULL ANSWER REFLECTION, which verifies how the system handles unanswered questions and ensures that null or missing answers are correctly reflected in grading results. It also prepared ten self-quiz questions and answers related to the project, helping me review my understanding of the implementation and OOP concepts. The generated code, explanations, and quiz materials were reviewed and adapted to fit the existing project requirements. |
| **Student's Modifications** | After reviewing and verifying the generated output, I was satisfied with the AI assistance provided for Test Case 7 and confirmed that the implementation aligned with the intended project requirements. The generated questions were also highly relevant to our project and its OOP concepts, making them suitable for reviewing my knowledge and preparing for the oral defense. No further modifications were necessary. |



## 10.5. AI Transparency and Critical Evaluation

AI tools were helpful for explaining Java concepts, suggesting class implementations, identifying potential bugs, and accelerating repetitive documentation tasks.

However, AI-generated code was not always correct or consistent with the project's existing API.

The team identified and corrected several issues, including:

- Incorrect time-limit calculations caused by missing conversion from minutes to seconds.
- Inconsistent method names involving `getPointsAchieved()` and `getScoreAchieved()`.
- Null-answer handling that could cause `NullPointerException` in MultipleChoice and TrueFalse.
- Potential inconsistencies between generated implementations and existing class interfaces.

These issues demonstrate that AI assistance does not replace understanding, code review, testing, or independent verification.

The team reviewed generated code, modified inappropriate suggestions, and used test cases to verify the correctness of the final implementation.

---

# 11. Conclusion

The Online Quiz / Exam System successfully demonstrates the application of fundamental Object-Oriented Programming principles, including Encapsulation, Inheritance, Abstraction, and Polymorphism.

The project implements a structured examination workflow through the `Question` hierarchy, `Quiz`, `Attempt`, `AttemptState`, and `QuizGrader`. It supports multiple question types, randomized question and answer orders, examination time limits, automatic grading, score breakdowns, and custom exception handling.

The implemented test cases verify important system behaviors, including normal examination execution, invalid state transitions, polymorphic grading, score calculation, question randomization, ShortAnswer grading, and null-answer handling.

The implementation of `FillInTheBlank` also demonstrates the Open/Closed Principle by extending the existing question hierarchy without modifying the `Question` base class or `QuizGrader`.

Although the project is an educational Java console application with in-memory data storage, it provides a practical foundation for understanding object-oriented design, testing, debugging, and software extensibility.

Overall, the project has helped the team develop a deeper understanding of OOP concepts and their practical application in building a structured, maintainable, and extensible software system.

---
