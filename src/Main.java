import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        //char[][] laby = new char[12][10];


            char[][] laby ={
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
        Point ziel = null;

        System.out.println(start);
        // point.x = Zeile

        int[][] distanz = new int[laby.length][laby[0].length];
        for(int[]  sub: distanz) {
            Arrays.fill(sub, -1);
        }
        distanz[start.x][start.y] = 0;

        ArrayList<Point> suche = new ArrayList<>();
        suche.add(start);

        Point standfeld;
        while (!suche.isEmpty()) {
            standfeld = suche.get(0);
            // guck nach oben
            if (standfeld.x > 0) {  // wir stehen nicht oben am Rand
                if (laby[standfeld.x-1][standfeld.y] != '#'
                    && distanz[standfeld.x-1][standfeld.y] == -1) {
                    distanz[standfeld.x-1][standfeld.y] = distanz[standfeld.x][standfeld.y] + 1;
                    suche.add(new Point(standfeld.x-1,standfeld.y));
                }
            }

            // guck nach unten

            // guck nach links

            // guck nach rechts

            suche.remove(standfeld);
        }

    }
}
