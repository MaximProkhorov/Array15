package array15;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author PM051
 */
public class Array15 {

    public static void main(String[] args) {
        int[] vhodnoiMassiv = new int[15];

        System.out.println("Введите элементы массива :");
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < vhodnoiMassiv.length; i++) {
            vhodnoiMassiv[i] = Integer.parseInt(reader.nextLine());
        }

        check(vhodnoiMassiv);
        int[] resultMassiv = zapolnit(vhodnoiMassiv);
        System.out.println(Arrays.toString(resultMassiv));
    }

    public static void check(int[] vhodnoiMassiv) {
        for (int i = 0; i < vhodnoiMassiv.length; i++) {
            if (vhodnoiMassiv[i] <= 15) {
                throw new IllegalArgumentException("Числа массиве должны быть больше 15");
            }
            for (int i1 = 0; i1 < i; i1++) {
                if (vhodnoiMassiv[i1] == vhodnoiMassiv[i]) {
                    throw new IllegalArgumentException("Число " + vhodnoiMassiv[i1] + " повторяется");
                }
            }
        }
    }

    public static int[] zapolnit(int[] vhodnoiMassiv) {
        int[] array = new int[15];
        int counter = 0;
        for (int i = 0; i < 15; i++) {
            int ostatok = vhodnoiMassiv[i] % 15;
            while (array[ostatok] != 0) {
                ostatok += 3;
                if (ostatok >= 15) {
                    ostatok -= 15;
                    counter++;
                }
                if (counter == 2) {
                    throw new RuntimeException("Произошло зацикливание");
                }
            }
            array[ostatok] = vhodnoiMassiv[i];
            counter = 0;
        }
        return array;
    }
}
