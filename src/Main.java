import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Scans the user input.
        Scanner scanner = new Scanner(System.in);

        // Asks the user to enter the size for the integer array.
        System.out.print("Enter the size (not more than 20) of the random array = ");
        try {
            int size = Integer.parseInt(scanner.nextLine());
            if (size <= 0) {
                System.out.println("Cannot store elements in this array. Size must be greater than 0.");
                return;
            } else if (size > 20) {
                System.out.println("Cannot store elements in this array. Size must be smaller than 20.");
                return;
            }

            // Stores the random array.
            int[] randomArray = getRandomArray(size);

            // Prints the random generated array.
            printArray(randomArray);

            // Asks the user a number to find in the array.
            System.out.print("Enter a number you want to find = ");
            int number = Integer.parseInt(scanner.nextLine());

            // Searches the entered number in the array via Linear Search.
            linearSearch(randomArray, number);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
        }
    }

    /**
     * Checks whether entered number is present in the array via Linear Search.
     *
     * @param array  Integer array.
     * @param number Entered input integer.
     */
    private static void linearSearch(int[] array, int number) {
        System.out.println("Searching for " + number + "...");

        // Stores whether entered number is present in the array.
        boolean numberFound = false;

        // Searches for number in the array.
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                System.out.println(number + " found at position " + (i + 1) + ".");
                numberFound = true;
                break;
            }
        }

        // Checks whether number is not present in the array.
        if (!numberFound) {
            System.out.println(number + " is not present in the array.");
        }
    }

    /**
     * Prints the integer array.
     */
    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Creates a random array of integers filled with numbers starting from 0 to 100.
     *
     * @param size Size of the array. Must be greater than 0.
     * @return Array of integers.
     */
    private static int[] getRandomArray(int size) {
        System.out.println("Generating random array...");

        // Random array.
        int[] array = new int[size];

        // Generates a random number.
        Random random = new Random();

        // Fills up the array with random numbers.
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }
        return array;
    }
}
