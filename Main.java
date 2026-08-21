import java.util.Scanner;

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


        // Student Information 

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

        // START QUIZ


        student.startQuiz();
        quiz.loadQuestions();


        // Student Answers

        int[] answers = new int[quiz.getQuestionCount()];


        for (int i = 0; i < quiz.getQuestionCount(); i++) {
            System.out.print("Enter your answer for Question " + (i + 1) + " (1-4): ");

            answers[i] = input.nextInt();
        }

        // Calculate Score

        int score = quiz.calculateScore(answers);


        // Display Result


        System.out.println("Student: " + student.getUsername());
        System.out.println("Score: " + score+ "/" + quiz.getQuestionCount());

        // SUBMIT AND LOGOUT
        student.submitAnswers();
        student.logout();
        input.close();
    }
}