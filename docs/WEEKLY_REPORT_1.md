Vũ Thành Huy (Team Leader): Conceptualized and drew the UML Class Diagram, designed the 8 CRC Cards, formulated the Test Plan (6 automated scenarios), wrote the Syllabus Mapping section, and completed my Individual Teach-Back in Vũ Thành Huy Teach Back
Trần Hoàng Kha:Conducted Domain Analysis, analyzed and explained the application of 3 core OOP principles (Polymorphism, Encapsulation, Open/Closed) in this project, summarized the Challenges encountered during the first week, reviewed and formatted the final report document, and completed my Individual Teach-Back in TRẦN_HOÀNG_KHA_TEACH_BACK

This week, my team analyzed the project domain, test plan and developed CRC cards and UML diagrams featuring candidate classes and method.
The online quiz/exam system is an online testing platform that supports various question types and automated grading. The system has two primary user groups: instructors and students.
Instructors can perform tasks such as creating quizzes with three question types (Multiple Choice, True/False, Short Answer), specifying the correct answer for each question, and setting a time limit for the quiz. Students can take and submit the quiz within the time limit established by the instructor, as well as view a summary and scores for each questions after submission.
The classes our team plans to utilize in this project, along with our intended use for them, are as follows:
+Quiz: This class stores all questions and the allotted time for the test, it also provides methods for operations such as adding or removing questions.
+Question: Contains general question attributes and adds a score property, it includes an abstract grade method to leverage polymorphism across the three specific question types implemented in the project.
+Multiple Choice: Stores a list of questions of this type along with their correct answers, ensuring students receive points for correct selections. The scoring logic for this type is defined specifically via method overriding.
+True/False: Stores a list of questions of this type along with their correct answers, ensuring students receive points for correct selections. The scoring logic for this type is defined specifically via method overriding.
+Short Answer: Stores a list of questions of this type along with their correct answers, ensuring students receive points for correct selections. The scoring logic for this type is defined specifically via method overriding.
Other classes used include Attempt, QuizGrader, and GraderResult, which track whether students complete the test on time, as well as changing the order of the questions and calculate their scores.
*The OOP principles and characteristics utilized:
-Polymorphism: It allows different classes to implement the same method in different ways while sharing a common interface. In our project, polymorphism is applied through the abstract Question class and its three subclasses: MultipleChoice, TrueFalse, and ShortAnswer, especially in Implementing grading per question type 
-Encapsulation: Encapsulation is employed because there are critical attributes—such as the quiz time limit—that must not be modifiable from outside the Attempt class, allowing them to be easily altered could facilitate cheating.
-Closed/Open: To add a new type of question, you simply need to create a subclass named after that question type. This subclass inherits from the Question class and can implement its own specific scoring logic without requiring significant changes, thereby minimizing the risk of errors during modification.
*Challenges encountered during the first week:
+We struggled with conceptualizing the project's class structure and determining the most logical and efficient way to assign methods to specific classes.
+How to apply the three main OOP principles: polymorphism, encapsulation, and the Open/Closed Principle.

*Test plan
Based on the core requirements and the three mandatory test scenarios defined in the project brief, the following automated test cases will be developed to verify the system's correctness and OOP principles. These tests may be implemented inside the main() function or using a lightweight testing class structure.
Test Case 1: Happy Path (End-to-End Execution)
-Objective: Verify that a student can successfully complete a quiz attempt under normal conditions and receive an accurate score.
-Setup: Create a Quiz with a 10-minute time limit. Add three questions: one MultipleChoice, one TrueFalse, and one ShortAnswer.
-Action: Start a new Attempt. Provide correct answers to all three questions. Call Attempt.submit().
-Expected Result: The attempt state changes to SUBMITTED. The QuizGrader calculates a perfect score (e.g., 3/3 points).
Test Case 2: Validation/Error Scenario (Encapsulation Check)
-Objective: Verify that the system enforces the time limit and correctly rejects late submissions, proving that Attempt encapsulates its own timing state.
-Setup: Create a Quiz with a very short time limit (e.g., 1 second).
-Action: Start a new Attempt. Use a sleep() function to halt execution for 2 seconds (simulating an expired time limit). Try to call Attempt.submit().
-Expected Result: Attempt.submit() checks the elapsed time against the limit. Because the time has expired, it immediately changes the state to EXPIRED and rejects the submission. No grading occurs.
Test Case 3: Polymorphism Verification
-Objective: Verify that the QuizGrader correctly evaluates different question subtypes without using conditional logic (if/else on types) and show behavior changes correctly.
-Setup: Create a Quiz with three question subtypes.
+Q1: MultipleChoice (Value: 1 pt, Expected: "A")
+Q2: TrueFalse (Value: 1 pt, Expected: "True")
+Q3: ShortAnswer (Value: 1 pt, Expected: "Object")
-Action: Start an Attempt. Provide the following answers:
+Q1: "A" (Correct)
+Q2: "False" (Incorrect)
+Q3: "Object" (Correct)
+Call Attempt.submit().
-Expected Result: The overall score matches the hand-calculated expected score (2/3). By inspecting the code, it must be evident that QuizGrader only calls the abstract Question.grade(answer) method, successfully processing different subtypes polymorphically.
Test Case 4: Score Breakdown and Calculation
-Objective: Verify that the system reports a detailed breakdown per question, not just the overall score.
-Action: Run Test Case 3. Inspect the returned list of GradeResult objects.
-Expected Result: The system outputs the points achieved, the maximum points, and a boolean isCorrect status for each individual question, matching the total computed score.
Test Case 5: Question Order Randomization
-Objective: Verify that each attempt shuffles the question order independently of the original quiz structure.
-Action: Create a Quiz with 5 distinct questions. Start Attempt A and Attempt B. Fetch the questionOrder from both attempts.
-Expected Result: Check that both attempts contain exactly 5 questions with no duplicates or missing items. The order of questions in Attempt A may differ from the original quiz order and may differ from Attempt B. The original quiz order remains unchanged.
Test Case 6: ShortAnswer Grading Strategy
-Objective: Verify the case-insensitive and whitespace-trimmed exact matching strategy for ShortAnswer questions.
-Setup: Create a ShortAnswer question with the expected answer "Object Oriented".
-Action: Submit various answers: "Object Oriented", "  object oriented  ", "OBJECT ORIENTED", and "Object-Oriented".
-Expected Result: The first three answers return a correct GradeResult (score > 0, isCorrect = true). The last answer (with the hyphen) is marked incorrect, verifying exact string matching post-trimming.

Our class CRC cards. We have totally 8 cards.
1/
Class: Quiz
Responsibilities:	                                Collaborators:
-Keep track of the questions in the quiz.           -Question
-Set the maximum time allowed (timeLimit).          -Attempt
-Provide the list of questions to an attempt.
2/
Class: Question (Abstract Base Class)
Responsibilities:	                                Collaborators:
-Store basic data that all question types           -GradeResult 
share (id, text, max points).
-Define the abstract grade(answer) method, 
which subclasses must override.
3/
Class: MultipleChoice
Responsibilities:	                                Collaborators:
-Store the list of options and                      -Question (Parent)
the correct answer.                                 -GradeResult
-Implement grade() to check if 
the student's choice is correct.
4/
Class: TrueFalse
Responsibilities:	                                Collaborators:
-Store the correct boolean answer                   -Question (Parent)
(true/false).                                       -GradeResult
-Override grade() to evaluate 
boolean logic.	
5/
Class: ShortAnswer
Responsibilities:	                                Collaborators:
-Store the expected text answer.                    -Question (Parent)
-Override grade(): trim leading and trailing        -GradeResult
whitespace and compare answers case-insensitively 
using exact string matching.	
6/
Class: Attempt
Responsibilities:	                                Collaborators:
-Track a student's current quiz session             -Quiz   
and record their answers.                           -Question
-Manage lifecycle states (not started,              -QuizGrader
in progress, submitted, expired).
-Block late submissions (Encapsulation).
-Randomize and maintain the question order 
for each attempt.
-Coordinate with the grader upon submission.	
7/
Class: GradeResult
Responsibilities:	                                Collaborators:
-Store the points achieved                          -Question
versus maximum points.                              -QuizGrader
-Store the correctness status (isCorrect) 
for UI display.	
8/
Class: QuizGrader
Responsibilities:	                                Collaborators:
-Call Question.grade(answer)                        -Attempt
polymorphically without checking                    -Question
concrete question types.                            -GradeResult
-Collect individual question results 
and calculate the total score.	

*Syllapus Mapping This project requires applying several key OOP concepts from our syllabus to ensure a sound and extensible design. The mappings between the syllabus topics and our project implementation are as follows:

Abstract Classes & Polymorphism: This is the core of our auto-grading system. We applied this by creating an abstract Question class with an abstract grade() method. Subclasses like MultipleChoice and TrueFalse implement their own grading logic. This allows the QuizGrader to evaluate an entire quiz polymorphically without using if/else checks for question types.

Encapsulation (State Management): We utilized encapsulation primarily in the Attempt class. It restricts external modification of critical attributes like the timeLimit and the current AttemptState (IN_PROGRESS, EXPIRED, SUBMITTED). This ensures the system strictly enforces server-side time limits.

Object-Oriented Design Principles (SOLID): Our design heavily relies on the Open/Closed Principle. By decoupling the grading logic into specific question subclasses, we can add new question types in the future without modifying existing classes like QuizGrader or Attempt.

Collections: We applied collections (e.g., Lists/Vectors) to manage the structure of a Quiz (which holds a list of Question objects) and to maintain the randomized questionOrder specific to each Attempt.
