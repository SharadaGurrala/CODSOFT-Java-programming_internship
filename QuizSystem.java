import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class Question{
    String question;
    String[] options;
    int correctAnswer;

    public Question(String question,
        String[] options,int correctAnswer){
            this.question=question;
            this.options=options;
            this.correctAnswer=correctAnswer;

        }

        public String toString(){
            StringBuilder sb=new StringBuilder(question +"\n");
            for(int i=0;i<options.length;i++){
                sb.append((i+1)+"."+options[i]+"\n");}
                return sb.toString();

            }
        }

    public class QuizSystem{
        static ArrayList<Question>
        questions = new ArrayList<>();
        static int score =0;
        static ArrayList<String>results = new ArrayList<>();
        static Scanner scanner = new Scanner(System.in);
        static boolean answerSubmitted = false;

        public static void main(String[] args){
            questions.add(new Question ("what is the capital of France?", new String[]{"Paris","London","Berlin","Mdrid"},1));

            questions.add(new Question("what is 2+2 ?",new String[]{"3","4","5","6"},2));
            questions.add(new Question("who wrote hamlet?",new String[]{"Mark Twain","J.K Rowling","William shakespeare","charles Dickens"},3));

            for(Question question : questions){
                askQuestion(question);
            }

            showResults();
            scanner.close();
        }

        public static void askQuestion(Question question){
            System.out.println(question);
            Timer timer = new Timer();
            timer.schedule(new TimerTask(){
                @Override
                public void run(){
                    if(!answerSubmitted){
                        System.out.println("Time's up!");

                        results.add("Question: "+question.question+"-Answer:Time's up!");

                        answerSubmitted=true;
                        timer.cancel();

                    }
                }
                
            },15000);

            answerSubmitted = false;
            while(!answerSubmitted){
                System.out.println("Enter your answer(1-4):");
                int userAnswer= scanner.nextInt();
                scanner.nextLine();
                answerSubmitted = true;
                timer.cancel();
                if(userAnswer == question.correctAnswer){
                    score++;
                    results.add("Question:"+question.question+" -Answer: Correct");

                    System.out.println("Correct!");
                    }
                    else{
                        results.add("Question:"+question.question+" -Answer:Incorrect(Correct Answer: "+question.options[question.correctAnswer-1]+")");
                        System.out.println("Incorrect. The correct answer was "+question.options[question.correctAnswer-1]);
                    }
                }

            }
            public static void showResults(){
                System.out.println("\nQuix finished!");
                System.out.println("Your final score is "+score+"/"+questions.size());
                System.out.println("Summary of your answers:");
                for(String result:results){
                    System.out.println(result);
                }
            }


        }
