import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        test1();
        System.out.println();
        test2();
        System.out.println();
        test3();
    }

    public static void test1() {

        int[][] map = new int[4][4];
        map[0][0] = 1;
        map[0][1] = 1;

        map[0][3] = 1;
        map[1][2] = 2;
        map[1][3] = 1;

        map[2][0] = 3;
        map[3][0] = 2;

        map[3][2] = 3;
        for(int a = 0; a < map.length; a++) {
            System.out.println(Arrays.toString(map[a]));
        }

        ArrayList<Airdrop> results = Assignment2.findProgram(map, 4, 4);
        for(int a = 0; a < results.size(); a++) {
            System.out.println(results.get(a));
        }
    }

    public static void test2() {
        int[][] map = new int[4][5];
        map[0][1] = 3;
        map[1][0] = 2;
        map[1][1] = 1;

        map[0][3] = 2;
        map[0][4] = 2;
        map[1][3] = 1;
        map[1][4] = 2;

        map[3][0] = 1;
        map[3][1] = 3;
        map[3][2] = 1;

        map[3][4] = 1;
        for(int a = 0; a < map.length; a++) {
            System.out.println(Arrays.toString(map[a]));
        }

        ArrayList<Airdrop> results = Assignment2.findProgram(map, 4, 5);
        for(int a = 0; a < results.size(); a++) {
            System.out.println(results.get(a));
        }
    }

    public static void test3() {
        int[][] map = new int[2][4];
        map[0][0] = 1;
        map[0][1] = 2;
        map[0][2] = 3;
        map[0][3] = 4;
        map[1][1] = 1;
        map[1][2] = 2;
        map[1][3] = 3;
        for(int a = 0; a < map.length; a++) {
            System.out.println(Arrays.toString(map[a]));
        }

        ArrayList<Airdrop> results = Assignment2.findProgram(map, 2, 4);
        for(int a = 0; a < results.size(); a++) {
            System.out.println(results.get(a));
        }
    }

}
