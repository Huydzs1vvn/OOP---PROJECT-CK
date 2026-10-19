### WEEK 2 TASK ALLOCATION

**1. Vũ Thành Huy (Team Leader):**

* **Implement Core Classes (Question Group):** Code the abstract `Question` class and its three subclasses (`MultipleChoice`, `TrueFalse`, `ShortAnswer`). Ensure the inheritance hierarchy and the polymorphic `grade()` method function correctly.
* **Write Unit Test 1 (Polymorphism/Grading Test):** Develop an automated test verifying that the system can accurately grade a mixed list of different question types polymorphically, without relying on `if/else` type-checking logic.
* **Individual Teach-back:** Explain the specific data protected by the `Question` class and its subclasses (e.g., `correctAnswer`). Analyze the consequences: *What would break or allow cheating if this field were made `public`?* Include relevant test output screenshots as evidence.
* **AI Usage Log:** Maintain personal AI log detailing tool, date, prompts, output summary, and specifically, the verification method and modifications made.

**2. Trần Hoàng Kha (Team Member):**

* **Implement Core Classes (Quiz Management Group):** Code the `Quiz` class (managing the question list and overall time) and the `Attempt` class (managing submission state and time limit enforcement).
* **Write Unit Test 2 (Invariant Test):** Develop an automated test for the Validation/Error scenario: Set a `timeLimit` of 1 second, simulate a 2-second delay, and call the submit function to prove the system successfully rejects late submissions (Encapsulation check).
* **Group AI Error Report:** Identify and document at least one instance where the AI generated incorrect logic or over-engineered code during development. Explain how the team identified the flaw and the steps taken to correct it for the weekly report.
* **Individual Teach-back:** Explain the invariants protected by the `Attempt` class. Analyze the consequences: *What would happen if the `timeLimit` or `AttemptState` fields were changed to `public` (how could a student cheat)?* Include relevant test output screenshots as evidence.
* **AI Usage Log:** Maintain personal AI log detailing tool, date, prompts, output summary, verification method, and modifications made.
