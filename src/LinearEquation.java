public class LinearEquation {


    private int x1;
    private int x2;
    private int y1;
    private int y2;

    public LinearEquation(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }

    public double slope() {
        double slope = (double) (y2 - y1) / (x2 - x1);
        return roundedToHundredth(slope);
    }

    public double yIntercept() {
        double mX = slope() * x1;
        return roundedToHundredth((y1 - mX));
    }

    public double distance() {
        return roundedToHundredth(Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
    }

    public String equation() {
        boolean equivalent = yIntercept() == (int) yIntercept();
        if (y1 == y2) {
            if (equivalent) {
                return "y = " + (int) yIntercept();
            }
            return "y = " + yIntercept();
        }
        if (equivalent) {
            return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + (int) yIntercept();
        }
        return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + yIntercept();
    }

    public String coordinateForX(double x) {
        double mX = roundedToHundredth(slope() * x);
        double yCoordinate = mX + yIntercept();
        return "(" + x + ", " + yCoordinate + ")" + "\n";
    }

    public String lineInfo() {
        String str = "\n" + "The two points are: (" + x1 + ", " + y1 + ") and " + "(" + x2 + ", " + y2 + ")" + "\n";
        str += "The equation of the lines between these points is: " + equation() + "\n";
        str += "The slope of this line is: " + slope() + "\n";
        str += "The y-intercept of this line is: " + yIntercept() + "\n";
        str += "The distance between these points is: " + distance() + "\n";
        return str;
    }

}