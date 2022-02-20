import java.util.*;
class Kotek {
    private ArrayList<String> polaPolozenia;
    private String nazwa;

    public void setPolaPolozenia(ArrayList<String> ppol) {
        polaPolozenia = ppol;
    }
    public void setNazwa(String nzwKotka) {
    nazwa = nzwKotka;
    }

    public String sprawdz(String ruch) {
        String wynik = "Pudło!";
        int indeks = polaPolozenia.indexOf(ruch);
        if (indeks >= 0) {
            polaPolozenia.remove(indeks);

            if (polaPolozenia.isEmpty()) {
                wynik = "Schwytany!";
                System.out.println("Auć! Schwytałeś Kotka " + nazwa + " :( ");
            } else {
                wynik = "Złapałeś Kotka za nogę!";
            }
        }
        return wynik;
    }

}
