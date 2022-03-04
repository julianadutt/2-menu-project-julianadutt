import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DeliveryOne {
    public static void main(String[] args){
        order(System.in);
    }

    public static double order(InputStream in) {
        double total = 0;
        String food = "a";
        ArrayList<Integer> order = new ArrayList<>();

        // intro to restaurant
        System.out.println("Welcome to Seoulspice!");

        // menu
        System.out.println("Item            Price");
        System.out.println("Korrito         $1.99");
        System.out.println("Noodles         $2.99");
        System.out.println("Rice Bowl       $3.99");
        System.out.println("Salad           $4.99 ");

        // getting order
        System.out.println("Enter what you would like to order: ");
        Scanner input = new Scanner(System.in);
        food = input.nextLine();


        // getting total of item
        if (Objects.equals(food.toLowerCase(), "korrito")) {
            total = total + 1.99;
            System.out.println("Subtotal: $" + Math.round(total * 100.0) / 100.0);
        } else if (Objects.equals(food.toLowerCase(), "noodles")) {
            total = total + 2.99;
            System.out.println("Subtotal: $" + Math.round(total * 100.0) / 100.0);
        } else if (Objects.equals(food, "rice bowl")) {
            total = total + 3.99;
            System.out.println("Subtotal: $" + Math.round(total * 100.0) / 100.0);
        } else if (Objects.equals(food, "salad")) {
            total = total + 4.99;
            System.out.println("Subtotal: $" + Math.round(total * 100.0) / 100.0);
        } else {
            System.exit(-1);
        }

        //printing subtotal
        System.out.println("Subtotal: $" + total);

        // asking about delivery
        System.out.println("Do you want $5.99 delivery? (y/n)?");
        Scanner del_input = new Scanner(System.in);
        String del = del_input.nextLine();
        del = del.toLowerCase();

        //calculating delivery
        if (Objects.equals(del, "y")) {
            total = total + 5.99;
            System.out.println("Subtotal: $" + Math.round(total * 100.0) / 100.0);
        } else if (Objects.equals(del, "n")) {
            total = total + 0;
        }

        // adding on tax
        total = total + total * .1;

        // asking about tip
        System.out.println("Do you want to tip? (y/n)");
        Scanner tip_input = new Scanner(System.in);
        String tip = tip_input.nextLine();
        tip = tip.toLowerCase();

        // getting tip percentage
        if (Objects.equals(tip, "y")) {
            System.out.println("Choose a percentage for your tip (0-40): ");
            Scanner tip_pct = new Scanner(System.in);
            double pct = tip_pct.nextDouble();

            // calculating tip
            pct = pct / 100;

            // calculating total
            total = total + total * pct;
        } else if (Objects.equals(tip, "n")) {
            total = total + 0;
        } else {
            System.exit(-1);
        }

        System.out.println("Your total is: $" + Math.round(total * 100.0) / 100.0);
        return total;
    }
}
