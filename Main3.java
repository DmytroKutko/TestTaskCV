import java.util.Scanner;

public class Main3 {

    static int [] result;
    static int [] tempResult;
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
        int tx = (s2.length() * 2) -1;

        System.out.println('\t' + s1);
        System.out.println("X" + '\t' + s2);
        System.out.println();


        for (int i = mas1.length - 1; i >= 0; i--) {

            tempResult = new  int[tx];

            int stepcount = 0;
            int stepx = x;
            int steptx = tx;

            for (int j = mas2.length - 1; j >= 0 ; j--) {

                temp1 = mas1[i];
                temp2 = mas2[j];
                temp3 = temp1 * temp2;
                tempResult[tx -1] += temp3;
                res[x] += temp3;
                x--;
                tx--;
            }

            stepcount++;
            x = stepx - stepcount;
            tx = steptx - stepcount;

            sortTemp(tempResult);

            boolean bool = false;

            for (int a : tempResult){
                if (Integer.valueOf(a) == 0 && bool == false) {
                    System.out.print(" ");;
                } else {
                    bool = true;
                    System.out.print(a);
                }
            }

            System.out.println();

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

    public static void sortTemp(int [] arr){

        int temp = 0;
        boolean bool = true;

        tempResult = arr;

        for (int i = tempResult.length -1; i >= 0; i--) {
            temp = Integer.valueOf(arr[i]);

            if (temp >= 10){
                bool = false;
                tempResult[i] = temp % 10;
                tempResult[i - 1] = tempResult[i -1] + (temp / 10);
            }

            if (bool == false){
                bool = true;
                sortTemp(tempResult);
                break;
            }
        }
    }
}