import java.sql.SQLOutput;
import java.util.*;
public class PortalGraMax {
    private PomocnikGry pomocnik = new PomocnikGry();
    private ArrayList<Kotek> listaKotkow = new ArrayList<Kotek>();
    private int iloscRuchow = 0;

    private void przygotujGre() {
        Kotek pierwszy = new Kotek();
        pierwszy.setNazwa("Marcela");
        Kotek drugi = new Kotek();
        drugi.setNazwa("Gerwazego");
        Kotek trzeci = new Kotek();
        trzeci.setNazwa("Nathaniela");

        listaKotkow.add(pierwszy);
        listaKotkow.add(drugi);
        listaKotkow.add(trzeci);

        System.out.println("Twoim celem jest powstrzymanie trzech pirackich kotków:");
        System.out.println("Marcela, Gerwazego i Nathaniela.");
        System.out.println("Postaraj się złapać je w jak najmniejszej ilości ruchów. Plansza ma wielkość 7x7 i wybierasz pole od A do G i od 0 do 6 :)");

        for (Kotek rozmieszczanyKotek : listaKotkow) {
            ArrayList<String> nowePolozenie = pomocnik.rozmiescKotek(3);
            rozmieszczanyKotek.setPolaPolozenia(nowePolozenie);
        }
    }

    private void rozpocznijGre() {
        while (!listaKotkow.isEmpty()) {
            String ruchGracza = pomocnik.pobierzDaneWejsciowe("Podaj pole:");
            sprawdzRuchGracza(ruchGracza);
        }
        zakonczGre();
    }

    private void sprawdzRuchGracza(String ruch) {
        iloscRuchow++;
        String wynik = "Pudło!";

        for (Kotek kotekDoSprawdzenia : listaKotkow) {
            wynik = kotekDoSprawdzenia.sprawdz(ruch);
            if (wynik.equals("Złapałeś Kotka za nogę!")) {
                break;
            }
            if (wynik.equals("Schwytany!")) {
                listaKotkow.remove(kotekDoSprawdzenia);
                break;
            }
        }
        System.out.println(wynik);
    }

    private void zakonczGre() {
        System.out.println("Wszystkie Pirackie Kotki zostały schwytane! Twoje żarełko jest bezpieczne.");
        if (iloscRuchow <= 20) {
            System.out.println("Wykonałeś jedynie " + iloscRuchow + " ruchów.");
            System.out.println("Schwytałeś Kotki zanim zjadły Twoje zapasy, Twoich ludzi i Ciebie.");
        }
    else
    {
        System.out.println("Ale się grzebałeś! Wykonałeś aż " + iloscRuchow + " ruchów.");
        System.out.println("Nie masz zapasów, ludzi i jednej nogi :(");
    }
}

    public static void main (String[] args) {
        PortalGraMax gra = new PortalGraMax();
        gra.przygotujGre();
        gra.rozpocznijGre();
    }
}
