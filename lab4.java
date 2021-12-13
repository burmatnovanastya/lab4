import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Чтобы закончить ввод чисел, напишите слово \"quit\"");
        int n = 1000000;
        int[] numbers = new int[n];
        int k = 0;
        do {
            System.out.print("Введите " + (k + 1) + " число: ");
            if (scan.hasNextInt()) {
                numbers[k] = scan.nextInt();
                k++;
            } else if(scan.next().equals("quit")){
                break;
            } else {
                System.out.println("Ошибка ввода. Программа закончила своё выполнение.");
                return;
            }
        } while (true);
        int[] start_arr = Arrays.copyOf(numbers, k);
        System.out.print("Введите число, которое нужно удалить из массива: ");
        int x;
        if (scan.hasNextInt()) {
            x = scan.nextInt();
        } else {
            System.out.println("Ошибка ввода. Программа закончила своё выполнение.");
            return;
        }
        int[] new_arr = start_arr.clone();
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (new_arr[i] == x) {
                new_arr[i] = -1000000;
                count += 1;
            }
        }
        int[] result = new int[k - count];
        int j = 0;
        for (int i = 0; i < k; i++) {
            if (new_arr[i] != -1000000) {
                result[j] = new_arr[i];
                j += 1;
            }
        }
        //исходный массив
        System.out.print("Исходный массив: ");
        for (int i = 0; i < start_arr.length; i++) {
            if (i == start_arr.length - 1)
                System.out.print(start_arr[i]);
            else
                System.out.print(start_arr[i] + ", ");
        }
        //изменённый массив
        System.out.print("\nИзменённый массив: ");
        for (int i = 0; i < result.length; i++) {
            if (i == result.length - 1)
                System.out.print(result[i]);
            else
                System.out.print(result[i] + ", ");
        }
        scan.close();
    }
}
