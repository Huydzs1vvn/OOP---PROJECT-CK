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
