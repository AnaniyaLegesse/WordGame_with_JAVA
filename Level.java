import com.sun.security.jgss.GSSUtil;

import java.io.*;
import java.util.*;

public class Level {
    static String name;
    static Scanner input=new Scanner( System.in);
    static String path="C:\\Users\\DELL\\IdeaProjects\\WORD-GAME\\src/gameFile.txt";
    static File file=new File(path);
    public static int newGame()
    {
        int score=0;
        String guess;
        System.out.print("Enter your name: ");
        name = input.nextLine();
        name = name.toUpperCase(Locale.ROOT);
        System.out.println("[Level 1] ");
        System.out.println("Hi "+name);
        System.out.println(" Try to construct a 3 letter word using the given letters below \n");
        System.out.println("R\tW\tN\tO\n");
        System.out.print(name + " enter the word you Constructed: " );
        guess=input.nextLine();
        if (guess.length() == 3) {
            score = search(guess, score);
        }else {
            System.out.println("wrong word it must be a 3 letter word ");
        }

        while(score==0){
            System.out.println("inorder to pass to the next level!You have to score same point in this level");
            System.out.print(name+" try another word: ");
            guess=input.nextLine();
            score=search(guess,score);
        }

        System.out.println("Congratulation you have successfully passed to the next level\n");
        return score;

    }
    public static int level_2(int s)
    {
        int score=0;
        int count=1;
        String guess;

        System.out.println("[Level 2] ");

        System.out.println(" Now try to construct 4 letter words using the given letters below \n");
        System.out.println("T\tS\tP\tO\tL\n");
        System.out.println(name + ":Guess the 3 words: " );


        do {
            System.out.print("word "+count+" :" );
            guess = input.nextLine();
            if (guess.length() == 4) {
                score=search(guess,score);
            }else {
                System.out.println("wrong word it must be a 4 letter word ");
            }

            count++;
        }while(count!=3);

        while(score<1){
            System.out.println("inorder to pass to the next level!You have to score at list 1 points in this level");
            System.out.println(name+" try again: ");
            do {
                System.out.print("word "+count+" :" );
                guess = input.nextLine();
                if (guess.length() == 4) {
                    score = search(guess, score);
                }else {
                    System.out.println("wrong word it must be a 4 letter word ");
                }
                count++;
            }while(count!=4);
        }

        System.out.println("you have successfully passed to the next level\n");


        int score_2=score+s;
        return score_2;
    }
    public static int level_3(int s)
    {
        int score=0;
        int count=1;
        String guess;


        System.out.println("[Level 3] ");

        System.out.println("In this level you have to construct 5 letter words\n");
        System.out.println("\t\tS\tT\tP\tO\tL\tw\n\t\tH\tU\tA\tK\tG\tM\n");
        System.out.println(name + " enter the word you Constructed:" );

            guess = input.nextLine();

                if (guess.length() == 5) {
                    score = search(guess, score);
                    System.out.println("you have successfully passed to the next level\n");
                } else {
                    System.out.println("wrong word it must be a 5 letter");
                    System.out.print(name+" try another word: ");
                    guess=input.nextLine();
                    score=search(guess,score);
                }

        int score_3=score+s;
        return score_3;
    }
    public static int level_4(int s)
    {
        int score=0;
        String guess;

        System.out.println("[Level 4] ");

        System.out.println("In this level you have to construct a 6 letter words\n");
        System.out.println("\t\tS\tT\tP\tO\tL\tw\n\t\tH\tU\tA\tK\tG\tM\n");
        System.out.println(name + " enter the word you Constructed:" );
        guess = input.nextLine();

        if (guess.length() == 6) {
            score = search(guess, score);
        } else {
            System.out.println("wrong word it must be a 6 letter!");
        }

        System.out.println("Congratulation you have successfully finished the game\n");

        int score_4=score+s;
        System.out.println("Total score: "+score_4*20+"%");
        return score_4;
    }
    public static void create_file(int s)
    {
        Date now=new Date();
        File f=new File("C:\\Users\\DELL\\IdeaProjects\\WORD-GAME\\src/Players_score.txt");

        try
        {
            FileWriter myFile = new FileWriter(f,true);

            PrintWriter pw=new PrintWriter(myFile);
            pw.println(name+"\t\t"+"SCORE="+(s*20)+"%"+"\t\t"+now);
            pw.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void players_file()
    {
        File f=new File("C:\\Users\\DELL\\IdeaProjects\\WORD-GAME\\src/Players_score.txt");

        try
        {
            FileReader myFile = new FileReader(f);

            Scanner finput=new Scanner(myFile);
            while(finput.hasNext())
            {
                String str=finput.nextLine();
                System.out.println(str);
            }
            finput.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static int search(String guess,int score)
    {
        boolean flag = false;

        try {

            FileReader myfile = new FileReader(file);
            Scanner scr = new Scanner(myfile);
            while (scr.hasNextLine())
            {
                String line = scr.next();

                if (line.equals(guess))
                {
                    System.out.println("That's right!!!");
                    score = score + 1;
                    flag = true;
                    break;
                }
            }

            if (flag == false) { System.out.println("That's wrong word!"); }

        } catch (Exception e) {
            System.out.println("NOT FOUND IN FILE!");
        }
        return score;
    }
}
