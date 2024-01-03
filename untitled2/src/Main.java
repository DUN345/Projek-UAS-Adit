import java.util.ArrayList;
import java.util.Scanner;

class Kendaraan {
    String nomorPlat;
    String merk;
    int tahunPembuatan;

    public Kendaraan(String nomorPlat, String merk, int tahunPembuatan) {
        this.nomorPlat = nomorPlat;
        this.merk = merk;
        this.tahunPembuatan = tahunPembuatan;
    }

    public String getInfo() {
        return merk + " " + tahunPembuatan + " - Plat Nomor: " + nomorPlat;
    }
}

class Servis {
    Kendaraan kendaraan;
    String jenisServis;
    double biaya;

    public Servis(Kendaraan kendaraan, String jenisServis, double biaya) {
        this.kendaraan = kendaraan;
        this.jenisServis = jenisServis;
        this.biaya = biaya;
    }

    public String getInfoServis() {
        return "Servis " + kendaraan.merk + " (" + kendaraan.nomorPlat + "): " +
                jenisServis + " - Biaya: $" + biaya;
    }
}

class Bengkel {
    String nama;
    ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    ArrayList<Servis> daftarServis = new ArrayList<>();

    public Bengkel(String nama) {
        this.nama = nama;
    }

    public void tambahKendaraan(Kendaraan kendaraan) {
        daftarKendaraan.add(kendaraan);
    }

    public Servis lakukanServis(Kendaraan kendaraan, String jenisServis, double biaya) {
        Servis servis = new Servis(kendaraan, jenisServis, biaya);
        daftarServis.add(servis);
        return servis;
    }

    public void tampilkanSemuaKendaraan() {
        System.out.println("Daftar Kendaraan:");
        for (Kendaraan kendaraan : daftarKendaraan) {
            System.out.println(kendaraan.getInfo());
        }
    }

    public void tampilkanSemuaServis() {
        System.out.println("\nDaftar Servis:");
        for (Servis servis : daftarServis) {
            System.out.println(servis.getInfoServis());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama bengkel: ");
        String namaBengkel = scanner.nextLine();

        Bengkel bengkel = new Bengkel(namaBengkel);

        // Input kendaraan
        System.out.println("\nInput Kendaraan ");
        for (int i = 1; i <= 2; i++) {
            System.out.println("Data Kendaraan ke-" + i);
            System.out.print("Nomor Plat: ");
            String nomorPlat = scanner.nextLine();
            System.out.print("Merk: ");
            String merk = scanner.nextLine();
            System.out.print("Tahun Pembuatan: ");
            int tahunPembuatan = scanner.nextInt();
            scanner.nextLine();

            Kendaraan kendaraan = new Kendaraan(nomorPlat, merk, tahunPembuatan);
            bengkel.tambahKendaraan(kendaraan);
        }

        // Input servis
        System.out.println("\n Input Servis ");
        for (int i = 1; i <= 2; i++) {
            System.out.println("Data Servis ke-" + i);
            bengkel.tampilkanSemuaKendaraan(); // menampilkan daftar kendaraan untuk referensi
            System.out.print("Pilih nomor kendaraan untuk servis: ");
            int nomorKendaraan = scanner.nextInt();
            scanner.nextLine(); // membersihkan buffer
            Kendaraan kendaraanServis = bengkel.daftarKendaraan.get(nomorKendaraan - 1);

            System.out.print("Jenis Servis: ");
            String jenisServis = scanner.nextLine();
            System.out.print("Biaya Servis: $");
            double biayaServis = scanner.nextDouble();
            scanner.nextLine();

            bengkel.lakukanServis(kendaraanServis, jenisServis, biayaServis);
        }

        // Output hasil
        System.out.println("\n### Hasil Akhir ====");
        bengkel.tampilkanSemuaKendaraan();
        bengkel.tampilkanSemuaServis();

        scanner.close();
    }
}
