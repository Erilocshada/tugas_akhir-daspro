class DataPrestasi {
    String nama; // Atribut kelas
    String nim;
    String jenisPrestasi;
    String tingkatPrestasi;
    int tahun;

    // Constructor tanpa `this`
    DataPrestasi(String namaMahasiswa, String nimMahasiswa, String jenis, String tingkat, int tahunPrestasi) {
        nama = namaMahasiswa; // Nama parameter berbeda dari nama atribut
        nim = nimMahasiswa;
        jenisPrestasi = jenis;
        tingkatPrestasi = tingkat;
        tahun = tahunPrestasi;
    }

    // Metode untuk menampilkan data prestasi
    String tampilkanPrestasi() {
        return "Nama: " + nama + " | NIM: " + nim + " | Jenis: " + jenisPrestasi +
               " | Tingkat: " + tingkatPrestasi + " | Tahun: " + tahun;
    }
}

public class PencatatanPrestasiMahasiswa {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<DataPrestasi> daftarPrestasi = new ArrayList<>();

    public static void main(String[] args) {
        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membaca newline setelah angka

            switch (pilihan) {
                case 1:
                    tambahPrestasi();
                    break;
                case 2:
                    tampilkanSemuaPrestasi();
                    break;
                case 3:
                    analisisPrestasi();
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
        System.out.println("\n=== PENCATATAN PRESTASI MAHASISWA ===");
        System.out.println("1. Tambah Data Prestasi");
        System.out.println("2. Tampilkan Semua Prestasi");
        System.out.println("3. Analisis Prestasi Berdasarkan Jenis");
        System.out.println("4. Keluar");
    }

    static void tambahPrestasi() {
        System.out.print("Masukkan Nama Mahasiswa: ");
        String namaMahasiswa = scanner.nextLine();

        System.out.print("Masukkan NIM Mahasiswa: ");
        String nimMahasiswa = scanner.nextLine();

        System.out.print("Masukkan Jenis Prestasi (Juara 1 / Juara 2 / Juara 3): ");
        String jenis = scanner.nextLine();

        System.out.print("Masukkan Tingkat Prestasi (Lokal / Nasional / Internasional): ");
        String tingkat = scanner.nextLine();

        int tahunPrestasi;
        do {
            System.out.print("Masukkan Tahun Prestasi (2010 - 2024): ");
            tahunPrestasi = scanner.nextInt();
            scanner.nextLine(); // Membaca newline setelah angka
            if (tahunPrestasi < 2010 || tahunPrestasi > 2024) {
                System.out.println("Tahun tidak valid. Coba lagi.");
            }
        } while (tahunPrestasi < 2010 || tahunPrestasi > 2024);

        // Membuat objek baru dengan parameter yang berbeda
        DataPrestasi prestasiBaru = new DataPrestasi(namaMahasiswa, nimMahasiswa, jenis, tingkat, tahunPrestasi);
        daftarPrestasi.add(prestasiBaru);
        System.out.println("Data prestasi berhasil ditambahkan.");
    }

    static void tampilkanSemuaPrestasi() {
        if (daftarPrestasi.isEmpty()) {
            System.out.println("Belum ada data prestasi.");
        } else {
            System.out.println("\n=== DAFTAR SEMUA PRESTASI ===");
            for (DataPrestasi prestasi : daftarPrestasi) {
                System.out.println(prestasi.tampilkanPrestasi());
            }
        }
    }

    static void analisisPrestasi() {
        if (daftarPrestasi.isEmpty()) {
            System.out.println("Belum ada data prestasi untuk dianalisis.");
        } else {
            int juara1 = 0, juara2 = 0, juara3 = 0;

            for (DataPrestasi prestasi : daftarPrestasi) {
                if (prestasi.jenisPrestasi.equalsIgnoreCase("Juara 1")) {
                    juara1++;
                } else if (prestasi.jenisPrestasi.equalsIgnoreCase("Juara 2")) {
                    juara2++;
                } else if (prestasi.jenisPrestasi.equalsIgnoreCase("Juara 3")) {
                    juara3++;
                }
            }

            System.out.println("\n=== ANALISIS PRESTASI BERDASARKAN JENIS ===");
            System.out.println("Juara 1: " + juara1);
            System.out.println("Juara 2: " + juara2);
            System.out.println("Juara 3: " + juara3);
        }
    }
}
