package TestSF;

import java.util.Scanner;

public class Main1 {

    static String [] result;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Введіть першу строку: ");
        System.out.println();
        String st1 = sc.next();

        System.out.print("Введіть другу строку: ");
        System.out.println();
        String st2 = sc.next();

        sc.close();

        String [] arr1 = st1.split("");
        String [] arr2 = st2.split("");

        int temp1 = 0;
        int temp2 = 0;
        int temp3 = 0;

        int count = st1.length() * st2.length() -1;



        String [] [] arr = new String[st1.length() * st2.length()][st1.length() * st2.length()];

        String [] sum = new String[st1.length() * st2.length()];

//        for (int i = 0; i < st1.length() + st2.length(); i++) {
//            for (int j = 0; j < st1.length() + st2.length(); j++) {
//                arr[i][j]="";
//            }
//        }

        // multiple

        int x = st1.length() * st2.length() -1;
        int y = 0;

        for (int i = arr1.length -1; i >= 0; i--) {

            int stepcount = 0;

            int stepx = x;
            for (int j = arr2.length -1; j >= 0; j--) {

                temp1 = Integer.valueOf(arr1[i]);
                temp2 = Integer.valueOf(arr2[j]);
                temp3 = temp1 * temp2;

                arr[y][x] = String.valueOf(temp3 % 10);
                if (temp3 >= 10){
                    arr[y][x -1] = String.valueOf(temp3 / 10);
                }

//                if (j == arr2.length -1){
//                    x--;
//                } else if(stepx > 0) {
//                    stepx -=1;
//                } else {
//                    x--;
//                }
                    x--;
                    y++;
            }
            stepcount++;
            x = stepx - stepcount;
        }


        // adding
        for (int x1 = st1.length() * st2.length() -1; x1 >= 0; x1--) {

            int tempAdd = 0;

            for (int y1 = 0; y1 < st1.length() * st2.length(); y1++) {
                if (arr[y1][x1] != null) {
                    tempAdd += Integer.valueOf(arr[y1][x1]);
                }
            }
            sum[x1] = String.valueOf(tempAdd);
        }

        // check mas
        for (int i = 0; i < st1.length() * st2.length(); i++) {
            for (int j = 0; j < st1.length() * st2.length(); j++) {
                if (arr[i][j] == null){
                    System.out.print('\t');
                }else {
                    System.out.print(arr[i][j] + '\t');
                }
            }
            System.out.println();
        }
//        for (String s : sum){
//            System.out.print(s + ",");
//        }


        sortSumm(sum);

        boolean bool = false;

        System.out.println("Result : ");
        for (String s : result){
            if (Integer.valueOf(s) == 0 && bool == false) {
                continue;
            } else {
                bool = true;
            System.out.print(s);
            }
        }

    }

    public static void sortSumm(String [] sum){

        int temp = 0;
        boolean bool = true;

        result = sum;

        for (int i = result.length -1; i >= 0; i--) {
            temp = Integer.valueOf(sum[i]);

            if (temp >= 10){
                bool = false;
                result[i] = String.valueOf(temp % 10);
                result[i -1] = String.valueOf(Integer.valueOf(result[i -1]) + (temp / 10));
            }

            if (bool == false){
                bool = true;
                sortSumm(result);
                break;
            }
        }
    }
}
