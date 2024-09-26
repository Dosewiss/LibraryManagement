import java.io.Serializable;

public class Kitap implements Serializable
{
    String isim;
    String yazar;
    String yayinlanmaYili;
    String kategori;

    Kitap(String isim, String yazar, String yayinlanmaYili, String kategori)
    {
        this.isim = isim;
        this.yazar = yazar;
        this.yayinlanmaYili = yayinlanmaYili;
        this.kategori = kategori;
    }
}