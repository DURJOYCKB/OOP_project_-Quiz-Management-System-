import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
       
        // Create Admin
  
        Admin admin = new Admin(
                "admin01",
                "1234",
                "A001"
        );

        admin.addQuestion();
        admin.viewQuestions();

        // Student's Information 

        System.out.print("Enter Student Username: ");
        String studentUsername = input.nextLine();

        System.out.print("Enter Student Password: ");
        String studentPassword = input.nextLine();

        System.out.print("Enter Student ID: ");
        String studentId = input.nextLine();

        System.out.print("Enter Department: ");
        String department = input.nextLine();

        System.out.print("Enter Semester: ");
        String semester = input.nextLine();

        RegisteredStudent student = new RegisteredStudent(
                studentUsername,
                studentPassword,
                studentId,
                department,
                semester,
                true,
                0
        );

        student.login();
        student.viewProfile();
        student.registerForQuiz();

        // Questions

        String[] options1 = {
                "Java",
                "HTML",
                "CSS",
                "SQL"
        };

        String[] options2 = {
                "extends",
                "import",
                "package",
                "static"
        };


        Question q1 = new Question(
                "Which language is mainly used for OOP?",
                options1,
                1
        );

        Question q2 = new Question(
                "Which keyword is used for inheritance in Java?",
                options2,
                1
        );

        // Create Quiz

        Question[] questions = {q1, q2};

        Quiz quiz = new Quiz(questions);

        // Start Quiz

        quiz.startQuiz();
        quiz.loadQuestions();

        // Student's Answers

        int[] answers = new int[quiz.getQuestionCount()];

        for(int i=0; i < quiz.getQuestionCount(); i++) {

            /* Custom exception is used here to handle 
            invalid answer options entered by the student. */

            while(true){

                try{
                    System.out.print("Enter your answer for Question " + (i + 1) + " (1-4): ");

                    answers[i] = input.nextInt();

                    if (answers[i] < 1 || answers[i] > 4) {
                        throw new InvalidOptionException(
                            "Invalid option! Please enter 1 to 4.");
                    }

                    break;

                } catch (InvalidOptionException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        // Calculate Score
        int score = quiz.calculateScore(answers);

        // Display Result
        System.out.println("\nStudent: " + student.getUsername());
        quiz.displayResult(score);

        // Submit
        student.submitAnswers();

        student.logout();
    }
}