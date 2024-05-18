import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        // Buat Direktori
        File dir = new File("direktori");
        dir.mkdir();

        // File Opsi Constructor 1
        File file1 = new File("direktori/file1.txt");
        try {
            file1.createNewFile();
        } catch (IOException error) {
            System.out.println(error);
        }
        System.out.println("Lokasi File 1: " + file1.getPath());
        System.out.println("Status File 1: " + file1.exists());

        // Separator
        System.out.println();
        // Separator

        // File Opsi Constructor 2
        File file2 = new File("direktori", "file2.txt");
        try {
            file2.createNewFile();
        } catch (IOException error) {
            System.out.println(error);
        }
        System.out.println("Lokasi File 2: " + file2.getPath());
        System.out.println("Status File 2: " + file2.exists());

        // Separator
        System.out.println();
        // Separator

        // File Opsi Constructor 3
        dir = new File("direktori/dirbaru");
        File file3 = new File(dir, "file3.txt");
        try {
            dir.mkdir();
            file3.createNewFile();
        } catch (Exception error) {
            System.out.println(error);
        }
        System.out.println("Lokasi File 3: " + file3.getPath());
        System.out.println("Status File 3: " + file3.exists());

        // Separator
        System.out.println();
        // Separator

        // Tulis File
        String Outputdata = "Hello World!";
        try {
            FileOutputStream output = new FileOutputStream(file1);
            output.write(Outputdata.getBytes());
            output.close();
            System.out.println("Data Berhasil Ditulis ke File 1");
        } catch (IOException error) {
            System.out.println(error);
        }

        // Baca File
        try {
            java.io.FileInputStream input = new FileInputStream(file1);
            int inputData;
            System.out.print("Isi File 1 Dibaca dengan FileInputStream: ");
            while ((inputData = input.read()) != -1) {
                System.out.print((char) inputData);
            }
            input.close();
        } catch (IOException error) {
            System.out.println(error);
        }

        // Separator
        System.out.println();
        // Separator

        // Baca File denagn File Reader dan Buffered Reader
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
            System.out.print("Isi File 1 Dibaca dengan FileReader dan BufferedReader: ");
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                System.out.print(data);
            }
            bufferedReader.close();
        } catch (IOException error) {
            System.out.println(error);
        }

    }

}