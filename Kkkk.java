import java.io.*;

public class Kkkk 
{
    public static void main(String[] args) throws IOException
    {
        File o = new File("k.txt");
        FileOutputStream fos = new FileOutputStream(o);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(null);
        oos.close();
    }
}