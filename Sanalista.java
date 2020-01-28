import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sanalista {

    private List<String> sanat;
    private String luku, tiedosto;
    private int pituus;

    public Sanalista (String tiedosto) {
        this.tiedosto = tiedosto;
        try (BufferedReader file = new BufferedReader(new FileReader(tiedosto))) {
            // tallenna sanat tiedostosta List rakenteeseen
            // sanat tiedostossa 1 per rivi

            sanat = new ArrayList<String>();

            while ((luku = file.readLine()) != null) {
                luku = luku.toLowerCase();
                sanat.add(luku);
                // System.out.println("Talletettiin " +luku);
            }

        }catch(IOException ioe) {
            System.out.println("Virhe tiedoston käsittelyssä");
        }

    }

    public Sanalista (int pituus) {
        this.pituus = pituus;
        sanat = new ArrayList<String>();
        try (BufferedReader file = new BufferedReader(new FileReader(tiedosto))) {
            // tallenna sanat tiedostosta List rakenteeseen
            // sanat tiedostossa 1 per rivi

            sanat = new ArrayList<String>();

            while ((luku = file.readLine()) != null) {
                if(luku.length() == pituus) {
                    luku = luku.toLowerCase();
                    sanat.add(luku);
                }
            }

        }catch(IOException ioe) {
            System.out.println("Virhe tiedoston käsittelyssä");
        }

    }

    public void tulostaSanat() {

        Iterator<String> iter = sanat.iterator();

        while( iter.hasNext()){
            System.out.println(iter.next());

        }
    }

    public List<String> annaSanat() {
        return sanat;
    }

    public Sanalista sanatJoidenPituusOn(int pituus) {
        Sanalista s1;

        s1 = new Sanalista(pituus);

        return s1;
    }


    public int getPituus() {
        return pituus;
    }

    public void setPituus(int pituus) {
        this.pituus = pituus;
    }

    public String getTiedosto() {
        return tiedosto;
    }

    public void setTiedosto(String tiedosto) {
        this.tiedosto = tiedosto;
    }

    public String getLuku() {
        return luku;
    }

    public void setLuku(String luku) {
        this.luku = luku;
    }

    public List<String> getSanat() {
        return sanat;
    }

    public void setSanat(List<String> sanat) {
        this.sanat = sanat;
    }

    public String toString() {
        return ("Pelin sanat ovat "+ sanat);
    }
}
