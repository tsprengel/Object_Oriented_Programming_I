import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Future Value Calculator\n");

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            System.out.println("DATA ENTRY");
            double monthlyInvestment = getDouble(sc,
                    "Enter monthly investment: ", 0, 1000);
            double interestRate = getDouble(sc,
                    "Enter yearly interest rate: ", 0, 30);
            int years = getInt(sc,
                    "Enter number of years: ", 0, 100);
            System.out.println();

            // calculate the future value
            double futureValue = calculateFutureValue(
                    monthlyInvestment, interestRate, years);

            // get the currency and percent formatters
            NumberFormat c = NumberFormat.getCurrencyInstance();
            NumberFormat p = NumberFormat.getPercentInstance();
            p.setMinimumFractionDigits(1);

            // format the result as a single string
            String results
              = "Monthly investment:   " + c.format(monthlyInvestment) + "\n"
              + "Yearly interest rate: " + p.format(interestRate / 100) + "\n"
              + "Number of years:      " + years + "\n"
              + "Future value:         " + c.format(futureValue) + "\n";

            // print the results
            System.out.println("FORMATTED RESULTS");
            System.out.println(results);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
    }
    
     public static double getDouble(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid decimal value.");
            }
        }
    }

    public static double getDouble(Scanner sc, String prompt,
            double min, double max) {
        while (true) {
            double value = getDouble(sc, prompt);
            if (value > min && value < max) {
                return value;
            } else {
                System.out.println("Error! Number must be greater than " + 
                        min + " and less than " + max + ".");
            }
        }
    }
    
    public static int getInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid integer value.");
            }
        }
    }
    
    public static int getInt(Scanner sc, String prompt,
            int min, int max) {
        while (true) {
            int value = getInt(sc, prompt);
            if (value > min && value < max) {
                return value;
            } else {
                System.out.println("Error! Number must be greater than " + 
                        min + " and less than " + max + ".");
            }
        }
    }

    public static double calculateFutureValue(double monthlyInvestment,
            double interestRate, int years) {
        
        // convert yearly values to monthly values
        double monthlyInterestRate = interestRate/12/100;
        int months = years * 12;
            
        double futureValue = 0.0;
        for (int i = 0; i < months; i++) {
            futureValue = (futureValue + monthlyInvestment) *
                          (1 + monthlyInterestRate);
            //System.out.println(months);
            //System.out.println(futureValue);
        }
        return futureValue;
    }
}
