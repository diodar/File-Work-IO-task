package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FileWriteService fw = new FileWriteService();
        FileReadService fr = new FileReadService();

        int data = getData();

        switch (data) {
            case 1 -> {
                System.out.println("Creating new file...in progress");
                System.out.println("Enter file name:");
                String fileName = sc.nextLine();
                System.out.println("Enter file content: ");
                String newFileText = sc.nextLine();
                fw.fileWriteService(fileName, newFileText);
            }
            case 2 -> {
                System.out.println("Opening a file...in progress");
                System.out.println("Enter file name:");
                String fileName = sc.nextLine();
                fr.fileReadService(fileName);
            }
            default -> throw new IllegalStateException("Unexpected value: " + data);
        }
    }

    public static int getData() {

        Scanner sc = new Scanner(System.in);
        boolean isValidNum = false;
        int num = 0;

        while (!isValidNum) {
            System.out.println("""
                    What do you need to do? Type a number:
                    1 - create and save the file
                    2 - read already created file""");

            try {
                num = sc.nextInt();

                if (num == 1 || num == 2) {
                    isValidNum = true;
                } else {
                    System.out.println("Wrong number. Try again." + '\n');
                }
            } catch (InputMismatchException e) {
                System.out.println("Not a number. Try again." + '\n');
                sc.nextLine();
            }
        }
        return num;
    }
}