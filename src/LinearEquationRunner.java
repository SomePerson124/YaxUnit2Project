import java.util.Scanner;


public class LinearEquationRunner {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);


        System.out.print("Enter coordinate 1: ");
        String coordinate1 = scan.nextLine();
        System.out.print("Enter coordinate 2: ");
        String coordinate2 = scan.nextLine();


        String x1String = coordinate1.substring(1, coordinate1.indexOf(","));
        String x2String = coordinate2.substring(1, coordinate2.indexOf(","));
        String y1String = coordinate1.substring(coordinate1.indexOf(",") + 2, coordinate1.length() - 1);
        String y2String = coordinate2.substring(coordinate2.indexOf(",") + 2, coordinate1.length() - 1);


        int x1 = Integer.parseInt(x1String);
        int x2 = Integer.parseInt(x2String);
        int y1 = Integer.parseInt(y1String);
        int y2 = Integer.parseInt(y2String);


        LinearEquation equation = new LinearEquation(x1, x2, y1, y2);

        System.out.print(equation.lineInfo());

    }
}