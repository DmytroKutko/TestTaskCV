package TestSF;

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

        int num1 = Integer.parseInt(s1);
        int num2 = Integer.parseInt(s2);

        int [] mas1 = new int[s1.length()];
        int [] mas2 = new int[s2.length()];

        int sum = 0;

        int temp1 = 0;
        int temp2 = 0;

        int dec1 = 1;
        int dec2 = 1;

        for (int i = 0; i < s1.length(); i++) {
            temp1 = (num1 % 10) * dec1;
            num1 /= 10;
            mas1[i]= temp1;
            dec1 *= 10;
        }

        for (int i = 0; i < s2.length(); i++) {
            temp2 = (num2 % 10) * dec2;
            num2 /= 10;
            mas2[i]= temp2;
            dec2 *= 10;
        }

        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j < mas2.length; j++) {
                sum += mas1[i] * mas2[j];
                System.out.println(mas1[i] + " * " + mas2[j]);
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Sum: " + sum);
    }
}