# Web eCommerce Automation

Proyek ini merupakan otomatisasi pengujian untuk aplikasi web eCommerce menggunakan Selenium dan TestNG.

## Struktur Proyek

- `src/main/java`: Kode utama (Page Object, utilitas, repository).
- `src/test/java`: Kode pengujian (Test Case).
- `src/test/resources`: Konfigurasi TestNG (`testng.xml`).
- `target/surefire-reports`: Laporan hasil pengujian.

## Teknologi

- Java 8+
- Selenium WebDriver
- TestNG
- Maven

## Arsitektur Otomasi

- **Page Object Model (POM):** Memisahkan logika halaman web dan aksi pengguna untuk memudahkan pemeliharaan.
- **TestNG:** Framework pengujian untuk mengelola skenario dan laporan.
- **Maven:** Manajemen dependensi dan build.

## Cara Menjalankan Test

1. Pastikan Java dan Maven sudah terinstal.
2. Install browser driver (misal: ChromeDriver) dan pastikan PATH sudah sesuai.
3. Jalankan perintah berikut di terminal:

   ```sh
   mvn clean test
   ```

4. Hasil test dapat dilihat di folder `target/surefire-reports`.

## Fitur Pengujian

- Autentikasi (login valid/invalid, tanpa username/password)
- Validasi tampilan produk
- Drag & drop dan resize elemen
- Pengujian filter dan pencarian produk
- **Add to Cart** (menambah produk ke keranjang dan validasi jumlah item)
- Checkout dan pembayaran (dummy)
- Validasi notifikasi dan error message

## Konfigurasi Test

Edit file [src/test/resources/testng.xml](src/test/resources/testng.xml) untuk mengatur parameter test seperti username, password, dan baseURL.

Untuk mengatur target environment (misal: staging, production), tambahkan parameter pada bagian `<suite>` di `testng.xml` seperti contoh berikut:

```xml
<suite name="Ecommerce Test Suite">
  <parameter name="baseURL" value="https://staging.ecommerce.com"/>
  <parameter name="username" value="testuser"/>
  <parameter name="password" value="testpass"/>
  <!-- Tambahkan parameter lain sesuai kebutuhan -->
  ...
</suite>
```

Kemudian, di kode Java Anda, gunakan annotation TestNG untuk mengambil parameter tersebut:

```java
@Parameters({"baseURL", "username", "password"})
@BeforeClass
public void setup(String baseURL, String username, String password) {
    // Inisialisasi WebDriver dan login sesuai parameter
}
```

Pastikan setiap perubahan pada `testng.xml` sesuai dengan environment dan kebutuhan pengujian Anda.

## Troubleshooting

- Pastikan versi browser dan driver kompatibel.
- Jika test gagal, cek log di `target/surefire-reports`.
- Untuk error Selenium, pastikan browser tidak berjalan di background.

## Cara Kontribusi

1. Fork repository ini.
2. Buat branch baru untuk fitur/bugfix.
3. Lakukan perubahan dan commit.
4. Ajukan Pull Request dengan deskripsi yang jelas.

## Referensi

- [Dokumentasi Selenium](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Documentation](https://maven.apache.org/guides/)

## Kontributor

- Deni Rudini

## Trainer
- Yanwar 

## Lisensi

Proyek ini menggunakan lisensi