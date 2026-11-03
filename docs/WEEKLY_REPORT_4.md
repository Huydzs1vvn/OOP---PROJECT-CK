### WEEK 4 TASK ALLOCATION
Moving forward to Week 4 (Theme: Extend, finalize & prepare defense), our team will divide technical group tasks, but **BOTH members must strictly complete their individual assessment components**:

**1. GROUP DELIVERABLES (DIVIDED TASKS):**
*   **Vũ Thành Huy (Team Leader):** 
    - **Extensibility Demo:** Implement `FillInTheBlank` to prove the Open/Closed Principle *without* editing existing `QuizGrader` or `Question` base classes.
    - **Final UML & Admin:** Update the Final UML diagram to match the code. Fix the English exception messages in the Week 3 teach-back file to match the actual Vietnamese code.
*   **Trần Hoàng Kha (Team Member):**
    - **Fix Bug :** Fix the `NullPointerException` at `TrueFalse.grade()` and `MultipleChoice.grade()` when `studentAnswer` is null (e.g., during an expired attempt). Verify this scenario using Reflection.
    - **Final Report:** Compile the Final Report, which includes migrating the `ShortAnswer` grading logic explanation from the teach-back file to the main group report.

**2. INDIVIDUAL DELIVERABLES (MANDATORY FOR EACH MEMBER):**
- **Teach-back & Syllabus Mapping :** Independently prepare 10 self-quiz Q&A pairs (including answers) and create a mapping table (explicitly stating which OOP principle is applied to which class/method within your assigned code).
- **Reflection :** Write a personal reflection report detailing the challenges faced, lessons learned, and areas where AI performed well or poorly.
- **AI Usage Log & Defense Prep :** Complete the AI log for the specific prompts you used, and prepare responses critiquing the AI (addressing AI weaknesses and alternative designs considered) for the independent oral defense.

### A brief summary of what our team accomplished during WEEK 4
During Week 4, our team focused on improving the functionality, reliability, and documentation of the Java Quiz/Exam System. Vũ Thành Huy, our team leader, implemented the FillInTheBlank question type to demonstrate the Open/Closed Principle (OCP) without modifying the existing QuizGrader or Question base classes. He also updated the final UML diagram to match the implementation and corrected the English exception messages in the Week 3 teach-back document to reflect the actual Vietnamese code.
While Kha worked on fixing the NullPointerException in TrueFalse.grade() and MultipleChoice.grade() when student answers were null, do TestCase 6 and TestCase 7 and contributed to the final report by transferring the ShortAnswer grading logic explanation from the teach-back document into the main group report.
In addition to group deliverables, each member independently prepared 10 self-quiz questions and answers, completed an OOP syllabus mapping table for their assigned code, wrote a personal reflection report, and finalized their AI usage log and oral defense preparation. These activities helped strengthen the system's correctness, documentation quality, and each member's understanding of the project's implementation and OOP principles.

**`ShortAnswer` grading logic explanation**
The ShortAnswer class implements a grading strategy that requires an exact match between the student's answer and the expected answer after trimming leading and trailing whitespace, while ignoring differences in uppercase and lowercase letters. Specifically, the grading logic uses trim() to remove unnecessary whitespace at the beginning and end of the student's answer and equalsIgnoreCase() to compare the answers without considering case sensitivity.
For example, if the expected answer is "Object Oriented", the answers "Object Oriented", " object oriented ", and "OBJECT ORIENTED" are all considered correct. However, "Object-Oriented" is marked incorrect because the hyphen changes the actual content of the answer. This ensures that the grading process remains flexible regarding capitalization and unnecessary whitespace while still requiring the student to provide the exact expected answer.
