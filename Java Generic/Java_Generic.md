# Java Generic

Generic adalah fitur yang mulai diperkenalkan di Java versi 5. Generic bertujuan untuk menyediakan fleksibilitas dalam menentukan tipe data tanpa harus melakukan type casting. Dengan adanya generic, suatu kode bisa digeneralisasi dan reusable. Pengimplementasian generic dilakukan dengan menambahkan parameter tipe data di suatu class atau method. Mengimplementasikan generic pada suatu class atau method akan membuat tipe datanya bebas diubah sesuai kebutuhan.

## Class Generic

Seperti yang telah disebutkan sebelumnya, salah satu implementasi generic adalah menambahkan parameter tipe data pada class. Parameter tipe data bisa diberi nama apa saja. Namun, penamaan yang sesuai standar hanya menggunakan 1 karakter sesuai dengan jenisnya.

- E = Elemen
- K = Key
- N = Number
- V = Value
- T = 1st Type
- S,U,V etc. = 2nd, 3rd, 4th types

Perbedaan implementasi class konvensional dan generic dapat dilihat pada kedua kode berikut.

### Class konvensional

```Java
public class Konvensional {

	private string data;

	public string getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data
	}

}
```

### Class generic

```Java
public class Generic<T> {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data
	}

}
```

Class generic juga memperbolehkan lebih dari satu tipe data. Nama parameter tipe data harus berbeda (T, U, V, dst).

```Java
public class Generic<T, U> {

	private T data1;
	private U data2;

	public T getData1() {
		return data1;
	}

	public void setData1(T data1) {
		this.data1 = data1
	}

	public U getData2() {
		return data2;
	}

	public void setData2(U data2) {
		this.data2 = data2
	}

}
```

## Method Generic

Contoh implementasi selanjutnya adalah Method Generic. Parameter tipe data yang dideklarasikan hanya bisa diakses di method tersebut, tidak bisa digunakan di luar method. Dengan mengimplementasikan generic, maka method tersebut bisa dipakai untuk segala macam tipe data. Java juga memberikan perlakuan khusus untuk mendeklarasikan sebuah method generic yang disebut dengan method polymorphic. Berikut adalah contoh dari implementasi method generic.

```Java
public class generic {
	public static <E> void printArray(E[] array) {
		for (E element : array) {
			System.out.printf("%s", element);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] int = {1,2,3,4};
		Double[] double = {1.1,2.2,3.3,4.4};
		Character[] char = {'J','A','V','A'};

		printArray(int);
		printArray(double);
		printarray(char);
	}
}
```

---
