import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Calculator {

    public static void main(String[] arg) {

        ArrayList<Double> number = new ArrayList<>();
        int j = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 0 to end");

        while (j != 1) {

            System.out.print("Enter your number ");
            double num = input.nextDouble();
            if (num == 0) {
                j = 1;
            } else {
                number.add(num);
            }

        }
        //mean
        double sum = 0;
        for (double num : number) {
            sum += num;
        }
        double mean = sum / number.size();
        System.out.println("The mean is : " + String.format("%.4f", mean));

        //median
        Collections.sort(number);
        double median;
        if (number.size() % 2 == 0) {
            median = (number.get(number.size() / 2) + number.get(number.size() / 2 - 1)) / 2;
        } else {
            median = number.get(number.size() / 2);
        }
        System.out.println("Median is : " + median);

        //mode
        double mode;
        int count1 = 0;
        double current1 = 0;

        for (int i = 0; i < number.size(); i++) {
            double current = number.get(i);
            int count = 0;
            if (current1 == current) {
                continue;
            }

            for (double num : number) {
                if (num == current) {
                    count++;
                }
            }
            if (count >= count1) {
                count1 = count;
                mode = current;
                current1 = current;
            } else {
                continue;
            }

            if (count1 > 1) {
                System.out.println("The mode is : " + mode);
            }
        }
        if (count1 == 1) {
            System.out.println("There is no mode");

        }
        //standard deviation
        double variance = 0;
        for (double num : number) {
            variance += Math.pow(num - mean, 2);
        }
        variance /= number.size();

        double standard = Math.sqrt(variance);
        System.out.println("Standard deviation is : " + String.format("%.4f", standard));

    }

}