/*
 * Aarav Goyal
 * Mr Kulla's Paint Store
 * November 6, 2023  
 */
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String paintColor;
    int gallons;
    double redPaintTotal = 0.0;
    double greenPaintTotal = 0.0;

    printStoreTitle();

    String continueShopping;
    do {
      System.out.println("What color of paint would you like to purchase? (Red/Green)");
      paintColor = in.nextLine();
      System.out.println("How many gallons do you want?");
      gallons = in.nextInt();
      in.nextLine();

      if (paintColor.equalsIgnoreCase("Red")) {
        double redPaintCost = getRedPaintCost(gallons);
        redPaintTotal += redPaintCost;
      } else if (paintColor.equalsIgnoreCase("Green")) {
        double greenPaintCost = getGreenPaintCost(gallons);
        greenPaintTotal += greenPaintCost;
      }

      System.out.println("\nDo you want to make another purchase? (Yes/No)");
      continueShopping = in.nextLine();

      if (continueShopping.equalsIgnoreCase("No")) {
        break;
      }
    } while (continueShopping.equalsIgnoreCase("Yes"));

    double totalCost = calculateTotalCost(redPaintTotal, greenPaintTotal);
    printBill(redPaintTotal, greenPaintTotal, totalCost);
    printThankYouMessage();
  }

  public static double getRedPaintCost(int gallons) {
    double redPaintPrice = 21.95;
    return gallons * redPaintPrice;
  }

  public static double getGreenPaintCost(int gallons) {
    double greenPaintPrice = 19.95;
    return gallons * greenPaintPrice;
  }

  public static double calculateTotalCost(double redPaintTotal, double greenPaintTotal) {
    double totalCost = redPaintTotal + greenPaintTotal;
    double salesTax = totalCost * 0.09;
    return totalCost + salesTax;
  }

  public static void printStoreTitle() {
    System.out.println("*******************************");
    System.out.println("*        Paints R Us          *");
    System.out.println("*******************************");
  }

  public static void printThankYouMessage() {
    System.out.println("*******************************");
    System.out.println("*  Thank you for shopping at  *");
    System.out.println("*        Paints R Us          *");
    System.out.println("*******************************");
  }

  public static void printBill(double redPaintTotal, double greenPaintTotal, double totalCost) {
    System.out.println("\n*******************************");
    System.out.println("            Bill               ");
    System.out.printf("   Red paint total: $%.2f      %n", redPaintTotal);
    System.out.printf("   Green paint total: $%.2f    %n", greenPaintTotal);
    System.out.printf("   Total bill: $%.2f           %n", totalCost);
    System.out.println("*******************************");
  }
}
