import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hirsipuu {

    private Sanalista sanat; //Sanalistaolio
    private int arvauksetMaara; //kuinka monta arvausta jäljellä
    private List<Character> arvatut; //mitä merkkejä on jo arvattu
    private String valittu; //mitä sanaa yritetään arvata
    private int paikka; //arvonnassa käytettävä indeksi
    private int max; //sanalistan koko

    public Hirsipuu (Sanalista sanat, int arvaukset) {
        this.sanat = sanat;
        this.arvauksetMaara = arvaukset;
        arvatut = new ArrayList<Character>();

        //arvotaan käytettävä sana
        Random arvonta = new Random();
        max = sanat.annaSanat().size();
        paikka = arvonta.nextInt(max);
        valittu = sanat.annaSanat().get(paikka);

        // System.out.println("Valittiin " +valittu);



    }

    public int getArvauksetMaara() {
        return arvauksetMaara;
    }

    public void setArvauksetMaara(int arvauksetMaara) {
        this.arvauksetMaara = arvauksetMaara;
    }

    public void setSanat(Sanalista sanat) {
        this.sanat = sanat;
    }

    public Sanalista getSanat() {
        return sanat;
    }

    public String getValittu() {
        return valittu;
    }

    public void setValittu(String valittu) {
        this.valittu = valittu;
    }

    public List<Character> getArvatut() {
        return arvatut;
    }

    public void setArvatut(List<Character> arvatut) {
        this.arvatut = arvatut;
    }

    public int getMax() {
        return max;
    }

    public int getPaikka() {
        return paikka;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void setPaikka(int paikka) {
        this.paikka = paikka;
    }

    public boolean arvaa(Character merkki) {
        boolean status = false;
        int montako = 0;

        // vertaa annettua merkkiä arvattavaan sanaan
        //jos merkki löytyy arvattavasta sanasta palauta true, jos ei arvaukset = arvaukset -1 ja return false;
        //lisää arvaus arvauslistalle

        arvatut.add(merkki);

        for(int j = 0; j < valittu.length(); j++) {
            if(valittu.charAt(j) == merkki) {
                montako++;
            }
        }

        if(montako == 0){
            arvauksetMaara = arvauksetMaara -1;
            status = false;
        } else {
            if(montako > 0) {
                status = true;
            }
        }

        return status;


    }

    public List<Character> arvaukset() {
        //palauttaa tehdyt arvaukset lista-oliona
        return arvatut;
    }

    public int arvauksiaOnJaljella() {
        return arvauksetMaara;
    }

    public String sana() {
        return valittu;
    }

    public boolean onLoppu() {
        boolean status = false;
        int montako = 0;
        //kertoo onko peli loppu
        for(int i = 0; i < valittu.length(); i++) {
            for(int j = 0; j<arvatut.size(); j++) {
                if(valittu.charAt(i) == arvatut.get(j)){
                    montako = montako +1;
                } else {
                    montako = montako;
                }
            }
        }

        if(arvauksetMaara == 0 || montako == valittu.length()) {
            status = true;
        } else {
            status = false;
        }

        return status;
    }
}
