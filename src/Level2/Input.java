package Level2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    private static final Scanner SCANNER = new Scanner(System.in);

    public Input() {
    }

    public static byte readByte(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                byte input = SCANNER.nextByte();
                SCANNER.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Format error.");
                SCANNER.nextLine();
            }
        }
    }

    public static int readInt(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                int input = SCANNER.nextInt();
                SCANNER.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Format error.");
                SCANNER.nextLine();
            }
        }
    }

    public static float readFloat(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                float input = SCANNER.nextFloat();
                SCANNER.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Format error.");
                SCANNER.nextLine();
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                double input = SCANNER.nextDouble();
                SCANNER.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Format error.");
                SCANNER.nextLine();
            }
        }
    }

    public static char readChar(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                String input = SCANNER.nextLine();
                if (input.length() != 1) {
                    throw new Exception("Format error");
                }
                return input.charAt(0);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String readString(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                String input = SCANNER.nextLine();
                if (input.isEmpty()) {
                    throw new Exception("Format error");
                }
                return input;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Boolean readYesOrNot(String message) {
        while (true) {
            System.out.print(message + ": ");
            try {
                String input = SCANNER.nextLine();
                if (input.length() != 1 || !input.equalsIgnoreCase("n") && !input.equalsIgnoreCase("y")) {
                    throw new Exception("Format error");
                }
                return input.equalsIgnoreCase("y");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void closeScanner() {
        SCANNER.close();
    }
}
