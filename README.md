# Student Grade Analyzer

A menu-driven console application written in Java for managing student records and analyzing academic performance. You can enter a student's name, roll number, and marks for one or more subjects, then calculate and review performance data directly in the terminal.

The application is designed for a small classroom or practice exercise and keeps records in memory while it is running. It can store up to 100 students.

## Features

- Add a student with a name, roll number, and marks for each subject
- Automatically calculate the student's total marks and average
- Assign a grade from A to F based on the average
- Display every stored student record
- Search for students by a partial or complete name
- Sort all students in descending order by total marks
- Find the student with the highest total
- Count the number of students in each grade
- Update a student's subject marks and recalculate their results
- Close the application from the main menu

## How It Works

The program uses the following Java classes:

- `Main` — displays the menu and reads the user's menu choices
- `GradeAnalyzer` — stores the student array and provides the available operations
- `Student` — stores a student's details and calculates total, average, and grade

Each student can have a different number of subjects. The average is calculated by dividing the student's total marks by the number of subjects.

## Grade Criteria

| Average | Grade |
|---|---|
| 90 or higher | A |
| 75–89.99 | B |
| 60–74.99 | C |
| 40–59.99 | D |
| Below 40 | F |

## Requirements

- Java Development Kit (JDK) 8 or later
- A terminal or command prompt
- No external libraries or database setup

## Getting Started

### 1. Clone the repository

```bash
git clone https://github.com/Gowri369271/Student_Grade_Analyzer.git
```

### 2. Enter the project directory

```bash
cd Student_Grade_Analyzer
```

### 3. Compile the application

```bash
javac Main.java
```

### 4. Run the application

```bash
java Main
```

## Example Menu

```text
----- Student Grade Analyzer -----
1. Add Student
2. Display All Students
3. Search Student by Name
4. Sort Students by Total Marks
5. Display Top Scorer
6. Display Grade Distribution
7. Update Marks of a Student
8. Exit
Enter choice:
```

### Example Workflow

1. Choose **1** to add a student.
2. Enter the student's name, roll number, number of subjects, and each subject mark.
3. Choose **2** to view all saved records.
4. Choose **6** to see how many students received each grade.
5. Choose **8** to exit.

All student information is held in memory and is lost when the application exits.

## Project Structure

```text
Student_Grade_Analyzer/
├── Main.java
└── README.md
```

## Limitations

- Records are not saved to a file or database.
- A maximum of 100 students can be stored.
- The application has a text interface and does not validate every possible invalid input.
- Results are not persisted after the program closes.

## Author

[Gowri369271](https://github.com/Gowri369271)
