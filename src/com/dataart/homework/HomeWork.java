package com.dataart.homework;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.util.Arrays.*;

public class HomeWork {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        int task1Number = 5732;
        int resultTask1 = task1(task1Number);

        int[] arrTask2 = new int[100];
        StringBuilder resultTask2 = task2(arrTask2);

        StringBuilder resultTask2_1 = task2_1(new int[1 + new Random().nextInt(30)]);

        int[] arrTask3 = new int[]{2, 4, 8};
        double resultTask3 = task3(arrTask3);
        double resultTask3_1 = task3_1(arrTask3);


        stringBuilder
                .append("Task1: Result sum of numbers [" + task1Number + "] is: " + resultTask1+"\n")
                .append("\nTask2: " + resultTask2+"\n")
                .append("\nTask2_1: " + resultTask2_1+"\n")
                .append("\nTask3: " + resultTask3+"\n")
                .append("\nTask3_1: " + resultTask3_1+"\n")
                .append("\nTask3_2: ")

        ;
        System.out.println(stringBuilder);
        stringBuilder.setLength(0);
        int[] arrForTaksk4_1 = generetaArr(4, 1000);
        int[] arrForTaksk4_2 = generetaArr(5, 1000);
        int[] arrForTaksk4_3 = generetaArr(10, 1000);
        int low = 0;
        int high = arrForTaksk4_3.length - 1;
        String strTask5 = "Java School allows you to try java programming language on practice. " +
                "Java one of the most popular programming languages. I love Java!!!";
        String strKeyTask5 = "Java";


        stringBuilder
                .append(task3_2()+"\n")
                .append("\nTask4_1: " + task4_1(arrForTaksk4_1)+"\n")
                .append("\nTask4_2: Old array - " + Arrays.toString(arrForTaksk4_2) + " New array - " + task4_2(arrForTaksk4_2)+"\n")
                .append("\nTask4_3: Old array - " + Arrays.toString(arrForTaksk4_3) + " New array - "
                        + task4_3(arrForTaksk4_3, low, high)+"\n")
                .append("\nTask5: Werb [" + strKeyTask5 + "] meets " + task5(strTask5, strKeyTask5) + " times"+"\n")
                .append("\nTask5_1: Werb [" + strKeyTask5 + "] meets in this positions " + task5_1(strTask5, strKeyTask5)+"\n")
                .append("\nTask5_2:")
        ;

        System.out.println(stringBuilder);
        stringBuilder.setLength(0);

        int[] arrMeanTempOptionTask2 = {-74, -2, 24, 56};

        stringBuilder
                .append(task5_2())
                .append("\nOptionTask1: " + optionTask1()+"\n")
                .append("\nOptionTask2: " + optionTask2(arrMeanTempOptionTask2)+"\n")
                .append("\nOptionTask3: " + optionTask3(10)+"\n")
        ;
        System.out.println(stringBuilder);
    }

    public static int task1(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static StringBuilder task2_1(int[] arr) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int number = 2;
        while (count < arr.length) {
            int countDelitel = 1;
            for (int i = 2; i <= number; i++) {
                if (number % i == 0) countDelitel++;
            }
            if (countDelitel == 2) {
                arr[count] = number;
                sb.append(number);
                count++;
                if (count != arr.length) sb.append(", ");
            }
            number++;
        }
        return sb;
    }

    public static StringBuilder task2(int[] arr) {
        return task2_1(arr);
    }

    public static double task3(int[] arr) {
        double sum = 0;
        for (int a : arr) {
            sum += a;
        }
        return sum / arr.length;
    }

    public static double task3_1(int[] arr) {
        double prod = 1;
        for (int a : arr) {
            prod = prod * a;
        }
        return Math.pow(prod, (1.0 / (double) arr.length));
    }

    public static StringBuilder task3_2() {

        System.out.println("You can choose kind operation for task3_2:\n" +
                "1 - average\n" +
                "2 - geometric mean ");
        Scanner scanner = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        int metChoose = scanner.nextInt();
        if (metChoose == 1 || metChoose == 2) {
            System.out.println("Enter the size of the array");
            int size = scanner.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Input " + (i + 1) + " number");
                arr[i] = scanner.nextInt();
            }
            if (metChoose == 1) return builder.append("average: " + task3(arr));
            else return builder.append("geometric mean: " + task3_1(arr));
        } else {
            return builder.append("Wrong answer. Good luck next time.");
        }
    }

    public static StringBuilder task4_1(int[] arr) {
        StringBuilder sb = new StringBuilder();
        sb.append("({");
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(", ");
        }
        sb.append("})={");
        boolean needSort = true;
        while (needSort) {
            needSort = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    needSort = true;
                    arr[i] = arr[i] + arr[i + 1];
                    arr[i + 1] = arr[i] - arr[i + 1];
                    arr[i] = arr[i] - arr[i + 1];

                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i != arr.length - 1) sb.append(", ");
        }
        sb.append("}");
        return sb;
    }

    public static StringBuilder task4_2(int[] arr) {
        StringBuilder sb = new StringBuilder();
        boolean needSort = true;
        while (needSort) {
            needSort = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    needSort = true;
                    Random rnd = new Random();
                    for (int j = 0; j < arr.length; j++) {
                        int index = rnd.nextInt(j + 1);
                        int a = arr[index];
                        arr[index] = arr[j];
                        arr[j] = a;
                    }
                    task4_2(arr);
                }
            }
        }
        return sb.append(Arrays.toString(arr));
    }

    public static int[] generetaArr(int maxSize, int maxEl) {
        int[] arr = new int[3 + new Random().nextInt(maxSize - 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1 + new Random().nextInt(maxEl);
        }
        return arr;
    }

    public static StringBuilder task4_3(int[] arr, int low, int high) {
        StringBuilder sb = new StringBuilder();
        if (low >= high) {
            return sb.append(Arrays.toString(arr));
        }
        int middle = low + (high - low) / 2;
        int opora = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < opora) {
                i++;
            }

            while (arr[j] > opora) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            task4_3(arr, low, j);

        if (high > i)
            task4_3(arr, i, high);

        return sb.append(Arrays.toString(arr));
    }

    public static int task5(String str, String key) {
        String[] strList = str.split(" ");
        int count = 0;
        for (int i = 0; i < strList.length; i++) {
            if (strList[i].toUpperCase().contains(key.toUpperCase())) {
                count++;
            }
        }
        return count;
    }

    public static String task5_1(String str, String key) {
        int size = task5(str, key);
        int arr[] = new int[size];
        int positiontArr = 0;
        char[] chStr = str.toUpperCase().toCharArray();
        char[] chKey = key.toUpperCase().toCharArray();
        int lengthKeyWord = chKey.length;
        for (int i = 0; i < chStr.length; i++) {
            int count = 0;
            if (chStr[i] == chKey[0]) {
                for (int j = 0; j < chKey.length; j++) {
                    if (chStr[i + j] == chKey[j]) {
                        count++;
                    }
                    if (count == lengthKeyWord) {
                        arr[positiontArr] = i;
                        positiontArr++;
                    }
                }
            }

        }
        return Arrays.toString(arr);
    }

    public static String task5_2() {
        System.out.println("Enter the sentence in which you will search for the word");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println("Enter word. Length must more one character. ");
        String key = sc.nextLine();
        if (key.length()<=1) return "Word must more one character. Good luck next time.\n";
        return "Werb [" + key + "] meets in this positions " + task5_1(str, key);
    }

    public static StringBuilder optionTask1() {
        int countDay = 30;
        StringBuilder sb = new StringBuilder();
        int[] arrTemp = generateTemp(countDay);
        sb.append(Arrays.toString(arrTemp));
        for (int i = 0; i < arrTemp.length; i++) {
            sb.append("\n" + (i + 1) + " Day, " + arrTemp[i] + " degree");
        }
        return sb;
    }

    public static int[] generateTemp(int countDay) {
        int[] arr = new int[countDay];
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -100 + random.nextInt(200);
        }
        return arr;
    }

    public static StringBuilder optionTask2(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int temp : arr) {
            sb.append("\n" + whatNeedTake(temp));
        }
        return sb;
    }

    public static StringBuilder whatNeedTake(int temp) {
        StringBuilder sb = new StringBuilder();

        switch (range(temp)) {
            case 0:
                sb.append("For temp " + temp + " need take " + Weather.FROST.toString());
                break;
            case 1:
                sb.append("For temp " + temp + " need take " + Weather.COOL.toString());
                break;
            case 2:
                sb.append("For temp " + temp + " need take " + Weather.WARM.toString());
                break;
            case 3:
                sb.append("For temp " + temp + " need take " + Weather.HOT.toString());
                break;


        }
        return sb;
    }


    public static int range(int temp) {
        if (temp >= -100 && temp < -50) return 0;
        else if (temp >= -50 && temp < 0) return 1;
        else if (temp >= 0 && temp < 50) return 2;
        else if (temp >= 50 && temp <= 100) return 3;
        return temp;
    }

    public static StringBuilder optionTask3(int countDay) {
        StringBuilder sb = new StringBuilder();
        int[] arrTemp = generateTemp(countDay);
        for (int i = 0; i < arrTemp.length; i++) {
            sb
                    .append("\n" + (i + 1) + " Day, " + arrTemp[i] + " degree ")
                    .append(whatNeedTake(arrTemp[i]))
            ;
        }
        return sb;
    }

}
