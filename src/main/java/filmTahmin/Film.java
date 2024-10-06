package filmTahmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Film
{

/*
// static List<String> filmler = new ArrayList<>(Arrays.asList("JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"));
 TASK :
  yukarıdaki film listinde bulunan filmlerden herhangi birisini kullanıcının film ismini  görmeden
  filmin index nosuna göre sectiriniz
  seçilen filmin  ismini filmin harf saysının 2 katı kadar hak tanıyarak tahmin etmesini
  sağlayan method create ediniz...
  Ahanda TRICK...
  kullanıcının sectiği filmin harf sayısını  console yazdırınız.
  kullanıcının sectiği film için tahmin hakkını  console yazdırınız.
  kullanıcının her tahmininde kalan hak sayısını console yazdırınız.
  kullanıcının her tahmininde doğru ve yanlış tahmin  sayısını console yazdırınız.
  kullanıcının kaybedip veya kazandığını ve tahmin etmesi gereken filmin ismini  console yazdırınız.

 */

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> filmler = new ArrayList<>(Arrays.asList("JOKER", "INCEPTION", "PIYANIST", "GREENMILE", "LEON", "GODFATHER", "JURASSICPARK", "TITANIC"));

        while (true) {
            System.out.println("1-8 arasında bir film numarası giriniz.");
            int filmNo = scan.nextInt();
            scan.nextLine();
            if (filmNo < 1 || filmNo > 8) {
                System.out.println("Hatalı giriş yaptınız. Tekrar deneyiniz.");
            } else {


                String filmAdı = filmler.get(filmNo - 1);
                int harfSAyisi = filmler.get(filmNo - 1).length();
                int tahminHakki = harfSAyisi * 2;
                int kalanHak = tahminHakki;
                int deneme = 0;


                System.out.println("Seçtiğiniz film " + harfSAyisi + " harflidir." +
                        "\nFilm adını doğru tahmin edebilmek için " + tahminHakki + " hakkınız vardır." +
                        "\nTahmininizi yapınız");


                for (int i = 0; i < tahminHakki; i++) {
                    for (int j = 0; j < harfSAyisi; j++) {
                        System.out.print("_ ");
                    }
                    System.out.println();

                    String tahmin = scan.nextLine();
                    if (tahmin.toUpperCase().equals(filmAdı)) {
                        System.out.println((deneme + 1) + ".denemenizde doğru tahminde bulundunuz.");
                        break;
                    } else {
                        kalanHak--;
                        if (kalanHak == 0) {
                            System.out.println(tahminHakki + " hakkınızı kullandınız.\nDoğru tahmin " + filmAdı + " olmalıydı.");
                            break;
                        }
                    }
                    deneme++;
                    System.out.println(deneme + " deneme yaptınız tahmininiz yanlış.\n" + kalanHak + " hakkınız kalmıştır. Tekrar deneyiniz.");

                }


                break;
            }

        }

    }
}
