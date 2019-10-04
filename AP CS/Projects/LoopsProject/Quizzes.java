import java.util.Scanner;
public class Quizzes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nQuiz Grader:");

        System.out.print("\nHow many questions are in the quiz: ");
        final int QUESTIONS = scan.nextInt();
        int[] answers = new int[QUESTIONS];

        scan.nextLine();
        
        answers = getAnswers(scan, QUESTIONS);
        
        boolean isGrading = true;
        while(isGrading) {
            gradeQuiz(scan, answers);
            isGrading = gradeAnother(scan);
        }
        System.out.println("\nThanks for using Quiz Grader!");
    }

    private static int[] getAnswers(Scanner scan, int questions) {
        int[] answers = new int[questions];
        System.out.print("Answer key: ");
        String[] answerStrings = scan.nextLine().split("\\s+");
        if (answerStrings.length != questions) {
            System.out.println("Wrong number of answers. Expected " + questions + " but got " + answerStrings.length + ".");
            return getAnswers(scan, questions);
        }
        for(int i=0; i<answerStrings.length; i++){
            answers[i] = Integer.parseInt(answerStrings[i]);
        }
        return answers;
    }
    
    private static void gradeQuiz(Scanner scan, int[] answers) {
        System.out.print("\nQuiz answers: ");
        String[] quizAnswerStrings = scan.nextLine().split("\\s+");
        if (quizAnswerStrings.length != answers.length) {
            System.out.println("Wrong number of answers. Expected " + answers.length + " but got " + quizAnswerStrings.length + ".");
            gradeQuiz(scan, answers);
        }
        double correct = 0;
        for(int i=0; i<quizAnswerStrings.length; i++){
            if(answers[i] == Integer.parseInt(quizAnswerStrings[i]))
                correct++;
        }
        System.out.println("Correct: " + (int)correct + ", Percent Correct: " + (correct * 100 /answers.length));
        if(correct == 0)
            System.out.println("What a loser.");
    }
    
    private static boolean gradeAnother(Scanner scan) {
        System.out.print("\nDo you want to grade another quiz? (y/n): ");
        String answer = scan.nextLine().trim();
        if(answer.equals("y") || answer.equals("n")) {
            return answer.equals("y") ? true : false;
        } else {
            System.out.println("Please only enter 'y' or 'n'.");
            return gradeAnother(scan);
        }
    }
}
