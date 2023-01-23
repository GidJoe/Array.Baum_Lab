import java.awt.*;

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
                if (laby[spalte][zeile] == 'S') {
                    start = new Point(zeile, spalte);
                }
            }
        }
    }
}
