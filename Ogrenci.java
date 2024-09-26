import java.io.Serializable;

public class Ogrenci extends Uye
{
    static int ogrenciSayi = 1;
    String ogrenciNo;

    Ogrenci(String isim, String soyisim)
    {
        super(isim, soyisim);
        ogrenciNo = ogrenciSayi + "" + (ogrenciSayi*10);
        ogrenciSayi++;
    }
}
