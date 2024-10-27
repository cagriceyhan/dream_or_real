import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    static String isim;
    static Scanner input = new Scanner(System.in);
    static String evetHayir;
    static String hayal;
    static ArrayList<String> hayallerListesi = new ArrayList<>();
    static int secim;
    static String merak;
    static String evetHayirKucuk;
    static String merakKucuk;


    public static void isimOgrenme() {
        System.out.print("Lütfen adınızı giriniz: ");
        isim = input.nextLine();
    }

    public static void isimDogrulama() {
        System.out.print("İsminizden (" + isim + ") emin misiniz? (evet/hayır): ");
        evetHayir = input.nextLine();
        evetHayirKucuk = evetHayir.toLowerCase();

        if (evetHayirKucuk.equals("hayır")) {
            isimOgrenme();
            isimDogrulama();
        } else if (evetHayirKucuk.equals("evet")) {

        } else {
            System.out.println("Lütfen EVET veya HAYIR yazınız! ");
            isimDogrulama();
        }
    }

    public static void hayaller() {
        System.out.println("\nSenden hayatta en çok isteyebileceğin 3 hayali girmeni istiyorum!");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + ".hayal: ");
            hayal = input.nextLine();
            hayallerListesi.add(hayal);
        }
    }

    public static void hayalSectirmek() {
        System.out.println("\nSizin için seçtiğiniz hayalleri karıştırdık ve senden karışan hayallerden birini seçmeni istiyorum!");
        Collections.shuffle(hayallerListesi);
        for (int j = 0; j < 3; j++) {
            System.out.println((j + 1) + ".hayal: ***");
        }
        System.out.print("\nLütfen hayallerin arasından birini seç! (Rakam kullanınız. 1,2,3..): ");
        secim = input.nextInt();
        input.nextLine();

        switch (secim) {
            case 1:
                System.out.println("Seçtiğin hayal: " + hayallerListesi.get(0));
                break;
            case 2:
                System.out.println("Seçtiğin hayal: " + hayallerListesi.get(1));
                break;
            case 3:
                System.out.println("Seçtiğin hayal: " + hayallerListesi.get(2));
                break;
            default:
                System.out.println("\n! ! ! Geçersiz seçim! Bu yüzden tekrar karıştırıp soracağım ! ! !");
                hayalSectirmek();
                return;
        }
    }

    public static void merakEdiyormusun() {
        System.out.println("\nHayalinin gerçekleşip gerçekleşmeyeceğini merak ettiğin için burada olduğunu düşünüyorum!");
    }

    public static void merakEdiyormusun2() {
        System.out.print("Gerçekten merak ediyor musun? (evet/hayır): ");
    }

    public static void merakEdiyormusun3() {
        merak = input.nextLine().trim();
        merakKucuk = merak.toLowerCase();

        if (merakKucuk.equals("hayır")) {
            System.out.println("\nBoşa mı yazdım ben bunca kodu!");
            merakEdiyormusun2();
            merakEdiyormusun3();
        } else if (merakKucuk.equals("evet")) {
            gerceklesmeTesti();
        } else {
            System.out.println("\nMerak ettiğine dair şüphelerim var!");
            merakEdiyormusun2();
            merakEdiyormusun3();
        }

    }

    public static void gerceklesmeTesti() {
        System.out.println("\nHayalinin gerçekleşip gerçekleşmeyeceğini ölçmek için seni bir teste sokacağım!\nBu testte 3 adet soru olacak ve puanına göre sonucun değişecek.\n");
        int toplamPuan = 0;
        while (true) {
            System.out.println("Soru 1: İnsanlara neden iyilik yapmalıyız?\nA-) Ben zor durumda olursam bana da yardım edilmesini istediğim için\nB-) İyilik yaptığımda iyi hissettiğim için.\nC-) Zor durumda olan bir insanı mutlu etmekten daha güzel ne var ki?");
            System.out.print("Cevap: ");
            String cevap1 = input.nextLine();
            String cevap1Kucuk = cevap1.toLowerCase();
            if (cevap1Kucuk.equals("a")) {
                toplamPuan += 1;
                break;
            } else if (cevap1Kucuk.equals("b")) {
                toplamPuan += 2;
                break;
            } else if (cevap1Kucuk.equals("c")) {
                toplamPuan += 4;
                break;
            } else {
                System.out.println("\nLütfen 'a', 'b' veya 'c' şıklarından biriniz giriniz!\n");
            }
        }

        while (true) {
            System.out.println("\nSoru 2: Kötülük yapana iyilik yapılmalı mıdır?\nA-) Asla yapılmamalıdır.\nB-) Çok zor durumdaysa belki bir ihtimal.\nC-) Kötülüğe iyilikle cevap verince karşı tarafı da iyi birisi yapabileceğime inanırım");
            System.out.print("Cevap: ");
            String cevap2 = input.nextLine();
            String cevap2Kucuk = cevap2.toLowerCase();
            if (cevap2Kucuk.equals("a")) {
                toplamPuan -= 1;
                break;
            } else if (cevap2Kucuk.equals("b")) {
                toplamPuan += 2;
                break;
            } else if (cevap2Kucuk.equals("c")) {
                toplamPuan += 5;
                break;
            } else {
                System.out.println("\nLütfen 'a', 'b' veya 'c' şıklarından biriniz giriniz!\n");
            }
        }

        while (true) {
            System.out.println("\nSoru 3: Bir tren ve yol ayrımı var. Ayrımın birinde 5 adet çocuk diğerinde ise kansere çözüm bulan bilim adamı var. Trenin hangi ayrımdan gitmesini sağlarsın?\nA-) Bilim adamının ayrımından gitmesini sağlarım.\nB-) Çocukların olduğu ayrımdan gitmesini sağlarım.\nC-) Bu soruya cevap veremeyecek kadar ponçik kalpli bir insanım <3.");
            System.out.print("Cevap: ");
            String cevap3 = input.nextLine();
            String cevap3Kucuk = cevap3.toLowerCase();
            if (cevap3Kucuk.equals("a")) {
                toplamPuan += 2;
                break;
            } else if (cevap3Kucuk.equals("b")) {
                toplamPuan += 2;
                break;
            } else if (cevap3Kucuk.equals("c")) {
                toplamPuan -= 2;
                break;
            } else {
                System.out.println("\nLütfen 'a', 'b' veya 'c' şıklarından biriniz giriniz!\n");
            }

        }
        System.out.println("\nToplam puanınız: " + toplamPuan + "\n");

        if (toplamPuan < 5) {
            System.out.println("Sadece kötüsün! Hayalin gerçekleşecek gibi durmuyor.");
        } else if (toplamPuan >= 5 && (toplamPuan < 9)) {
            System.out.println("İyi gibisin. Biraz daha çabala, umarım gerçekleşir.");
        } else {
            System.out.println("Cevapları samimi verdiysen gerçekten 3 dileğinin de kabul olmasını hak ediyorsun. Tebrikler!");
        }
    }

    public static void main(String[] args) {
        isimOgrenme();
        isimDogrulama();
        hayaller();
        hayalSectirmek();
        merakEdiyormusun();
        merakEdiyormusun2();
        merakEdiyormusun3();
    }
}
















