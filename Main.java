import java.util.*;
class Student{
    String name;
    int roll;
    int[] marks;
    int total;
    double average;
    char grade;
    Student(String name,int roll,int[] marks){
        this.name = name;
        this.roll = roll;
        this.marks = marks;
        calculateTotal();
        calculateAverage();
        calculateGrade();
    }
    void calculateTotal(){
        total = 0;
        for(int m:marks){
            total +=m;
        }
    }
    void calculateAverage(){
        average = (double) total/marks.length;
    }
    void calculateGrade(){
        if (average>=90) grade = 'A';
        else if(average>=75) grade = 'B';
        else if(average>=60) grade = 'C';
        else if (average>=40) grade = 'D';
        else grade = 'F';
    }
    public String toString(){
        return "\nName: "+ name +
               "\nRoll: "+ roll +
               "\nMarks: "+ Arrays.toString(marks) +
               "\nTotal: "+ total +
               "\nAverage: "+ String.format("%.2f",average) +
               "\nGrade: "+ grade + "\n";
    }
}
class GradeAnalyzer{
    Student[] students;
    int count;
    GradeAnalyzer(int size){
        students = new Student[size];
        count = 0;
    }
    void addStudent(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();
        int[] marks = new int[n];
        System.out.print("Enter marks: ");
        for(int i=0;i<n;i++){
            marks[i] = sc.nextInt();
        }
        students[count++] = new Student(name,roll,marks);
        System.out.print("Student added successfully.\n");
    }
    void displayAll(){
        if (count==0){
            System.out.print("No students available.\n ");
            return;
        }
        for(int i=0;i<count;i++){
            System.out.println(students[i]);
        }
    }
    void searchByName(String name){
        boolean found = false;
        for(int i=0;i<count&&found!=true;i++){
            if (students[i].name.toLowerCase().contains(name.toLowerCase())){
                System.out.println(students[i]);
                found = true;
            }
        }
        if (!found){
            System.out.println("No student found with given name.\n");
        }
    }
    void sortByTotal(){
        for(int i=0;i<count;i++){
            for(int j=0;j<count-i-1;j++){
                if(students[j].total<students[j+1].total){
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }
        System.out.println("Students sorted by total marks./n");
    }
    void getTopScorer(){
        if (count==0){
            System.out.println("No students available.\n");
        }
        Student top = students[0];
        for(int i=0;i<count;i++){
            if(students[i].total>top.total){
                top = students[i];
            }
        }
        System.out.println("Top Scorer: ");
        System.out.println(top);
    }
    void displayGradeDistribution(){
        int a=0,b=0,c=0,d=0,f=0;
        for(int i=0;i<count;i++){
            switch(students[i].grade){
                case 'A': a++; break;
                case 'B': b++; break;
                case 'C': c++; break;
                case 'D': d++; break;
                case 'F': f++; break;
            }
        }
        System.out.println("Grade Distribution: ");
        System.out.println("A: "+a);
        System.out.println("B: "+b);
        System.out.println("C: "+c);
        System.out.println("D: "+d);
        System.out.println("F: "+f +"\n");
    }
    void updateMarks(int roll){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<count;i++){
            if (students[i].roll==roll){
                System.out.println("Enter new marks: ");
                for(int j=0;j<students[i].marks.length;j++){
                    students[i].marks[j] = sc.nextInt();
                }
                students[i].calculateTotal();
                students[i].calculateAverage();
                students[i].calculateGrade();
                System.out.println("Marks updated successfully.\n");
                return;
            }
        }
        System.out.println("Roll number not found.\n");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeAnalyzer analyzer = new GradeAnalyzer(100);
        while (true) {
            System.out.println("----- Student Grade Analyzer -----");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by Name");
            System.out.println("4. Sort Students by Total Marks");
            System.out.println("5. Display Top Scorer");
            System.out.println("6. Display Grade Distribution");
            System.out.println("7. Update Marks of a Student");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); 
            switch (ch) {
                case 1:
                    analyzer.addStudent();
                    break;
                case 2:
                    analyzer.displayAll();
                    break;
                case 3:
                    System.out.print("Enter name to search: ");
                    String name = sc.nextLine();
                    analyzer.searchByName(name);
                    break;
                case 4:
                    analyzer.sortByTotal();
                    break;
                case 5:
                    analyzer.getTopScorer();
                    break;
                case 6:
                    analyzer.displayGradeDistribution();
                    break;
                case 7:
                    System.out.print("Enter roll number to update: ");
                    int roll = sc.nextInt();
                    analyzer.updateMarks(roll);
                    break;
                case 8:
                    System.out.println("Student Grade Analyzer closed successfully.");
                    return;
                default:
                    System.out.println("Invalid choice.\n");
            }
        }
    }
}




  




















