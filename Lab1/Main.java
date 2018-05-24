import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //testOne();
        //testTwo();
        //testThree();
        testFour();

    }

    public static void testOne() {
        ArrayList<Integer> f = new ArrayList<>(Arrays.asList(4,3,1,2));
        ArrayList<Integer> s = new ArrayList<>(Arrays.asList(2,1,3,4));
        ArrayList<Integer> t = new ArrayList<>(Arrays.asList(1,3,4,2));
        ArrayList<Integer> fo = new ArrayList<>(Arrays.asList(4,3,1,2));

        ArrayList<Integer> sf = new ArrayList<>(Arrays.asList(3,2,4,1));
        ArrayList<Integer> ss = new ArrayList<>(Arrays.asList(2,3,1,4));
        ArrayList<Integer> st = new ArrayList<>(Arrays.asList(3,1,2,4));
        ArrayList<Integer> sfo = new ArrayList<>(Arrays.asList(3,2,4,1));

        ArrayList<ArrayList<Integer>> profs = new ArrayList<>();
        profs.addAll(Arrays.asList(f,s,t,fo));
        ArrayList<ArrayList<Integer>> studs = new ArrayList<>();
        studs.addAll(Arrays.asList(sf,ss,st,sfo));

        Preferences preferences = new Preferences(4, 4, profs, studs);

        System.out.println(Assignment1.stableMatchBruteForce(preferences));

        //System.out.println(Assignment1.stableMatchGaleShapley(preferences));

        //System.out.println(Assignment1.stableMatchCosts(preferences));

        //System.out.println(Assignment1.stableMatchCostsStudent(preferences));
    }

    public static void testTwo() {
        ArrayList<Integer> f = new ArrayList<>(Arrays.asList(3,4,2,1,6,7,5));
        ArrayList<Integer> s = new ArrayList<>(Arrays.asList(6,4,2,3,5,1,7));
        ArrayList<Integer> t = new ArrayList<>(Arrays.asList(6,3,5,7,2,4,1));
        ArrayList<Integer> fo = new ArrayList<>(Arrays.asList(1,6,3,2,4,7,5));
        ArrayList<Integer> ff = new ArrayList<>(Arrays.asList(1,6,5,3,4,7,2));
        ArrayList<Integer> si = new ArrayList<>(Arrays.asList(1,7,3,4,5,6,2));
        ArrayList<Integer> se = new ArrayList<>(Arrays.asList(5,6,2,4,3,7,1));

        ArrayList<Integer> sf = new ArrayList<>(Arrays.asList(4,5,3,7,2,6,1));
        ArrayList<Integer> ss = new ArrayList<>(Arrays.asList(5,6,4,7,3,2,1));
        ArrayList<Integer> st = new ArrayList<>(Arrays.asList(1,6,5,4,3,7,2));
        ArrayList<Integer> sfo = new ArrayList<>(Arrays.asList(3,5,6,7,2,4,1));
        ArrayList<Integer> sff = new ArrayList<>(Arrays.asList(1,7,6,4,3,5,2));
        ArrayList<Integer> ssi = new ArrayList<>(Arrays.asList(6,3,7,5,2,4,1));
        ArrayList<Integer> sse = new ArrayList<>(Arrays.asList(1,7,4,2,6,5,3));

        ArrayList<ArrayList<Integer>> profs = new ArrayList<>();
        profs.addAll(Arrays.asList(f,s,t,fo,ff,si,se));
        ArrayList<ArrayList<Integer>> studs = new ArrayList<>();
        studs.addAll(Arrays.asList(sf,ss,st,sfo,sff,ssi,sse));

        Preferences preferences = new Preferences(7, 7, profs, studs);
        //System.out.println(profs);
        //System.out.println(studs);

        System.out.println(Assignment1.stableMatchBruteForce(preferences));

        //System.out.println(Assignment1.stableMatchGaleShapley(preferences));

        //System.out.println(Assignment1.stableMatchCosts(preferences));

        //System.out.println(Assignment1.stableMatchCostsStudent(preferences));
    }

    public static void testThree() {
        ArrayList<Integer> f = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> s = new ArrayList<>(Arrays.asList(2,1,3));
        ArrayList<Integer> t = new ArrayList<>(Arrays.asList(1,2,3));

        ArrayList<Integer> sf = new ArrayList<>(Arrays.asList(2,1,3));
        ArrayList<Integer> ss = new ArrayList<>(Arrays.asList(1,2,3));
        ArrayList<Integer> st = new ArrayList<>(Arrays.asList(1,2,3));

        ArrayList<ArrayList<Integer>> profs = new ArrayList<>();
        profs.addAll(Arrays.asList(f,s,t));
        ArrayList<ArrayList<Integer>> studs = new ArrayList<>();
        studs.addAll(Arrays.asList(sf,ss,st));

        Preferences preferences = new Preferences(4, 4, profs, studs);

        System.out.println(Assignment1.stableMatchBruteForce(preferences));

        System.out.println(Assignment1.stableMatchGaleShapley(preferences));

        //System.out.println(Assignment1.stableMatchCosts(preferences));

        //System.out.println(Assignment1.stableMatchCostsStudent(preferences));
    }

    public static void testFour() {
        ArrayList<Integer> f = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> s = new ArrayList<>(Arrays.asList(2,3,4,5,1));
        ArrayList<Integer> t = new ArrayList<>(Arrays.asList(3,4,5,1,2));
        ArrayList<Integer> fo = new ArrayList<>(Arrays.asList(4,5,1,2,3));
        ArrayList<Integer> fi = new ArrayList<>(Arrays.asList(5,1,2,3,4));

        ArrayList<Integer> sf = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        ArrayList<Integer> ss = new ArrayList<>(Arrays.asList(2,3,4,5,1));
        ArrayList<Integer> st = new ArrayList<>(Arrays.asList(3,4,5,1,2));
        ArrayList<Integer> sfo = new ArrayList<>(Arrays.asList(4,5,1,2,3));
        ArrayList<Integer> sfi = new ArrayList<>(Arrays.asList(5,1,2,3,4));

        ArrayList<ArrayList<Integer>> profs = new ArrayList<>();
        profs.addAll(Arrays.asList(f,s,t,fo,fi));
        ArrayList<ArrayList<Integer>> studs = new ArrayList<>();
        studs.addAll(Arrays.asList(sf,ss,st,sfo,sfi));

        Preferences preferences = new Preferences(5, 5, profs, studs);

        System.out.println(Assignment1.stableMatchBruteForce(preferences));

        System.out.println(Assignment1.stableMatchGaleShapley(preferences));

        //System.out.println(Assignment1.stableMatchCosts(preferences));

        //System.out.println(Assignment1.stableMatchCostsStudent(preferences));
    }
}
