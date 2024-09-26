import java.io.Serializable;

public class Personel extends Uye
{
    static int personelSayi = 1;
    String sicilNo;

    Personel(String isim, String soyisim)
    {
        super(isim, soyisim);
        sicilNo = (personelSayi * 20) + "" + personelSayi + "";
        personelSayi++;
    }
}
