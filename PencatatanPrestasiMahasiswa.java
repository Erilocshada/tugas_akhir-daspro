import java.util.ArrayList;
import java.util.Scanner;

class Prestasi {
    String namaMahasiswa;
    String nimMahasiswa;
    String jenisPrestasi;
    String tingkatPrestasi;
    int tahunPrestasi;

    public Prestasi(String nama, String nim, String jenis, String tingkat, int tahun) {
        this.namaMahasiswa = nama;
        this.nimMahasiswa = nim;
        this.jenisPrestasi = jenis;
        this.tingkatPrestasi = tingkat;
        this.tahunPrestasi = tahun;
    }

    public String toString() {
        return "Nama: " + namaMahasiswa + " | NIM: " + nimMahasiswa +
               " | Jenis: " + jenisPrestasi + " | Tingkat: " + tingkatPrestasi +
               " | Tahun: " + tahunPrestasi;
    }
}

public class PencatatanPrestasiMahasiswa {
    static ArrayList<Prestasi> daftarPrestasi = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membaca newline setelah input angka

            switch (pilihan) {
                case 1:
                    tambahDataPrestasi();
                    break;
                case 2:
                    tampilkanSemuaPrestasi();
                    break;
                case 3:
                    analisisPrestasiBerdasarkanJenis();
                    break;
                case 4:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Coba lagi.");
            }
        } while (pilihan != 4);
    }

    static void tampilkanMenu() {
        System.out.println("=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah Data Prestasi");
        System.out.println("2. Tampilkan Semua Prestasi");
        System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
        System.out.println("4. Keluar");
    }

    static void tambahDataPrestasi() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan NIM Mahasiswa: ");
        String nim = scanner.nextLine();

        System.out.print("Masukkan Jenis Prestasi (Juara 1 / Juara 2 / Juara 3): ");
        String jenis = scanner.nextLine();

        System.out.print("Masukkan Tingkat Prestasi (Lokal / Nasional / Internasional): ");
        String tingkat = scanner.nextLine();

        int tahun;
        do {
            System.out.print("Masukkan Tahun Prestasi (2010 - 2024): ");
            tahun = scanner.nextInt();
            scanner.nextLine(); // Membaca newline setelah input angka
            if (tahun < 2010 || tahun > 2024) {
                System.out.println("Tahun tidak valid. Coba lagi.");
            }
        } while (tahun < 2010 || tahun > 2024);

        daftarPrestasi.add(new Prestasi(nama, nim, jenis, tingkat, tahun));
        System.out.println("Data prestasi berhasil ditambahkan.");
    }

    static void tampilkanSemuaPrestasi() {
        if (daftarPrestasi.isEmpty()) {
            System.out.println("Belum ada data prestasi.");
        } else {
            System.out.println("=== DAFTAR SEMUA PRESTASI ===");
            for (Prestasi p : daftarPrestasi) {
                System.out.println(p);
            }
        }
    }

    static void analisisPrestasiBerdasarkanJenis() {
        if (daftarPrestasi.isEmpty()) {
            System.out.println("Belum ada data prestasi untuk dianalisis.");
        } else {
            int juara1 = 0, juara2 = 0, juara3 = 0;

            for (Prestasi p : daftarPrestasi) {
                switch (p.jenisPrestasi) {
                    case "Juara 1":
                        juara1++;
                        break;
                    case "Juara 2":
                        juara2++;
                        break;
                    case "Juara 3":
                        juara3++;
                        break;
                }
            }

            System.out.println("=== ANALISIS PRESTASI BERDASARKAN JENIS ===");
            System.out.println("Juara 1: " + juara1);
            System.out.println("Juara 2: " + juara2);
            System.out.println("Juara 3: " + juara3);
        }
    }
}
