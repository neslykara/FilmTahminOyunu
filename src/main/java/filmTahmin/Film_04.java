package filmTahmin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Film_04
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

        while (true)
        {
            System.out.println("Listemizde "+filmler.size()+" film adı yer almaktadir.\n" +
                    "1 - "+filmler.size()+" arasında bir numara girerek oyuna başlayabilirsiniz.");
            int filmNo = scan.nextInt();
            scan.nextLine();
            if (filmNo < 1 || filmNo > 8)
            {
                System.out.println("Hatalı giriş yaptınız. Tekrar deneyiniz.");
            }
            else
            {

                String orjFilm = filmler.get(filmNo - 1);
                String tahminFilm; // kullanıcıdan alınan film adi tahmin string'i
                String tahminArrFilmAdi; // tahminde harf kontrolüne göre oluşturulan array'ı atadığımız string
                String harfler;
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
                    int dogruHarf = 0; //tahminde tutturulan harf sayisi
                    tahminFilm = scan.nextLine();
                    tahminFilm=tahminFilm.toUpperCase();

                    if (tahminFilm.equals(orjFilm))  // tahmin edilen film adı doğru ise
                    {
                        System.out.println(orjFilm + " tahmini dogru " + deneme + ".denemenizde doğru tahminde bulundunuz.\nTEBRİKLER.");
                        System.out.println("-----------------------");
                        break;
                    }
                    else  if (kalanHak==0)
                    {
                        System.out.println("Tahmin hakkınız kalmadı.\nDoğru tahmin "+orjFilm+" olacaktı. ");
                        System.out.println("-----------------------");
                        break;
                    }
                    else if (tahminFilm.length() < harfSAyisi || tahminFilm.length() > harfSAyisi) //tahmin edilen film adının harf sayisi farklı ise
                    {
                        System.out.println("YANLIS! " + harfSAyisi + " harfli bir tahminde bulunmalısınız.\n" + kalanHak + " tahmin hakkınız kaldı.");
                    }

                    else //tahmin harf sayisi dogru fakat film adi yanlis ise
                    {
                        char[] tahminArr = new char[harfSAyisi];//Tahmini kontrol etmek için boş bir array oluşturuldu.
                        char[] harfArr = new char[harfSAyisi]; //Doğru tahmin edilen harfleri atamak için olusturulan array

                        for (int j = 0; j < harfSAyisi; j++)  // doğru harf var mı kontrol et
                        {
                            for (int k = 0; k < harfSAyisi; k++) {
                                if (orjFilm.charAt(j) == tahminFilm.charAt(k))
                                {
                                    dogruHarf++; //tahmindeki kaç harf film adında var
                                    harfArr[j] = tahminFilm.charAt(k);
                                    break;
                                }else {
                                    harfArr[j] = ' ';
                                }
                            }
                        }
                        Arrays.sort(harfArr);
                        harfler = new String(harfArr);
                        System.out.println(harfler);

                        for (int j = 0; j < harfSAyisi; j++) //Tahminde doğru yerde harf var mı kontrol et
                        {
                            if (orjFilm.charAt(j) == tahminFilm.charAt(j)) {
                                tahminArr[j] = tahminFilm.charAt(j);
                            } else {
                                tahminArr[j] = '_';
                            }
                        }//Tahmin edilen filmin harfler doğru ise bos array 'a eklendi yanlış ise "_" konuldu.

                        tahminArrFilmAdi = new String(tahminArr); //Array tekrar string'e dönüştürüldü
                        System.out.println(tahminArrFilmAdi);

                        int dogruHarfYeri = tahminArrFilmAdi.replaceAll("\\p{Punct}", "").length(); //tahmindeki kaç harf film adı ile aynı yerde


                        if (dogruHarfYeri == 0 && dogruHarf == 0)
                        {
                            System.out.println("Film adını bulmak icin " + kalanHak + " hakkınız kaldi. Tekrar deneyiniz.");
                        }
                        else if (dogruHarfYeri ==0 && dogruHarf > 0)
                        {
                            System.out.println("Tahmininizdeki "+dogruHarf+" harf film adında yer almakta fakat doğru yerde değil\n"
                                    +"Film adını bulmak icin " + kalanHak + " hakkınız kaldi. Tekrar deneyiniz.");

                        } else if (dogruHarfYeri==dogruHarf)
                        {
                            System.out.println("Tahmininizdeki "+dogruHarf+" harf film adında yer almakta ve doğru yerde.\n" +
                                    "Film adını bulmak icin " + kalanHak + " hakkınız kaldi. Tekrar deneyiniz.");

                        } else
                        {
                            System.out.println("Tahmininizdeki "+dogruHarf+" harf film adında yer alıyor. Fakat "+dogruHarfYeri+" harf doğru yerde.\n" +
                                    "Film adını bulmak icin " + kalanHak + " hakkınız kaldi. Tekrar deneyiniz." );
                        }

                    }
                }
            }

            System.out.println("Tekrar oynamak ister misiniz?\nDevam etmek için 'D' sonlandırmak için 'S' harfini tuşlayınız.");

            boolean sonlandirma =false;

            while (true)
            {
                char devam = scan.next().charAt(0);
                if (devam=='d' || devam=='D')
                {
                    break;
                } else if (devam=='s' || devam=='S')
                {
                    System.out.println("Oyun sonlandırılıyor. Yine bekleriz :) ");
                    sonlandirma=true;
                    break;
                }else
                {
                    System.out.println("Yanlış tuşlama yaptınız. 'D' veya 'S' tuşlayınız. ");
                }
            }
            if (sonlandirma==true)
            {
                break;
            }

        }
    }
}