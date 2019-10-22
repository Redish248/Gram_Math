import java.util.Scanner;

public class Regex_parser {

    public static void main(String[] args) {
        String sentense;
        Scanner in = new Scanner(System.in);
        sentense = in.nextLine();

        System.out.println(check(sentense.toCharArray()));

    }

    private static boolean check(char[] sentense) {
        State currentState = State.A;
        int i = 1;
        for (char symbol: sentense) {
            switch (currentState) {
                case A:
                        if (symbol == 'a') {
                            currentState = State.B;
                        } else {
                            return false;
                        }
                        break;
                case B:
                    if (symbol == 'b') {
                        break;
                    }
                    int t = sentense.length - i;
                    if (t < 3) {
                        if (symbol == 'a' && (t == 2 || t == 1)) {
                            currentState = State.C;
                        } else {
                            if (symbol == 'c' && t == 0) {
                                currentState = State.E;
                            } else {
                                return false;

                            }
                        }
                    }
                    break;
                case C:
                    if (symbol == 'b') {
                        currentState = State.D;
                    } else {
                        return false;
                    }
                    break;
                case D:
                    if (symbol == 'c') {
                        currentState = State.E;
                    } else {
                        return false;
                    }
            }
            i++;
        }
        return ((currentState != State.C) && (currentState != State.A));
    }

}

enum State {
    A, B, C, D, E, F;
}
