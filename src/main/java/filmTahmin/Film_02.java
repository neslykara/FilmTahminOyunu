package filmTahmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Film_02
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

                String orjFilm = filmler.get(filmNo - 1);
                String tahminFilm;
                String tahminArrFilm;
                int harfSAyisi = filmler.get(filmNo - 1).length();
                int tahminHakki = harfSAyisi * 2;
                int kalanHak = tahminHakki;
                int deneme = 0;



                System.out.println("Seçtiğiniz film " + harfSAyisi + " harflidir." +
                        "\nFilm adını doğru tahmin edebilmek için " + tahminHakki + " hakkınız vardır." +
                        "\nTahmininizi yapınız");

                for (int i = 0; i <tahminHakki ; i++)
                {
                    deneme++;
                    kalanHak--;
                    tahminFilm = scan.nextLine();
                    tahminFilm.toUpperCase();
                    if (tahminFilm.length()<harfSAyisi || tahminFilm.length()>harfSAyisi)
                    {
                        System.out.println("YANLIS! "+harfSAyisi+" harfli bir tahminde bulunmalısınız.\n"+kalanHak+" tahmin hakkınız kaldı.");
                    } else if (tahminFilm.equals(orjFilm))
                    {
                        System.out.println(orjFilm +" tahmini dogru "+ deneme+".denemenizde doğru tahminde bulundunuz.\nTEBRİKLER.");
                        break;
                    }else {

                        char[] tahminArr = new char[harfSAyisi];

                        for (int j = 0; j < harfSAyisi; j++) {
                            if (orjFilm.charAt(j) == tahminFilm.charAt(j)) {
                                tahminArr[j] = tahminFilm.charAt(j);
                            } else {
                                tahminArr[j] = '_';
                            }
                        }//Tahmin edilen filmin harflerini array 'a ekledim

                        tahminArrFilm = new String(tahminArr); //Array'ı tekrar string'e dönüştürdüm.
                        System.out.println(tahminArrFilm);
                        int dogruHarfSayisi = tahminArrFilm.replaceAll("\\p{Punct}","").length();
                        if(dogruHarfSayisi==0){
                            System.out.println("Dogru tahmin icin "+kalanHak+" hakkınız kaldi. Tekrar deneyiniz.");
                        }else {
                            System.out.println(dogruHarfSayisi+" harfi buldunuz.\nDogru tahmin icin "+kalanHak+" hakkınız kaldi.\nTekrar deneyiniz.");
                        }

                    }
                }
                break;
            }

        }

    }
}
