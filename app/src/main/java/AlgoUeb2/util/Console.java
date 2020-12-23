package AlgoUeb2.util;

import java.util.Scanner;

public class Console {

    static public int readIntegerFromStdin(String text) {
        //boolean loop to provide loop possibility, but avoid it in testing
        Scanner input = new Scanner(System.in);
        int number = 0;
        boolean intType = false;

        do {
            System.out.print(text);

            if(input.hasNextInt()) {
                number = input.nextInt();
                intType = true;
            } else {
                System.out.println("Wrong type of entry. Please enter a valid number: ");
                input.next();
            }
        } while (!(intType));

        return number;
    }

    static public String readStringFromStdin(String text) {
        Scanner input = new Scanner(System.in);
        System.out.print(text);
        String words = input.nextLine();

        return words;
    }
}
