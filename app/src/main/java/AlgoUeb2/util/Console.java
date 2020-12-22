package AlgoUeb2.util;

import java.util.Scanner;

public class Console {

    static public int readIntegerFromStdin(String text, boolean loop){
        //boolean loop to provide loop possibility, but avoid it in testing
        int number = 0;
        Scanner input = new Scanner(System.in);
        System.out.print(text);

        if(loop){
            try{
                number = input.nextInt();
                System.lineSeparator();
            } catch (Exception e){
                Console.readIntegerFromStdin("Wrong type of entry. Please enter a valid number: ", true);
            }
        } else{
            number = input.nextInt();
            System.lineSeparator();
            System.lineSeparator();
        }

        return number;
    }

    static public String readStringFromStdin(String text){
        Scanner input = new Scanner(System.in);
        System.out.print(text);
        String words = input.nextLine();
        System.lineSeparator();
        System.lineSeparator();

        return words;
    }
}
