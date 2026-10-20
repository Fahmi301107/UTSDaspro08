import java.util.Scanner;

public class UTSYudisium08 { 
    public static void main(String[] args) {
         int P = 8; 

        boolean isGanjil = (P % 2 != 0);
        int minSks = isGanjil ? 144 : 108;
        int maxSemester = isGanjil ? 8 : 6;

        Scanner sc = new Scanner(System.in);
        String pesan = "";

    
        System.out.print("Bebas kompen (Ya/Tidak)           : ");
        String kompenInput = sc.nextLine().trim();
        boolean bebasKompen = kompenInput.equalsIgnoreCase("Ya");

        System.out.print("Tanggungan perpustakaan (true/false): ");
        boolean tanggunganPerpus = sc.nextBoolean();

    
        if (!bebasKompen || tanggunganPerpus) {
            pesan = "syarat administrasi (kompen/perpustakaan) belum terpenuhi";
        } else {
        
            System.out.print("Jumlah SKS lulus                   : ");
            int sks = sc.nextInt();

            System.out.print("IPK                               : ");
            double ipk = sc.nextDouble();

        
            if (sks < minSks || ipk < 2.00) {
                pesan = "syarat akademik (SKS/IPK) belum terpenuhi";
            } else {
            
                System.out.print("Lama studi (dalam semester)       : ");
                int semester = sc.nextInt();

                System.out.print("Pernah mengulang mata kuliah (true/false): ");
                boolean mengulang = sc.nextBoolean();

                String predikat = "";

            
                if (ipk > 3.50 && semester <= maxSemester && !mengulang) {
                    predikat = "Dengan Pujian";
                } else if (ipk > 3.00) {
                    predikat = "Sangat Memuaskan";
                } else if (ipk >= 2.76) {
                    predikat = "Memuaskan";
                } else {
                    predikat = "Cukup";
                }

                pesan = "Lulus yudisium dengan predikat " + predikat;
            }
        }

        // Cetak hasil keputusan
        System.out.println("----------------------------------------");
        System.out.println(pesan);

        sc.close();
    }
}