import java.util.*;
public class Main {
    public static Scanner in = new Scanner(System.in);
    public static String[][] array2D = {{"1","2","3"},
            {"4","5","6"},
            {"7","8","9"}};
    static int round = 1;
    static int Who_starts = 0;
    static int range = ((9-1)+1);
    static int num_player = 0;
    static int num_computer = 0;
    static ArrayList<Integer> arra_list = new ArrayList<>();
    static ArrayList<Integer> arrayList_calculator = new ArrayList<>();
    public static void main(String[] args) {

        in.useLocale(Locale.US);
        int want = 1;
        try {
            do {
                System.out.println("What do you want?\nEnter 1 for the calculator or 2 for tic tac toe game");
                want = in.nextInt();
                if (want == 1 || want == 2) {
                    break;
                }
                System.out.println("Please enter only 1 or 2");
            } while (true);
        }catch (InputMismatchException IE)
        {
            System.out.println("Please enter only numbers");
        }
        if(want == 2) {
            int move = 0;
            String wall = "*******";
            System.out.println("Welcome to Tic Tac Toe game");
            System.out.println("*******************************");
            try {
                do {
                    System.out.print("Do you play 1 or 3 round?: ");
                    round = in.nextInt();
                } while (round != 1 && round != 3);
            } catch (InputMismatchException I_E) {
                System.out.println("Please enter only numbers");
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            try {
                Who_starts = whoStart(Who_starts);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
            int num_hint = 1;
            for (int i = 1; i <= wall.length(); i++) {
                for (int j = 1; j <= wall.length(); j++) {
                    if (i % 2 != 0 || j % 2 != 0) {
                        System.out.print(wall.charAt(i - 1) + " ");
                    } else {
                        System.out.print(num_hint + " ");
                        num_hint++;
                    }
                }
                System.out.println();
            }
            try {
                start(Who_starts, move, wall, range);
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        else
        {
                int stopCalculator = 0;
                System.out.println("Welcome to a calculator program");
                do {
                    try {
                        int number1, number2, operation;
                        System.out.print("Please enter first number: ");
                        number1 = in.nextInt();
                        System.out.print("Please enter second number: ");
                        number2 = in.nextInt();
                        System.out.println("Enter 1 to addition the numbers");
                        System.out.println("Enter 2 to subtraction the numbers");
                        System.out.println("Enter 3 to multiplication the numbers");
                        System.out.println("Enter 4 to division the numbers");
                        System.out.println("Enter 5 to modulus the numbers");
                        System.out.println("Enter 6 to find minimum number");
                        System.out.println("Enter 7 to find maximum number");
                        System.out.println("Enter 8 to find the average of numbers");
                        System.out.println("Enter 9 to print the last result in calculator");
                        System.out.println("Enter 10 to print the list of all results in calculator");
                        System.out.print("Please enter the operation: ");
                        operation = in.nextInt();
                        calculator(number1, number2, operation);
                        System.out.println("Do you continue?");
                        System.out.print("Enter 0 for stop or 1 for continue: ");
                        stopCalculator = in.nextInt();
                        while (stopCalculator != 0 && stopCalculator != 1) {
                            System.out.print("Please enter only 1 for continue or 0 for stop: ");
                            stopCalculator = in.nextInt();
                        }
                        if (stopCalculator == 0) {
                            break;
                        }
                    }catch (ArithmeticException AE)
                    {
                        System.out.println("You can not to division by zero");
                    }catch (InputMismatchException IE)
                    {
                        System.out.println("Please enter only numbers");
                    }catch (Exception E)
                    {
                        System.out.println(E.getMessage());
                    }
                } while (stopCalculator == 1);
        }
        in.close();
    }
    public static void calculator(int number1,int number2,int operation)
            throws ArithmeticException,InputMismatchException,Exception
    {
        if(operation == 1)
        {
            System.out.println(number1 + " + " + number2 + " = " + (number1+number2));
            arrayList_calculator.add(number1+number2);
        } else if (operation == 2) {
            System.out.println(number1 + " - " + number2 + " = " + (number1-number2));
            arrayList_calculator.add(number1-number2);
        } else if (operation == 3) {
            System.out.println(number1 + " * " + number2 + " = " + (number1*number2));
            arrayList_calculator.add(number1*number2);
        } else if (operation == 4) {
            System.out.println(number1 + " / " + number2 + " = " + (number1/number2));
            arrayList_calculator.add(number1/number2);
        } else if (operation == 5) {
            System.out.println(number1 + " Mod " + number2 + " = " + (number1%number2));
            arrayList_calculator.add(number1%number2);
        } else if (operation == 6) {
            if (number1>number2)
            {
                System.out.println("Min number between " + number1 + " and " + number2 + " = " + number2);
                arrayList_calculator.add(number2);
            }
            else
            {
                System.out.println("Min number between " + number1 + " and " + number2 + " = " + number1);
                arrayList_calculator.add(number1);
            }
        } else if (operation == 7) {
            if (number1<number2)
            {
                System.out.println("Max number between " + number1 + " and " + number2 + " = " + number2);
                arrayList_calculator.add(number2);
            }
            else
            {
                System.out.println("Max number between " + number1 + " and " + number2 + " = " + number1);
                arrayList_calculator.add(number1);
            }
        } else if (operation == 8) {
            System.out.println("Average number between " + number1 + " and " + number2 + " = "
                    + ((number1+number2)/2));
            arrayList_calculator.add(((number1+number2)/2));
        } else if (operation == 9) {
            System.out.println("The last result in calculator = " + arrayList_calculator.getLast());
        }
        else
        {
            System.out.println("The list of all results in calculator = " + arrayList_calculator);
        }
    }

    public static int whoStart(int Who_starts) throws Exception
    {
            do {
                System.out.print("Who will starts?\nEnter 0 for player\nEnter 1 for computer\nEnter number: ");
                Who_starts = in.nextInt();
                if (Who_starts != 0 && Who_starts != 1) {
                    System.out.println("Please Enter only 0 or 1");
                } else {
                    break;
                }
            } while (true);

        return Who_starts;
    }
    public static void start(int Who_starts,int move,String wall,int range) throws Exception
    {
        while (!(checkWin(array2D))) {
            if(Who_starts == 0)
            {
                do {
                    System.out.print("Please player enter your move(between(1-9)):");
                    move = in.nextInt();
                    if(checkElementToArray_2D(move)) {
                        arra_list.add(move);
                        print_wall(move, Who_starts,wall);
                        Who_starts = 1;
                        break;
                    }
                    else
                    {
                        System.out.println("There is a mark\nPlease enter again");
                    }
                }while (true);
            }
            else
            {
                do {
                    System.out.println("Please computer enter your move(between(1-9)):");
                    move = ((int) ((range * Math.random()) + 1));
                    if (checkElementToArray_2D(move)) {
                        arra_list.add(move);
                        print_wall(move, Who_starts,wall);
                        Who_starts = 0;
                        break;
                    } else {
                        System.out.println("There is a mark\nPlease enter again");
                    }
                }while (true);
            }
        }
    }

    public static void print_wall(int move, int who,String wall) throws Exception
    {
        String[] plays = {"X","O"};
        int num_hint = 1;
        for (int i = 1; i <= wall.length(); i++)
        {
            for (int j = 1; j <= wall.length(); j++) {
                if(i % 2 != 0 || j % 2 != 0){
                    System.out.print(wall.charAt(i-1) + " ");
                }
                else {
                    if(num_hint == move && who == 0) {
                        displayArraylist(plays,who);
                        addElementToArray_2D(move,plays[0]);
                        num_hint++;
                    } else if (num_hint == move && who == 1) {
                        displayArraylist(plays,who);
                        addElementToArray_2D(move,plays[1]);
                        num_hint++;
                    } else
                    {

                        System.out.print(num_hint + " ");
                        num_hint++;
                    }
                }
            }
            System.out.println();
        }
        for (String[] e: array2D)
        {
            System.out.println(Arrays.toString(e));
        }
        if(checkWin(array2D))
        {

            if(who == 0)
            {
                System.out.println("Player win");
                num_player++;
            }
            else
            {
                System.out.println("Computer win");
                num_computer++;
            }
            if(round == 3)
            {
                if(num_player == 2)
                {
                    System.out.println("Player win in 3 round");
                } else if (num_computer == 2) {
                    System.out.println("Computer win in 3 round");
                }
                else {
                    Integer h = 1;
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 3; j++) {
                            array2D[i][j] = h.toString();
                            h++;
                        }
                    }
                    Who_starts = whoStart(Who_starts);
                    move = 0;
                    start(Who_starts, move, wall, range);
                }
            }
        }
    }
    public static void displayArraylist(String[] plays,int who)
    {
        if(who == 0)
        {
            System.out.print(plays[0] + " ");
        }
        else
        {
            System.out.print(plays[1] + " ");
        }
    }
    public static void addElementToArray_2D(int move, String PorC)
    {
        switch (move)
        {
            case 1: array2D[0][0] = PorC;
                break;
            case 2: array2D[0][1] = PorC;
                break;
            case 3: array2D[0][2] = PorC;
                break;
            case 4: array2D[1][0] = PorC;
                break;
            case 5: array2D[1][1] = PorC;
                break;
            case 6: array2D[1][2] = PorC;
                break;
            case 7: array2D[2][0] = PorC;
                break;
            case 8: array2D[2][1] = PorC;
                break;
            case 9: array2D[2][2] = PorC;
                break;
        }
    }
    public static boolean checkElementToArray_2D(int move)
    {
        Integer I_move = move;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(array2D[i][j].equals(I_move.toString()))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkWin(String[][] array2D)
    {
        if(array2D[0][0].equalsIgnoreCase(array2D[0][1]) && array2D[0][0].equalsIgnoreCase(array2D[0][2])) {
            return true;
        }else if (array2D[0][0].equalsIgnoreCase(array2D[1][0]) && array2D[0][0].equalsIgnoreCase(array2D[2][0])) {
            return true;
        }else if (array2D[0][0].equalsIgnoreCase(array2D[1][1]) && array2D[0][0].equalsIgnoreCase(array2D[2][2])) {
            return true;
        }else if (array2D[0][1].equalsIgnoreCase(array2D[1][1]) && array2D[0][1].equalsIgnoreCase(array2D[2][1])) {
            return true;
        }else if (array2D[0][2].equalsIgnoreCase(array2D[1][2]) && array2D[0][2].equalsIgnoreCase(array2D[2][2])) {
            return true;
        }else if (array2D[0][2].equalsIgnoreCase(array2D[1][1]) && array2D[0][2].equalsIgnoreCase(array2D[2][0])) {
            return true;
        }else if (array2D[1][0].equalsIgnoreCase(array2D[1][1]) && array2D[1][0].equalsIgnoreCase(array2D[1][2])) {
            return true;
        }else if (array2D[2][0].equalsIgnoreCase(array2D[2][1]) && array2D[2][0].equalsIgnoreCase(array2D[2][2])) {
            return true;
        }
        else
        {
            return false;
        }
    }
}