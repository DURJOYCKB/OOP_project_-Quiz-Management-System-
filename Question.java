public class Question {

    private String question;
    private String[] options;
    private int correctAnswer;

    public Question(String question,String[] options,int correctAnswer) {

        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    //Get Questions
    public String getQuestion() {
        return question;
    }

    //Get Options
    public String[] getOptions() {
        return options;
    }

    // Get correct answer
    public int getCorrectAnswer() {
        return correctAnswer;
    }

    // Check answer
    public boolean checkAnswer(int answer) {
        return answer == correctAnswer;
    }
}