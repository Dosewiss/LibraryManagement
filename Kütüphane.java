import java.io.Serializable;
import java.util.*;

public class Kütüphane implements Serializable
{

    String isim;
    private ArrayList<Kitap> kitaplar;
    private ArrayList<Ogrenci> ogrenciler;
    private ArrayList<Personel> personeller;
    private boolean dongu = true;

    Kütüphane(String isim)
    {
        this.isim = isim;
        kitaplar = new ArrayList<>();
        ogrenciler = new ArrayList<>();
        personeller = new ArrayList<>();
    }

    public void kutuphaneArayuz(Scanner sc)
    {
        System.out.println("----" + isim + " Kütüphanesi----");
        System.out.println("1-) Kitap Ekle");
        System.out.println("2-) Kitapları Göster");
        System.out.println("3-) Kitap Sil");
        System.out.println("4-) Üye Ekle");
        System.out.println("5-) Üyeleri Göster");
        System.out.println("6-) Üye Sil");
        System.out.println("7-) Çıkış");

        System.out.print("İşlem seçiniz: ");
        String islem = sc.nextLine();

        switch (islem) 
        {
            case "1":
                kitapEkle(sc);        
                break;
            case "2":
                kitaplariGoster();
                break;
            case "3":
                kitapSil(sc);
                break;
            case "4":
                uyeEkle(sc);
                break;
            case "5":
                uyeleriYazdir();
                break;
            case "6":
                uyeSil(sc);
                break;
            case "7":
                System.out.println(isim + " Kütüphanesinden Çıkılıyor...");
                dongu = false;
                break;
            default:
                break;
        }
    }

    public void kutuphaneDongu(Scanner sc)
    {
        while (dongu) 
        {
            System.out.println();
            kutuphaneArayuz(sc);   
            System.out.println(); 
        }
        dongu = true;
    }

    public void kitapEkle(Scanner sc)
    {
        System.out.print("Kitap Adı: ");
        String ad = sc.nextLine();
        System.out.print("Yazar Adı: ");
        String yazar = sc.nextLine();
        System.out.print("Yayınlanma Yılı: ");
        String yy = sc.nextLine();
        System.out.print("Kategori: ");
        String kategori = sc.nextLine();
        kitaplar.add(new Kitap(ad, yazar, yy, kategori));
        System.out.println(ad + " başarıyla " + isim + " Kütüphanesine eklendi!");
    }

    public void kitaplariGoster()
    {
        int counter = 1;

        System.out.println("----Mevcut Kitaplar----");
        for(Kitap k : kitaplar)
        {
            System.out.println(counter++ + "-) " + k.isim);
        }
    }

    public void kitapSil(Scanner sc)
    {
        System.out.println();
        if(kitaplar.size() > 0)
        {
            kitaplariGoster();
            System.out.print("Silmek istediğiniz kitabın numarasını giriniz: ");
            int numara = sc.nextInt();
            while (numara > kitaplar.size() || numara < 1) 
            {
                System.out.print("Lütfen geçerli kitap numarası giriniz! : ");    
                numara = sc.nextInt();
            }

            System.out.println(kitaplar.get(numara-1).isim + " adlı kitap başarıyla silinmiştir!");
            kitaplar.remove(numara-1);
            sc.nextLine();
        }

        else
        {
            System.out.println("Silinecek kitap bulunmamaktadır menüye yönlendiriliyorsunuz...");
        }
        System.out.println();
    }

    public void uyeEkle(Scanner sc)
    {
        System.out.println();
        System.out.println("1-) Personel Ekle");
        System.out.println("2-) Ogrenci Ekle");
        System.out.print("İşlem seçiniz: ");
        String islem = sc.nextLine();
        
        while (!islem.equals("1") && !islem.equals("2")) 
        {
            System.out.print("Geçerli işlem giriniz! : ");    
            islem = sc.nextLine();
        }
        
        switch (islem) 
        {
            case "1":
                personelEkle(sc);
                break;
            case "2":
                ogrenciEkle(sc);
                break;
        }
    }

    public void personelEkle(Scanner sc)
    {
        System.out.print("Personelin adını giriniz: ");
        String ad = sc.nextLine();
        System.out.print("Personelin soyadını giriniz: ");
        String soyad = sc.nextLine();
        personeller.add(new Personel(ad, soyad));
        System.out.println(ad + " " + soyad + " başarıyla " + isim + " kütüphanesine kayıt olmuştur!");
    }

    public void ogrenciEkle(Scanner sc)
    {
        System.out.print("Öğrencinin adını giriniz: ");
        String ad = sc.nextLine();
        System.out.print("Öğrencinin soyadını giriniz: ");
        String soyad = sc.nextLine();
        ogrenciler.add(new Ogrenci(ad, soyad));
        System.out.println(ad + " " + soyad + " başarıyla " + isim + " kütüphanesine kayıt olmuştur!");
    }

    public void uyeleriYazdir()
    {
        System.out.println();
        int perCount = 1;
        System.out.println("----Mevcut Personeller----");
        for(Personel p : personeller)
        {
            System.out.println(perCount++ + "-) " + p.isim + " " + p.soyisim);
        }

        int ogrCount = 1;
        System.out.println();
        System.out.println("----Mevcut Öğrenciler----");
        for(Ogrenci o : ogrenciler)
        {
            System.out.println(ogrCount++ + "-) " + o.isim + " " + o.soyisim);
        }
    }

    public void uyeSil(Scanner sc)
    {
        System.out.println();
        System.out.println("1-) Personel Sil");
        System.out.println("2-) Öğrenci Sil");
        System.out.print("İşlem seçiniz: ");
        String islem = sc.nextLine();
        
        while (!islem.equals("1") && !islem.equals("2")) 
        {
            System.out.print("Geçerli işlem giriniz! : ");    
            islem = sc.nextLine();
        }

        switch (islem) 
        {
            case "1":
                personelSil(sc);
                break;
            case "2":
                ogrenciSil(sc);
                break;
        }
    }

    public void personelSil(Scanner sc)
    {
        if(personeller.size() > 0)
        {
            System.out.println();
            int perCount = 1;
            System.out.println("----Mevcut Personeller----");
            for(Personel p : personeller)
            {
                System.out.println(perCount++ + "-) " + p.isim + " " + p.soyisim);
            }

            System.out.print("Silmek istediğiniz personelin numarasını giriniz: ");
            int numara = sc.nextInt();
            while (numara > personeller.size() || numara < 1) 
            {
                System.out.print("Lütfen geçerli personel numarası giriniz! : ");    
                numara = sc.nextInt();
            }

            System.out.println(personeller.get(numara-1).isim + " adlı personel başarıyla silinmiştir!");
            personeller.remove(numara-1);
            sc.nextLine();
        }

        else System.out.println("Silinecek personel bulunmamaktadır");
    }

    public void ogrenciSil(Scanner sc)
    {
        if(ogrenciler.size() > 0)
        {
            System.out.println();
            int perCount = 1;
            System.out.println("----Mevcut Öğrenciler----");
            for(Ogrenci o : ogrenciler)
            {
                System.out.println(perCount++ + "-) " + o.isim + " " + o.soyisim);
            }

            System.out.print("Silmek istediğiniz öğrencinin numarasını giriniz: ");
            int numara = sc.nextInt();
            while (numara > ogrenciler.size() || numara < 1) 
            {
                System.out.print("Lütfen geçerli öğrenci numarası giriniz! : ");    
                numara = sc.nextInt();
            }

            System.out.println(ogrenciler.get(numara-1).isim + " adlı öğrenci başarıyla silinmiştir!");
            ogrenciler.remove(numara-1);
            sc.nextLine();
        }

        else System.out.println("Silinecek öğrenci bulunmamaktadır");
    }
}