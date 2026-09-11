public class Quiz implements QuizOperation{

    private Question[] questionsList;

    public Quiz(Question[] questions) {
        questionsList = questions;
    }

    // Add question
    public void addQuestion(Question question, int index) {
        questionsList[index] = question;
    }

    //Start quiz (Applying Polymorphism)
    @Override
    public void startQuiz(){
        System.out.println("Quiz Started. ");
    }

    // Display questions
    public void loadQuestions(){

        for (int i=0; i < questionsList.length; i++){

            System.out.println("\nQuestion " + (i + 1));
            System.out.println(questionsList[i].getQuestion());

            String[] options = questionsList[i].getOptions();

            for (int j=0; j < options.length; j++) {
                System.out.println((j + 1) + ". " + options[j]);
            }
        }
    }

    // Calculate score (Applying Polymorphism)
    @Override 
    public int calculateScore(int[] answers){
        int score = 0;

        for (int i = 0; i < questionsList.length; i++){
            if (questionsList[i].checkAnswer(answers[i])){
                score++;
            }
        }
        return score;
    }

    //Display results (Applying Polymorphism)
    @Override
    public void displayResult(int score) {

        System.out.println("Score: " + score + "/" + questionsList.length);
    }

    // Get number of questions
    public int getQuestionCount() {
        return questionsList.length;
    }
}