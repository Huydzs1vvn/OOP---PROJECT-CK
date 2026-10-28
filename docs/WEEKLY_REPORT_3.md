# WEEKLY REPORT 3
**Theme:** Features, patterns & refactoring

## 1. WEEK 3 PLAN & TASK ALLOCATION

### Vũ Thành Huy (Team Leader)
- **Refactoring & Teach-back Prep:** Identify procedural or suboptimal code, refactor it using OOP principles, and document the "Before/After" code snippets with reasoning for the Week 3 individual teach-back.
- **Exceptions & Edge-case Testing:** Write additional unit tests focusing on edge cases (e.g., empty answers, boundary values for timing). Implement and handle custom exceptions properly.
- **UML Update:** Revise and finalize the UML class diagram to accurately reflect any new architectural changes made during implementation.

### Trần Hoàng Kha (Team Member)
- **Remaining Features:** Implement remaining exam features required by the prompt, specifically generating a score breakdown per question and overall, and randomizing question/choice orders per attempt.
- **State & Persistence:** Refine the `AttemptState` lifecycle for handling auto-submission on expiration and mock a basic persistence/data-saving mechanism.

---

## 2. GROUP PROGRESS SUMMARY

- **Completed:** All planned tasks have been successfully implemented and merged into the main branch.
- **Key Achievements:** 
  - Integrated custom exceptions (`QuizNotStartedException`, `AttemptExpiredException`) for robust error handling and encapsulation.
  - Implemented randomization for question and choice orders per attempt.
  - Developed a detailed score breakdown calculation in `QuizGrader`.
  - Refactored `Attempt` state management for strict lifecycle control.
  - Successfully executed full interactive and edge-case test suites without relying on procedural `if/else` error checking.
  - Updated the UML diagram to reflect the final Week 3 architecture.
