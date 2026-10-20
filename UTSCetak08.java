import java.util.Scanner;

public class UTSCetak08 {
    public static void main(String[] args) {
         int P = 1; 

        Scanner sc = new Scanner(System.in);

        System.out.print("Masukkan kode kertas (1-3) : ");
        int kode = sc.nextInt();

        System.out.print("Cetak warna (true/false)   : ");
        boolean warna = sc.nextBoolean();

        System.out.print("Jumlah lembar               : ");
        int lembar = sc.nextInt();

        System.out.println("----------------------------------------");


        String kertas = "";
        int hargaHitam = 0;
        int hargaWarna = 0;

        switch (kode) {
            case 1:
                kertas = "A4";
                hargaHitam = 300;
                hargaWarna = 1000;
                break;
            case 2:
                kertas = "F4";
                hargaHitam = 350;
                hargaWarna = 1200;
                break;
            case 3:
                kertas = "A3";
                hargaHitam = 800;
                hargaWarna = 2500;
                break;
            default:
                System.out.println("pesan kode kertas tidak tersedia.");
                sc.close();
                return;
        }


        if (lembar < 1 || lembar > 1000) {
            System.out.println("Jumlah lembar tidak valid.");
            sc.close();
            return;
        }

    
        int hargaDasar = warna ? hargaWarna : hargaHitam;
        int hargaPerLembar = hargaDasar + (P * 10);


        double subtotal = (double) lembar * hargaPerLembar;
        double diskonPersen = 0.0;

        if (lembar >= 500) {
            diskonPersen = 0.15;
        } else if (lembar >= 100) {
            diskonPersen = 0.10;
        } else {
            diskonPersen = 0.0;
        }

        double nominalDiskon = subtotal * diskonPersen;
        double totalBayar = subtotal - nominalDiskon;

    
        if (totalBayar < 5000) {
            totalBayar = 5000;
        }

        System.out.printf("Kertas          : %s\n", kertas);
        System.out.printf("Jenis cetak     : %s\n", (warna ? "Warna" : "Hitam-putih"));
        System.out.printf("Harga per lembar: Rp%,d\n", hargaPerLembar);
        System.out.printf("Subtotal        : Rp%,.0f\n", subtotal);
        System.out.printf("Diskon (%.0f%%)   : Rp%,.0f\n", (diskonPersen * 100), nominalDiskon);
        System.out.printf("Total bayar     : Rp%,.0f\n", totalBayar);

        sc.close();
    }
}