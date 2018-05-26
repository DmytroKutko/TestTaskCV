package TestSF;

import java.util.Scanner;

public class Main2 {

    static int [] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть першу строку: ");
        System.out.println();
        String s1 = sc.next();

        System.out.print("Введіть другу строку: ");
        System.out.println();
        String s2 = sc.next();

        sc.close();

        String [] arr1 = s1.split("");
        String [] arr2 = s2.split("");

        int [] mas1 = new int[arr1.length];
        int [] mas2 = new int[arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            mas1[i] = Integer.valueOf(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            mas2[i] = Integer.valueOf(arr2[i]);
        }

        int [] res = new int[s1.length() * s2.length()];

        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;

        int x = (s1.length() * s2.length()) -1;

        for (int i = mas1.length - 1; i >= 0; i--) {

            int stepcount = 0;
            int stepx = x;

            for (int j = mas2.length - 1; j >= 0 ; j--) {

                temp1 = mas1[i];
                temp2 = mas2[j];
                temp3 = temp1 * temp2;
                System.out.println(temp1 + " * " + temp2 + " = " + temp3);
                res[x] += temp3;
                x--;
            }
            stepcount++;
            x = stepx - stepcount;
        }

        sortSumm(res);

        boolean bool = false;

        System.out.println("Result : ");
        for (int s : result){
            if (Integer.valueOf(s) == 0 && bool == false) {
                continue;
            } else {
                bool = true;
                System.out.print(s);
            }
        }

    }

    public static void sortSumm(int [] sum){

        int temp = 0;
        boolean bool = true;

        result = sum;

        for (int i = result.length -1; i >= 0; i--) {
            temp = Integer.valueOf(sum[i]);

            if (temp >= 10){
                bool = false;
                result[i] = temp % 10;
                result[i -1] = result[i -1] + (temp / 10);
            }

            if (bool == false){
                bool = true;
                sortSumm(result);
                break;
            }
        }
    }
}
