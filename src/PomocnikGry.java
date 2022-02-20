import java.io.*;
import java.util.*;

public class PomocnikGry {
    private static final String alfabet = "abcdefg";
    private int dlugoscPlanszy = 7;
    private int wielkoscPlanszy = 49;
    private int [] plansza = new int[wielkoscPlanszy];
    private int iloscKotkow = 0;

    public String pobierzDaneWejsciowe(String komunikat) {
        String daneWejsciowe = null;
        System.out.println(komunikat + " ");
        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
            daneWejsciowe = is.readLine();
            if (daneWejsciowe.length() == 0 ) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return daneWejsciowe.toLowerCase();
    }
    public ArrayList<String> rozmiescKotek(int wielkoscKotka) {
        ArrayList<String> zajetePola = new ArrayList<String>();
        String [] wspolrzedneLnc = new String [wielkoscKotka];
        String pomoc = null;
        int [] wspolrzedne = new int[wielkoscKotka];
        int prob = 0;
        boolean powodzenie = false;
        int polozenie = 0;

        iloscKotkow++;
        int inkr = 1;
        if ((iloscKotkow % 2) == 1) {
            inkr = dlugoscPlanszy;
        }
        while (!powodzenie & prob++ < 200) {
            polozenie = (int) (Math.random() * wielkoscPlanszy);
            int x = 0;
            powodzenie = true;
            while (powodzenie && x < wielkoscKotka) {
                if (plansza[polozenie] == 0) {
                    wspolrzedne[x++] = polozenie;
                    polozenie += inkr;
                    if (polozenie >= wielkoscPlanszy) {
                        powodzenie = false;
                    }
                    if (x > 0 & (polozenie % dlugoscPlanszy == 0)) {
                        powodzenie = false;
                    }
                    } else {
                        powodzenie = false;
                    }
                }
        }
            int x = 0;
            int wiersz = 0;
            int kolumna = 0;
            while (x < wielkoscKotka) {
                plansza[wspolrzedne[x]] = 1;
                wiersz = (int) (wspolrzedne[x] / dlugoscPlanszy);
                kolumna = wspolrzedne[x] % dlugoscPlanszy;
                pomoc = String.valueOf(alfabet.charAt(kolumna));
                zajetePola.add(pomoc.concat(Integer.toString(wiersz)));
                x++;
            }
            return zajetePola;
        }
    }


