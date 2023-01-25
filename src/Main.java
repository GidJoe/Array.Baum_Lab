import java.awt.*;
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

            if (standfeld.x < laby.length - 1) {  // wir stehen nicht oben am Rand
                if (laby[standfeld.x + 1][standfeld.y] != '#'
                        && distanz[standfeld.x + 1][standfeld.y] == -1) {
                    distanz[standfeld.x + 1][standfeld.y] = distanz[standfeld.x][standfeld.y] + 1;
                    suche.add(new Point(standfeld.x + 1, standfeld.y));
                }
            }

            // guck nach links

            if (standfeld.y > 0) {  // wir stehen nicht oben am Rand
                if (laby[standfeld.x][standfeld.y - 1] != '#'
                        && distanz[standfeld.x][standfeld.y - 1] == -1) {
                    distanz[standfeld.x][standfeld.y - 1] = distanz[standfeld.x][standfeld.y] + 1;
                    suche.add(new Point(standfeld.x, standfeld.y - 1));
                }
            }
            // guck nach rechts

            if (standfeld.y < laby[0].length - 1) {  // wir stehen nicht oben am Rand
                if (laby[standfeld.x][standfeld.y + 1] != '#'
                        && distanz[standfeld.x][standfeld.y + 1] == -1) {
                    distanz[standfeld.x][standfeld.y + 1] = distanz[standfeld.x][standfeld.y] + 1;
                    suche.add(new Point(standfeld.x, standfeld.y + 1));
                }
            }


            suche.remove(standfeld);
        }

        distanz[10][1] = 111;
        System.out.println(distanz[10][1]);
        String ausgabe = "";
        for (int i = 0; i < laby.length; i++) {
            ausgabe += Arrays.toString(distanz[i]) + "\n";

        }


        System.out.println(ausgabe.replace(",", "\t")
                .replace("-1", "██")
                .replace("[", " ")
                .replace("]", " ")
                .replace("111", "☺")
        );
    }
}

