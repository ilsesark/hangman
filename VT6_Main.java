import java.util.InputMismatchException;
import java.util.Scanner;

public class VT6_Main {

    static Scanner sc = new Scanner(System.in);
    public static void main (String [] args) {
        String tiedosto, sana, luettu, paljastettu = "";
        Character arvaus;
        int maara, koko;
        boolean status;

        System.out.println("H I R S I P U U - P E L I");
        System.out.println("Annan tiedoston nimi >");
        tiedosto = sc.nextLine();

        System.out.println("Montako arvausyritystä haluat saada >");
        maara = lueInt();

        Sanalista sanat = new Sanalista(tiedosto);

        Hirsipuu peli = new Hirsipuu(sanat, maara);


        for(int i = 0; i < peli.sana().length(); i++) {
            System.out.print("_ ");
            paljastettu = paljastettu + "_ ";
        }

        do {
            System.out.println("\n");
            System.out.println("Arvauksia jäljellä " +peli.arvauksiaOnJaljella());
            System.out.println("Olet arvannus seuraavat kirjaimet " +peli.arvaukset());
            System.out.println("Anna arvaus >");
            luettu = sc.nextLine();
            arvaus = luettu.charAt(0);

            status = peli.arvaa(arvaus);

            if(status == true) {
                System.out.println("Arvasit oikein.");
                char [] taulukko = paljastettu.toCharArray();
                for(int i = 0; i<peli.sana().length(); i++) {
                    if(peli.sana().charAt(i)==arvaus) {
                        taulukko[i*2] = arvaus;
                    }
                }
                paljastettu = String.valueOf(taulukko);
                System.out.println(paljastettu);

            } else {
                System.out.println("Arvasit väärin.");
                System.out.println(paljastettu);
            }

        } while(peli.onLoppu() == false);

        if(peli.getArvauksetMaara() == 0){
            System.out.println("Peli loppui. Et arvannut sanaa " +peli.sana());
        } else {
            System.out.println("Onneksi olkoon! Arvasit sanan!");
        }


    }

    public static int lueInt() {
        int luettu = 0;
        boolean status = false;

        while( status != true ){

            try {
                luettu = sc.nextInt();
                sc.nextLine();

                if(luettu < 0) {
                    status = false;
                    System.out.println("Virheellinen arvo, yritä uudelleen >");
                } else {
                    status = true;
                    return luettu;
                }

            }catch( NumberFormatException | InputMismatchException ime){
                System.out.println("Virhe, yrita uudelleen > ");
                sc.nextLine();
            }
        }

        return luettu;
    }

    public static double lueDouble() {
        double luettu = 0;
        boolean status = false;

        while( status != true){

            try {
                luettu = sc.nextDouble();
                sc.nextLine();

                if(luettu < 0) {
                    status = false;
                    System.out.println("Virheellinen arvo, yritä uudelleen >");
                } else {
                    status = true;
                    return luettu;
                }

            }catch( NumberFormatException | InputMismatchException ime){
                System.out.println("Virhe, yrita uudelleen > ");
                sc.nextLine();
            }

        }

        return luettu;
    }
}
