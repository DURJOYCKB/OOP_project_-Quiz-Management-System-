public class RegisteredStudent extends Student implements QuizOperation {

    private boolean registrationStatus;
    private int quizAttemptCount;

    public RegisteredStudent(String username, String password,
                             String studentId, String department,
                             String semester,
                             boolean registrationStatus,
                             int quizAttemptCount) {

        super(username, password, studentId, department, semester);

        this.registrationStatus = registrationStatus;
        this.quizAttemptCount = quizAttemptCount;
    }

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public int getQuizAttemptCount() {
        return quizAttemptCount;
    }

    public void setQuizAttemptCount(int quizAttemptCount) {
        this.quizAttemptCount = quizAttemptCount;
    }

    @Override
    public void startQuiz() {
        System.out.println("Student started the quiz.");
    }

    @Override
    public int calculateScore(int[] answers) {
        System.out.println("Student submitted answers.");
        return 0;
    }

    @Override
    public void displayResult(int score) {
        System.out.println("Student result: " + score);
    }

    public void submitAnswers() {
        System.out.println("Answers submitted.");
    }
}