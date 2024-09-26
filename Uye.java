import java.io.Serializable;

public abstract class Uye implements Serializable
{
    String isim;
    String soyisim;

    Uye(String isim, String soyisim)
    {
        this.isim = isim;
        this.soyisim = soyisim;
    }
}
