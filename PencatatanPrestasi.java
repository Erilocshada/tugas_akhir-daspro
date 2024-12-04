import java.util.ArrayList;
import java.util.Scanner;

public class PencatatanPrestasi {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String[]> dataPrestasi = new ArrayList<>();
    static void tampilkanMenu() {
        System.out.println("\n=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah Data Prestasi");
        System.out.println("2. Tampilkan Semua Prestasi");
        System.out.println("3. Analisis Prestasi berdasarkan Jenis");
        System.out.println("4. Keluar");
    }
    static void tambahDataPrestasi() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String namaMhs = sc.nextLine();
        System.out.print("Masukkan NIM: ");
        String nim = sc.nextLine();
        System.out.print("Masukkan Jenis Prestasi: ");
        String jenis = sc.nextLine();
        System.out.print("Masukkan Tingkat Prestasi (Lokal/Nasional/Internasional): ");
        String tingkat = sc.nextLine();

        String tahun;
        while (true) {
            System.out.print("Masukkan Tahun Prestasi (2010-2024): ");
            tahun = sc.nextLine();
            if (tahun.matches("201[0-9]|202[0-4]")) {
                break;
            } else {
                System.out.println("Tahun Tidak Valid, Coba lagi.");
            }
        }
        String[] prestasi = {namaMhs, nim, jenis, tingkat, tahun};
        dataPrestasi.add(prestasi);
        System.out.println("Data Prestasi Berhasil Ditambahkan!");
    }
    static void tampilkanSemuaPrestasi() {
        System.out.println("\n=== DAFTAR PRESTASI ===");
        if (dataPrestasi.isEmpty()) {
            System.out.println("Belum ada data prestasi.");
        } else {
            for (int i = 0; i < dataPrestasi.size(); i++) {
                String[] prestasi = dataPrestasi.get(i);
                System.out.println((i + 1) + ". Nama: " + prestasi[0] +" | NIM: " + prestasi[1] +" | Jenis: " + prestasi[2] +" | Tingkat: " + prestasi[3] +" | Tahun: " + prestasi[4]);
            }
        }
    }
    static void analisisPrestasi() {
        System.out.println("\n=== ANALISIS PRESTASI ===");
        if (dataPrestasi.isEmpty()) {
            System.out.println("Tidak ada Data Prestasi.");
        } else {
            System.out.print("Masukkan Jenis Prestasi yang ingin dianalisis: ");
            String jenisPrestasi = sc.nextLine();
            boolean ditemukan = false;
    
            System.out.println("\n=== HASIL ANALISIS PRESTASI ===");
            for (String[] prestasi : dataPrestasi) {
                if (prestasi[2].equalsIgnoreCase(jenisPrestasi)) { 
                    ditemukan = true;
                    System.out.println("Nama: " + prestasi[0] +" | NIM: " + prestasi[1] +" | Tingkat: " + prestasi[3] +" | Tahun: " + prestasi[4]);
                }
            }
            if (!ditemukan) {
                System.out.println("Tidak ada data dengan jenis prestasi: " + jenisPrestasi);
            }
        }
    }
    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            System.out.print("Pilih Menu: ");
            int menu = sc.nextInt();
            sc.nextLine(); 

            switch (menu) {
                case 1:
                    tambahDataPrestasi();
                    break;
                case 2:
                    tampilkanSemuaPrestasi();
                    break;
                case 3:
                    analisisPrestasi();
                    break;
                case 4:
                    System.out.println("Keluar dari program. Terima kasih!");
                    System.exit(0);
                default:
                    System.out.println("Masukkan Menu dengan Benar.");
            }
        }
    }
}