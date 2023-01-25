import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        //char[][] laby = new char[12][10];


        char[][] laby = {
                {'#', '#', '#', '#', '#', 'Z', '#'},
                {'#', ' ', ' ', ' ', '#', ' ', '#'},
                {'#', ' ', '#', '#', '#', ' ', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', ' ', ' ', '#', '#', '#'},
                {'#', ' ', '#', ' ', '#', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', '#'},
                {'#', ' ', '#', ' ', ' ', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', '#'},
                {'#', ' ', '#', ' ', '#', ' ', '#'},
                {'#', 'S', '#', '#', '#', '#', '#'},
        };

        Point start = null;
        for (int zeile = 0; zeile < laby.length; zeile++) {
            for (int spalte = 0; spalte < laby[zeile].length; spalte++) {
                if (laby[zeile][spalte] == 'S') {
                    start = new Point(zeile, spalte);
                }
            }
        }


        System.out.println(start);
        // point.x = Zeile

        int[][] distanz = new int[laby.length][laby[0].length];

        for (int[] sub : distanz) {
            Arrays.fill(sub, -1);
        }

        // Spieler positionieren
        distanz[start.x][start.y] = 0;

        ArrayList<Point> suche = new ArrayList<>();

        suche.add(start);

        Point standfeld;

        while (!suche.isEmpty()) {
            standfeld = suche.get(0);



            // guck nach oben
            if (standfeld.x > 0) {  // wir stehen nicht oben am Rand
                if (laby[standfeld.x - 1][standfeld.y] != '#'
                        && distanz[standfeld.x - 1][standfeld.y] == -1) {
                    distanz[standfeld.x - 1][standfeld.y] = distanz[standfeld.x][standfeld.y] + 1;
                    suche.add(new Point(standfeld.x - 1, standfeld.y));
                }
            }

            // guck nach unten

            if (standfeld.x < 0) {  // wir stehen nicht oben am Rand
                if (laby[standfeld.x + 1][standfeld.y] != '#'
                        && distanz[standfeld.x + 1][standfeld.y] == -1) {
                    distanz[standfeld.x + 1][standfeld.y] = distanz[standfeld.x][standfeld.y] + 1;
                    suche.add(new Point(standfeld.x + 1, standfeld.y));
                }
            }

            // guck nach links

            if (standfeld.x > 0) {  // wir stehen nicht oben am Rand
                if (laby[standfeld.x][standfeld.y - 1] != '#'
                        && distanz[standfeld.x][standfeld.y - 1] == -1) {
                    distanz[standfeld.x][standfeld.y - 1] = distanz[standfeld.x][standfeld.y] + 1;
                    suche.add(new Point(standfeld.x, standfeld.y - 1));
                }
            }
            // guck nach rechts

            if (standfeld.x > 0) {  // wir stehen nicht oben am Rand
                if (laby[standfeld.x][standfeld.y + 1] != '#'
                        && distanz[standfeld.x][standfeld.y + 1] == -1) {
                    distanz[standfeld.x][standfeld.y + 1] = distanz[standfeld.x][standfeld.y] + 1;
                    suche.add(new Point(standfeld.x, standfeld.y + 1));
                }
            }


            suche.remove(standfeld);
        }


        for (int i = 0; i < laby.length; i++) {
            System.out.println(Arrays.toString(distanz[i]));

        }

    }
}
