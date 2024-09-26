import java.util.*;
import java.io.*;

public class Main 
{
    public static ArrayList<Kütüphane> kütüphaneler = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);
    static boolean dongu = true;

    public static void sistemArayuz()
    {
        System.out.println("----Kütüphane Yönetim Sistemi----");
        System.out.println("1-) Kütüphane Ekle");
        System.out.println("2-) Kütüphaneleri Göster");
        System.out.println("3-) Kütüphane Sil");
        System.out.println("4-) Çıkış");

        System.out.print("İşlem seçiniz: ");
        String islem = sc.nextLine();

        switch (islem) 
        {
            case "1":
                kutuphaneEkle();
                break;
            case "2":
                kutuphaneYazdir();
                break;
            case "3":
                kutuphaneSil();
                break;            
            case "4":
                System.out.println("Çıkış yapılıyor...");
                dongu = false;
                break;
            default:
                System.out.println("Geçerli işlem seçiniz!");
                break;
        }
    }

    public static void yazdirKutuphaneler()
    {
        if(kütüphaneler.size() > 0)
        {
            System.out.println();
            System.out.println("----Mevcut Kütüphaneler----");
            int counter = 1;
            for(Kütüphane k : kütüphaneler)
            {
                System.out.println(counter++ + "-) " + k.isim + " Kütüphanesi");
            }

            System.out.println();
        }
    }

    public static void kutuphaneYazdir()
    {
        if(kütüphaneler.size() > 0)
        {
            System.out.println();
            System.out.println("----Mevcut Kütüphaneler----");
            int counter = 1;
            for(Kütüphane k : kütüphaneler)
            {
                System.out.println(counter++ + "-) " + k.isim + " Kütüphanesi");
            }

            System.out.println();

            System.out.print("Üzerinde işlem yapmak istediğiniz kütüphanenin numarasını girin eğer istemiyorsanız 0'a basın: ");
            int islem = sc.nextInt();
            
            while (islem < 0 || islem > kütüphaneler.size()) 
            {
                System.out.print("Geçerli işlem seçiniz! : ");
                islem = sc.nextInt();    
            }

            switch (islem) 
            {
                case 0:
                    sc.nextLine();
                    break;
                default:
                    sc.nextLine();
                    kütüphaneler.get(islem-1).kutuphaneDongu(sc);
                    break;
            }
        }
        
        else System.out.println("Mevcut Kütüphane bulunmamaktadır!");
    }

    public static void kutuphaneEkle()
    {
        System.out.println();
        System.out.print("Eklemek istediğiniz kütüphanenin adını giriniz: ");
        String isim = sc.nextLine();
        kütüphaneler.add(new Kütüphane(isim));
        System.out.println(isim + " Kütüphanesi Başarıyla eklendi!");
        System.out.println();
    }

    public static void kutuphaneSil()
    {
        System.out.println();
        if(kütüphaneler.size() > 0)
        {
            yazdirKutuphaneler();
            System.out.print("Silmek istediğiniz kütüphanenin numarasını giriniz: ");
            int numara = sc.nextInt();
            while (numara > kütüphaneler.size() || numara < 1) 
            {
                System.out.print("Lütfen geçerli kütüphane numarası giriniz! : ");    
                numara = sc.nextInt();
            }

            System.out.println(kütüphaneler.get(numara-1).isim + " Kütüphanesi başarıyla silinmiştir!");
            kütüphaneler.remove(numara-1);
            sc.nextLine();
        }

        else
        {
            System.out.println("Silinecek kütüphane bulunmamaktadır menüye yönlendiriliyorsunuz...");
        }
        System.out.println();
    }

    public static void arrayCek() throws IOException, ClassNotFoundException
    {
        File file = new File("k.txt");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        kütüphaneler = (ArrayList<Kütüphane>) ois.readObject();
        ois.close();
    }

    public static void arrayYazdir() throws IOException
    {
        File file = new File("k.txt");
        FileOutputStream fis = new FileOutputStream(file);
        ObjectOutputStream ois = new ObjectOutputStream(fis);
        ois.writeObject(kütüphaneler);
        ois.close();
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException 
    {
        arrayCek();
        if(kütüphaneler == null) kütüphaneler = new ArrayList<>();
        while(dongu)
        {
            System.out.println();
            sistemArayuz();
            System.out.println();
        }
        arrayYazdir();
    }    
}