import java.util.Scanner;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Hello there");
        System.out.println("Please set a UserName for your user account in our gas station: ");

        String userInput = scanner.next();

        var user = new User(userInput, userInput, UserType.EXTERNAL);

        System.out.println("Nice! Your assigned UserName is " + "'" + userInput + "'");
        System.out.println("Now, Please enter and assign a new Password(not less than 5 characters): ");
        String userTypesPassword = scanner.next();
        System.out.println("Your password starts with "
                + userTypesPassword.charAt(0)
                + " and ends with "
                + userTypesPassword.charAt(userTypesPassword.length() - 1) + ", If yes please type 1");

        // Prompt the user to enter a value for userType
        System.out.print("Enter a value (1 to proceed, any other value to exit): ");
        int userTypeInput = scanner.nextInt();

        // Call processInput with the user input for userType
        int result = processInput(userTypeInput);

        int myInput = scanner.nextInt();
        int ress = processNextStep(myInput);

    }

    public static int processInput(int userType) {
        if (userType == 1) {
            System.out.println("***************************************");
            System.out.println("Great, now we move on to the next step!");
            System.out.println("Please choose one of the time slots below:");
            System.out.println("1. Friday(10.2.2024)");
            System.out.println("2. Saturday(11.2.2024)");
            System.out.println("3. Sunday(10.2.2024)");
        } else {
            System.out.println("The app will close now");
            System.exit(0);
        }
        return userType;
    }

    public static int processNextStep(int userSecondInput){
        if (userSecondInput == 1){
            System.out.println("Great, you booked the friday 10.02.2024. don't forget it!");
        } else if (userSecondInput == 2) {
            System.out.println("Great, you booked the saturday 11.02.2024. don't forget it!");
        } else if (userSecondInput == 3){
            System.out.println("Great, you booked the sunday 12.02.2024. don't forget it!");
        } else {
            System.out.println("you typed the wrong input! now the app will close");
            System.exit(0);
        }
        return userSecondInput;
    }
}

