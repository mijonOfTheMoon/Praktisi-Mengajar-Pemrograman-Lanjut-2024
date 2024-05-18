import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // Exception Aritmatika
        try {
            System.out.println(10 / 0);
        } catch (ArithmeticException error) {
            System.out.println(error);
            System.out.println("Sepuluh tidak bisa dibagi nol");
        }

        // Separator
        System.out.println();
        // Separator

        // Exception Null Pointer
        try {
            String x = null;
            System.out.println(x.charAt(0));
        } catch (NullPointerException error) {
            System.out.println(error);
            System.out.println("Char dari string yang masih null tidak bisa diakses");
        }

        // Separator
        System.out.println();
        // Separator

        // Exception Array Index Out of Bounds
        try {
            int[] array = new int[5];
            System.out.println(array[10]);
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println(error);
            System.out.println("Index yang tidak ada pada array tidak bisa diakses");
        }

        // Separator
        System.out.println();
        // Separator

        // Exception dengan banyak catch
        try {
            int[] array = new int[-1];
        } catch (ArithmeticException error) {
            System.out.println(error);
            System.out.println("Terjadi kesalahan aritmatika");
        } catch (NullPointerException error) {
            System.out.println(error);
            System.out.println("Terjadi kesalahan null pointer");
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println(error);
            System.out.println("Terjadi kesalahan array index out of bounds");
        } catch (Exception error) {
            System.out.println(error);
            System.out.println("Terjadi kesalahan lain");
        }

        // Separator
        System.out.println();
        // Separator

        // Exception throw
        try {
            cekChar(null);
        } catch (NullPointerException error) {
            System.out.println(error);
        }

        // Separator
        System.out.println();
        // Separator

        // Exception throws
        try {
            cekLength(null);
        } catch (NullPointerException error) {
            System.out.println(error);
            System.out.println("Mengukur panjang string tidak bisa null");
        }

        // Separator
        System.out.println();
        // Separator

        // Exception dengan finally
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Masukkan angka: ");
            int angka = input.nextInt();
            System.out.println("Angka yang dimasukkan adalah " + angka);
        } catch (InputMismatchException error) {
            System.out.println(error);
            System.out.println("Hanya masukkan angka!");
        } finally {
            System.out.println("Input ditutup");
            input.close();
        }
    }

    // Exception throw
    public static void cekChar(String string) {
        try {
            System.out.println(string.charAt(0));
        } catch (NullPointerException error) {
            throw new NullPointerException("Mencari char pertama dari string tidak bisa null");
        }
    }

    // Exception throws
    public static void cekLength(String string) throws ArithmeticException {
        System.out.println(string.length());
    }
}