package TestSF;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть першу строку: ");
        System.out.println();
        String s1 = sc.next();

        System.out.print("Введіть другу строку: ");
        System.out.println();
        String s2 = sc.next();

        sc.close();

        try {
            calc(s1, s2);
        }catch (Exception e){
            System.out.println("Ви ввели не число!");
        }
    }

    public static void calc(String s1, String s2){

        System.out.println();
        System.out.println('\t' + s1);
        System.out.println("X" + '\t' + s2);
        System.out.println("-----------------------------");

        BigInteger ten = BigInteger.valueOf(10);

        BigInteger num1 = new BigInteger(s1);
        BigInteger num2 = new BigInteger(s2);

        BigInteger[] masb1 = new BigInteger[s1.length()];
        BigInteger[] masb2 = new BigInteger[s2.length()];

        BigInteger sum = BigInteger.valueOf(0);

        BigInteger temp1;
        BigInteger temp2;

        BigInteger dec1 = BigInteger.valueOf(1);
        BigInteger dec2 = BigInteger.valueOf(1);

        for (int i = 0; i < s1.length(); i++) {

            temp1 = (num1.remainder(ten).multiply(dec1));
            num1 = num1.divide(ten);
            masb1[i] = temp1;
            dec1 = dec1.multiply(ten);
        }

        for (int i = 0; i < s2.length(); i++) {
            temp2 = (num2.remainder(ten).multiply(dec2));
            num2 = num2.divide(ten);
            masb2[i] = temp2;
            dec2 = dec2.multiply(ten);
        }

        for (int i = 0; i < masb1.length; i++) {
            for (int j = 0; j < masb2.length; j++) {
                sum = sum.add(masb1[i].multiply(masb2[j]));
                System.out.println(masb1[i] + " * " + masb2[j]);
                if (j < masb2.length -1 || i < masb1.length -1) {
                    System.out.println("Sum: " + sum + '\n');
                    System.out.print(" + ");
                }
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Sum: " + sum);
    }
}