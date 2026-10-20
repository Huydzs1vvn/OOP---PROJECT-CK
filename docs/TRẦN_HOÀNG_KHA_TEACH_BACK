*WEEK 1
This week, I analyzed the project domain and identified the potential classes and OOP principles to be used in the system; all of this is documented in WEEKLY_REPORT_1.md.
I did not use AI assistance this week; instead, I wrote the content in Vietnamese and used Google Translate to convert it into English.
Next week, our team will proceed with coding the project based on the UML draft developed this week.


*WEEK 2
This week, I designed and implemented the "Attempt", "Quiz", and "QuizGrader" classes, as well as the "AttemptState" enum, using the Java programming language. The underlying design concept serves the following purposes:
1. AttemptState: Defines the possible states of an exam attempt: NOT_STARTED, IN_PROGRESS, IS_EXPIRED, and SUBMITTED.

2. Attempt: This class manages a single exam attempt by a student. It includes five attributes—each serving a specific purpose—and a constructor:
-LocalDateTime startedAt             // The time the attempt began
-LocalDateTime submitAt                // The time the attempt was submitted
-AttemptState state                    // The current status of the exam attempt
-List<Question> questionsOrder         // Stores the sequence of questions (can be used to randomize the order)
-Map<String, String> answers           // Stores the student's responses
Along with that, there are four main methods: start(), isExpired(), submit(), and answerQuestion(). The program begins with start(), where it first checks whether the exam is in the NOT_STARTED state. 
Otherwise, an error will occur, and the program will display the message: "The exams has already started or submitted." If this is not the case, the program will update the exam status to IN_PROGRESS and record the start time in the startedAt field.
Next is isExpired(), which is intended to check whether the time allotted for the test has run out by comparing the time spent (doTime) against the time limit (timeLimit); specifically, it 
checks if doTime > timeLimit * 60 (converting the limit into seconds). the program will return true, indicating that the time allotted for the task has expired. Furthermore, before performing the comparison, I have also checked for conditions that could 
potentially cause errors in the program—for instance, verifying whether the timeLimit variable is less than or equal to 0 or not; if it is less than or equal to zero, the program will display the message "Time limit must be greater than 0." Additionally, the program checks whether its status is currently IN_PROGRESS and whether startedAt has been updated—this ensures that if a student submits their work before the time limit expires, the program will return "false."
Next is the submit() method; the intention here is to use this method to record the submission timestamp and update the assignment status to SUBMITTED. Before doing so, I also verify that the current status of the assignment allows for submission. Only allow students to submit when the status is IN_PROGRESS; this prevents students from submitting assignments after the permitted deadline has passed.
Finally, there is answerQuestion(), a new method we are adding—distinct from the UML diagram developed last week—which allows students to input their answers and compare them against the correct answers for each question. Note: This method only functions when the student's assignment status is IN_PROGRESS.

3. Quiz: The responsibility of this class is to manage quiz information—such as the ID, title, time limit, and list of questions—and to allow for the addition or removal of questions.  It includes five attributes—each serving a specific purpose—and a constructor:
-String iD                //exam code
-String title             //Title of exam
-int timeLimit            //The limit of test time
-List<Question>questions  //Stores the list of question
Along with that, there are two main methods: addQuestion, removeQuestion. As is standard practice, before executing the main methods, I include checks to prevent errors in edge cases—for instance, verifying whether timeLimit is less than or equal to zero, or ensuring that string inputs are not left empty.

4. QuizGrader: The responsibility of this class is to grade a student's quiz attempt by evaluating each question's answer and calculating the total score. It uses two main methods:
-List<GradeResult> gradeAttempt(Attempt a): Grades each question in the attempt by calling the grade() method of the corresponding Question object and stores the individual grading results in a list.
-double calculateTotalScore(List<GradeResult> results): Calculates the student's total score by summing the points achieved across all question results.
The class uses polymorphism to support different question types, such as MultipleChoice, TrueFalse, and ShortAnswer, without needing separate grading logic for each type. This keeps the grading process organized and makes it easier to extend the system with new question types.

What Breaks if Fields Are Made public?
If the fields in our "Attempt" and "Quiz" classes were declared public, external classes could directly access and modify important data, potentially bypassing the validation and rules implemented by these classes.
In the Attempt class, fields such as startedAt, submittedAt, state, questionsOrder, and answers store important information about a student's exam attempt. If these fields were public, external code could directly change attempt.state to AttemptState.SUBMITTED or modify attempt.answers even after the exam had been submitted. It could also change startedAt or submittedAt, potentially affecting how the system determines the attempt's duration and submission time. Our code helps prevent these problems by providing getter methods and returning copies of the internal collections through getAnswers() and getQuestionsOrder(). However, to fully apply encapsulation, all fields in Attempt, including startedAt and submittedAt, should be declared private. The class should also provide a method such as answerQuestion() to validate whether a student is allowed to submit or change an answer based on the attempt's state and time limit.
Similarly, in the Quiz class, making fields such as timeLimit and questions public would allow external code to change the time limit to an invalid value or modify the question list directly, bypassing the class's intended controls. Our implementation prevents this by declaring the fields private, validating that the time limit is greater than zero in the constructor, and providing addQuestion() and removeQuestion() to manage the questions. Furthermore, getQuestions() returns a copy of the question list, preventing external code from directly adding or removing elements in the quiz's internal list.
The QuizGrader class is responsible for grading an attempt by retrieving its question order and answers, calling grade() on each question, and calculating the total score. If the internal data in Attempt could be modified freely, the grading process could use answers or question orders that had been changed outside the intended exam workflow. Keeping the fields private and controlling how data is accessed helps make grading more reliable. The AttemptState enum also defines the valid attempt states, but the rules governing transitions between these states must still be enforced by the methods in Attempt.
In conclusion, encapsulation protects the internal data of Attempt and Quiz by preventing uncontrolled direct access and modification. It makes the code easier to maintain and helps ensure that important exam rules are respected. However, declaring fields private alone is not sufficient to enforce every rule; the system must also validate answer changes, submission timing, and attempt states through appropriate methods.

This week, I used AI (GPT-6 of OpenAI) to assist in building the classes.
Prompt: 
"Từ bản UML này, bạn hãy giúp tôi tiến hành xây dựng các class Attempt, Quiz, QuizGrader và enum AttemptState."
"Những điều kiện trong trường hợp lỗi đặc biệt như thế đã đúng chưa?"
"Từ Rubric, bạn hãy kiểm tra giúp tôi  bản REPORT_WEEK_2 và phần Teach-back-session của bản thân."
AI tạo ra:
GPT-6 (OpenAI) assisted in implementing the core classes Attempt, Quiz, and QuizGrader, along with the AttemptState enum, based on the project's UML diagram. It provided explanations of each class's responsibilities, suggested implementations for managing quiz attempts, checking time limits, handling submission states, and calculating scores. GPT-6 also reviewed potential edge cases, such as invalid time limits, incorrect attempt states, expired attempts, and missing student answers. Additionally, it helped review the Week 2 report and individual Teach-Back session against the project rubric, identifying areas that needed clarification or improvement. The generated code and recommendations were reviewed and adjusted to align with the existing class structure and project requirements.
SV đã sửa:
I reviewed the structural advice provided by the AI ​​to check for any potential issues. Overall, I agree with most of the AI’s contributions to our team’s coding process; they align well with what I expected based on the UML diagrams—including the two additions I mentioned in WEEKLY_REPORT_2.md. However, the structure generated by the AI ​​was disorganized, with arbitrary line breaks, so I reorganized it to make the code more readable. Furthermore, I identified some logic errors—similar to those discovered by Huy during his "Teach-Back Session" while executing Unit Test Case 1 (the "Happy Path" end-to-end scenario)—which prevented the code from functioning correctly; Huy has since corrected these. I also encountered a few logic errors myself, one of which involved the AI’s comparison between doTime and timeLimit (as noted in WEEKLY_REPORT_2.md); I fixed this by multiplying `timeLimit` by 60. Additionally, there was an error in the QuizGrader class, where the AI ​​generated a getPointsAchieved() method instead of getScoreAchieved()—an issue that arose because I hadn't yet pulled the latest updates from GitHub, where Huy had already adjusted the code to better align with our UML diagrams. Regarding the report, I took the ideas provided by the AI ​​and adapted them based on my own understanding, making significant revisions to ensure they accurately reflect the work our team completed during Week 2 and align with our overall project direction.
Besides AI, I wrote the content in Vietnamese and used Google Translate to convert it into English.
