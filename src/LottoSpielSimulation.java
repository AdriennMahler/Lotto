import java.util.Arrays;
import java.util.Random;

public class LottoSpielSimulation {

    int anzahlKugel;
    int anzahlKugelGesamt=49;
    int[] lottoZahlen;
    int[] lottoTipp;

    public class LottoSpiel {

        public LottoSpiel(int anzahlKugel, int anzahlKugelGesamt) {
            lottoZahlen = new int[anzahlKugel];
            ziehen(anzahlKugel, anzahlKugelGesamt);
        }

        public void ziehen(int anzahlKugel, int anzahlKugelGesamt) {
            Random rnd = new Random();
            for (int i = 0; i < lottoZahlen.length; i++) {
                lottoZahlen[i] = rnd.nextInt(anzahlKugelGesamt) + 1;
            }
            Arrays.sort(lottoZahlen);
        }


        public String toString() {
            String arrAsText = Arrays.toString(lottoZahlen);
            return "Spiel " + lottoZahlen.length + " aus " + anzahlKugelGesamt + ". " + arrAsText;
        }
    }

    public class LottoTipp {

        public LottoTipp(int anzahlKugel, int anzahlKugelGesamt) {
            lottoTipp = new int[anzahlKugel];
            abgeben(anzahlKugel, anzahlKugelGesamt);
        }

        public void abgeben(int anzahlKugel, int anzahlKugelGesamt) {
            Random rnd = new Random();
            for (int i = 0; i < lottoTipp.length; i++) {
                lottoTipp[i] = rnd.nextInt(anzahlKugelGesamt + 1);
            }
            Arrays.sort(lottoTipp);
        }

        public String toString() {
            String arrAsText = Arrays.toString(lottoTipp);

            return "Tipp " + lottoTipp.length + " aus " + anzahlKugelGesamt + ". " + arrAsText;
        }
    }
        public int vergleichen() {
            int count = 0;
            int gewinn = 1;
            for (int i = 0; i < lottoZahlen.length; i++) {
                if (lottoZahlen[i] == lottoTipp[i]) {
                    count++;
                }
            }
                if (count == 0)
                    gewinn-=1;
                if (count == 1)
                    gewinn+=0;
                if (count == 2)
                    gewinn*=10;
                if (count == 3)
                    gewinn*=100;
                if (count == 3)
                    gewinn*=1000;

            System.out.println(count + " richtige " + gewinn + " euro");
            return count;
        }

        public static void main(String[] args) {

            LottoSpielSimulation simulation = new LottoSpielSimulation();
            LottoSpiel lotto = simulation.new LottoSpiel(7, 49);
            LottoTipp tipp = simulation.new LottoTipp(7, 49);
            lotto.ziehen(7, 49);
            tipp.abgeben(7, 49);
            System.out.println(lotto);
            System.out.println(tipp);
            simulation.vergleichen();

        }

}