# Java Exception Handling

Exception Handling adalah mekanisme untuk menangani runtime error yang ringan (mild error). Ketika terjadi error, normalnya Java akan berhenti dan menghasilkan pesan error. Istilah teknis untuk hal ini adalah exception, yaitu java akan melempar suatu error. Suatu exception direpresentasikan oleh sebuah objek yang menjelaskan exception tersebut.

Exception yang sering terjadi pada Bahasa pemrograman Java adalah:

- Arithmetic Exception, Jika sebuah angka dibagi 0.
- Null Pointer Exception, Jika object yang ingin diakses masih NULL.
- Number Format Exception, Jika ingin melakukan casting tipe data string ke int.
- IO Exception, Jika yang diminta adalah angka tapi diinput String

Exception Handling biasanya diimplementasikan dengan metode try catch. Metode ini digunakan untuk mendefinisikan kode yang ingin dicoba untuk dijalankan (try) dan kode yang dijalankan apabila terjadi error (catch). Secara umum, anatomi dari try catch adalah seperti berikut.
```Java
try {
	// Kode yang dijalankan
} catch (ExceptionTertentu objekDariExceptionTersebut) {
	// Kode yang dijalankan jika kode di atas error
}
```
