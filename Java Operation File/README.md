# Java Operation File

File Operation adalah bagian dari setiap bahasa pemrograman. File Operation memungkinkan output dari program java untuk disimpan ke dalam sebuah file. Sederhananya, File Operation berarti proses baca tulis data yang melibatkan file. Class File berasal dari package java.io yang digunakan untuk melakukan berbagai operasi tersebut pada file dan direktori. Package tersebut mengandung banyak method untuk membuat, membaca, update, dan menghapus file.

![./img/fileop.jpg](Java File Operation)

Class File memiliki 3 constructor yang sering dipakai, yaitu:

```Java
// Constructor 1
File file1 = new File(String filename);

// Constructor 2
File file2 = new File(String directory, String filename);

// Constructor 3
File file3 = new File (File directory, String filename)
```

## Stream

Sesuai namanya, stream adalah aliran dari serangkaian data yang berhulu dari sumber input dan berhilir di tujuan output. Biasanya, stream digunakan dalam operasi baca tulis file. Terdapat dua tipe stram di java, yaitu byte stream dan character stream.

![./img/hierarki.png](Hirarki Stream)

Byte stram memiliki dua turunan, yaitu InputStream untuk data masuk dan OutputStream untuk data keluar. Contoh dari turunan InputStream adalah FileInputStream, BufferedInputStream, DataInputStream, ObjectInputStream, dan ByteArrayInputStream. Sedangkan OutputStream memiliki turunan FileOutputStream, BufferedOutputStream, DataOutputStream, ObjectOutputStream, dan ByteArrayOutputStream. Masing-masing memiliki fungsi dan kegunaannya masing-masing.