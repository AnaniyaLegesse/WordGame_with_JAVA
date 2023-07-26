import java.util.Scanner;

public class Main {


    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        do {
            for (int i=0;i<8;i++){
            try {
                int m, s1, s2, s3, s4;
                m = menu();
                switch (m) {
                    case 1:
                        s1 = Level.newGame();
                        s2 = Level.level_2(s1);
                        s3 = Level.level_3(s2);
                        s4 = Level.level_4(s3);
                        Level.create_file(s4);
                        break;
                    case 2:
                        Level.players_file();
                        break;
                    case 3:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Wrong input, try again");

                }
                break;

            } catch (Exception e) {
                System.out.println("invalid  input please insert a valid option");
                input.nextLine();
            }
        }
        } while (true);

    }

    public static int menu() {
        int m;
        System.out.println("\t\t-------------------");
        System.out.println("\t\tWORD PUZZLE GAME");
        System.out.println("\t\t-------------------");
        System.out.println("\t\t press 1: Play Game");
        System.out.println("\t\t Press 2: Previous players");
        System.out.println("\t\t Press 3: Exit");
        System.out.print("\t\t Enter your choice:");
        m = input.nextInt();
        return m;
    }
}
