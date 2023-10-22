import java.util.Scanner;

public class LinearEquationLogic {

    private LinearEquation equation;
    private Scanner scan;
    private boolean repeat;
    private boolean sameX;

    public LinearEquationLogic() {
        equation = null;
        scan = new Scanner(System.in);
        repeat = true;
        sameX = false;
    }

    public void start() {
        welcome();
       while (repeat) {
           getCoordinates();
           displayLineInfo();
           findCoordinate();
           sameX = false;
           ask();
       }
       goodbye();
    }

    private void welcome() {
        System.out.println("Welcome to the linear equation calculator!");
    }

    private void getCoordinates() {
        System.out.print("Enter coordinate 1: ");
        String coordinate1 = scan.nextLine();
        int x1 = parsingLogicX(coordinate1);
        int y1 = parsingLogicY(coordinate1);

        System.out.print("Enter coordinate 2: ");
        String coordinate2 = scan.nextLine();
        int x2 = parsingLogicX(coordinate2);
        int y2 = parsingLogicY(coordinate2);

        equation = new LinearEquation(x1, x2, y1, y2);
        if (x1 == x2) {
            sameX = true;
        }
    }

    private int parsingLogicX(String coordinate) {
        String x = coordinate.substring(1, coordinate.indexOf(","));
        return Integer.parseInt(x);
    }

    private int parsingLogicY(String coordinate) {
        String y = coordinate.substring(coordinate.indexOf(",") + 2, coordinate.length() - 1);
        return Integer.parseInt(y);
    }

    private void displayLineInfo() {
        if (!sameX) {
            System.out.println(equation.lineInfo());
        } else {
            System.out.println("\n" + "You CAN'T enter two points with the same x value" + "\n");
        }
    }

    private void findCoordinate() {
        if (!sameX) {
            System.out.print("Enter a value for x: ");
            double xCoordinate = scan.nextDouble();
            scan.nextLine();
            System.out.println("\n" + "The point on the line is " + equation.coordinateForX(xCoordinate));
        }
    }

    private void ask() {
        System.out.print("Would you like to enter another pair of coordinates? y/n: ");
        String response = scan.nextLine();
        if (response.equals("n")) {
            repeat = false;
        }
    }

    private void goodbye() {
        System.out.println("Thank you for using the linear equation calculator, goodbye!");
    }

}