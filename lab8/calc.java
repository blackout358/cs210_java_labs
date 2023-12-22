public class calc {
    public static void main(String[] args) {
        double perHour = 12.5;
        double perYear = 27000;
        saleryBreakdownPerHour(perHour);
        System.out.println();
        saleryBreakdownPerYear(perYear);

    }

    public static void saleryBreakdownPerHour(double perHour) {
        double perYear = perHour * 2070;
        double perDay = perHour * 9;
        double perWeek = perDay * 5;
        System.out.println("Per Hour: " + perHour);
        System.out.println("Per Day: " + perDay);
        System.out.println("Per Week: " + perWeek);
        System.out.println("Per Year: " + perYear);
    }

    public static void saleryBreakdownPerYear(double perYear) {
        double perHour = perYear / 2070;
        double perDay = perHour * 9;
        double perWeek = perDay * 5;
        System.out.println("Per Hour: " + perHour);
        System.out.println("Per Day: " + perDay);
        System.out.println("Per Week: " + perWeek);
        System.out.println("Per Year: " + perYear);
    }
}
