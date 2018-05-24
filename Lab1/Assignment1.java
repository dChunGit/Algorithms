/**
 *  Name: David Chun
 *  UTID: dc37875
 */

import java.util.*;

public class Assignment1 {

    // Part1: Implement a Brute Force Solution
    public static ArrayList<Integer> stableMatchBruteForce(Preferences preferences) {

        //create initial list of matched students
        ArrayList<Integer> students = new ArrayList<>();
        for(int i = 0; i < preferences.getNumberOfStudents(); i++) {
            students.add(i);
        }

        //recursive cases
        return stableMatchHelper(0, preferences, students, new ArrayList<>());
    }

    private static ArrayList<Integer> stableMatchHelper(int index, Preferences preferences, ArrayList<Integer> studMatched,
                                                        ArrayList<Integer> current) {
        //base case
        if(index == preferences.getProfessors_preference().size()) {
            //if current is a stable matching
            if(checkStable(preferences, current)) {
                return current;
            }
            //unstable match found
            return null;
        }

        //current professor
        ArrayList<Integer> profPrefs = preferences.getProfessors_preference().get(index);

        //all possible matches for professor of index
        int a = 0;
        while(a < profPrefs.size()) {

            //if not matched already
            if(studMatched.contains(profPrefs.get(a) - 1)) {

                //try case
                current.add(profPrefs.get(a) - 1);
                studMatched.remove(new Integer(profPrefs.get(a) - 1));
                ArrayList<Integer> interim = stableMatchHelper(index + 1, preferences, studMatched, current);

                if(interim != null) {

                    //stable found with this element
                    return interim;

                } else {

                    //no stable match found with this pair
                    studMatched.add(profPrefs.get(a) - 1);
                    current.remove(new Integer(profPrefs.get(a) - 1));
                }
            }
            a++;
        }
        //ran out of preferences
        return null;
    }

    private static boolean checkStable(Preferences preferences, ArrayList<Integer> current) {

        //litmus test: man prefers woman and woman prefers man
        ArrayList<ArrayList<Integer>> profPrefs = preferences.getProfessors_preference();
        ArrayList<ArrayList<Integer>> studentPrefs = preferences.getStudents_preference();

        for(int a = 0; a < current.size(); a++) {

            //get student matched with professor
            int match = current.get(a);
            ArrayList<Integer> csPrefs = studentPrefs.get(match);
            int location = csPrefs.indexOf(a + 1);

            //get ones preferred
            for(int b = 0; b < location; b++) {

                //get professor in student slot
                int prof = csPrefs.get(b);

                //get prof preference list
                ArrayList<Integer> cpPrefs = profPrefs.get(prof - 1);

                //get index of student prof is matched with currently
                int cmatch = cpPrefs.indexOf(current.get(prof - 1) + 1);

                //if prefers
                if(cpPrefs.indexOf(match + 1) < cmatch) {
                    return false;
                }
            }
        }

        return true;
    }

    // Part2: Implement Gale-Shapley Algorithm
    public static ArrayList<Integer> stableMatchGaleShapley(Preferences preferences) {

        ArrayList<ArrayList<Integer>> profPrefs = preferences.getProfessors_preference();
        ArrayList<ArrayList<Integer>> studentPrefs = preferences.getStudents_preference();
        ArrayList<int[]> inverse = new ArrayList<>();
        int[] students = new int[studentPrefs.size()];
        int[] profIndex = new int[profPrefs.size()];
        ArrayList<Integer> profs = new ArrayList<>();

        for(int a = 0; a < profPrefs.size(); a++) {
            profs.add(-1);
        }

        //create initial queue
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < profPrefs.size(); i++) {
            queue.add(i);
        }

        //create inverse preference list
        for(ArrayList<Integer> currentStudent : studentPrefs) {
            int[] temp = new int[studentPrefs.size()];

            for(int b = 0; b < studentPrefs.size(); b++) {
                temp[currentStudent.get(b) - 1] = b;
            }
            inverse.add(temp);
        }

        //Gale-Shapely
        while(!queue.isEmpty()) {

            //ranking of students for current professor
            int current = queue.remove();
            ArrayList<Integer> currentProf = profPrefs.get(current);

            //if man has not proposed to everyone
            if(profIndex[current] < currentProf.size()) {

                //highest woman not proposed to
                int highest = currentProf.get(profIndex[current]) - 1;
                profIndex[current]++;

                //get inverse preference list for current woman
                int[] inversePreflist = inverse.get(highest);

                if (students[highest] == 0) {

                    //if free
                    students[highest] = 1;
                    profs.set(current, highest);
                } else {

                    //not free -> get prof chosen
                    int engaged = profs.indexOf(highest);
                    if (inversePreflist[current] < inversePreflist[engaged]) {

                        //prefers new match over old match
                        students[highest] = 1;
                        profs.set(current, highest);
                        queue.add(engaged);

                    } else {
                        queue.add(current);
                    }
                }
            }
        }

        return profs;

    }

    // Part3: Matching with Costs
    public static ArrayList<Cost> stableMatchCosts(Preferences preferences) {

        //prof optimal
        ArrayList<Integer> profOptimal = stableMatchGaleShapley(preferences);
        ArrayList<ArrayList<Integer>> profPrefs = preferences.getProfessors_preference();
        ArrayList<ArrayList<Integer>> studPrefs = preferences.getStudents_preference();
        ArrayList<Cost> costs = new ArrayList<>();

        //for each pairing
        for(int a = 0; a < profOptimal.size(); a++) {
            ArrayList<Integer> currentProf = profPrefs.get(a);
            ArrayList<Integer> currentStud = studPrefs.get(profOptimal.get(a));

            //calculate new costs
            Cost cost = new Cost(a, profOptimal.get(a),
                    currentProf.indexOf(profOptimal.get(a) + 1), currentStud.indexOf(a + 1));
            costs.add(cost);
        }
        return costs;
    }

    public static ArrayList<Cost> stableMatchCostsStudent(Preferences preferences) {

        //reverse preferences
        ArrayList<ArrayList<Integer>> copyStudents = copy(preferences.getStudents_preference());
        ArrayList<ArrayList<Integer>> copyProfessors = copy(preferences.getProfessors_preference());

        Preferences oppPreferences = new Preferences(preferences.getNumberOfStudents(),
                preferences.getNumberOfProfessors(), copyStudents, copyProfessors);

        //student optimal
        ArrayList<Integer> studOptimal = stableMatchGaleShapley(oppPreferences);
        ArrayList<ArrayList<Integer>> profPrefs = preferences.getProfessors_preference();
        ArrayList<ArrayList<Integer>> studPrefs = preferences.getStudents_preference();
        ArrayList<Cost> costs = new ArrayList<>();

        //for each pairing
        for(int a = 0; a < studOptimal.size(); a++) {
            ArrayList<Integer> currentStud = studPrefs.get(a);
            ArrayList<Integer> currentProf = profPrefs.get(studOptimal.get(a));

            //calculate new costs
            Cost cost = new Cost(a, studOptimal.get(a),
                    currentStud.indexOf(studOptimal.get(a) + 1), currentProf.indexOf(a + 1));
            costs.add(cost);

        }
        return costs;
    }

    private static ArrayList<ArrayList<Integer>> copy(ArrayList<ArrayList<Integer>> toCopy) {

        //arraylist to copy into
        ArrayList<ArrayList<Integer>> copy = new ArrayList<>();

        //copy elements over
        for(int a = 0; a < toCopy.size(); a++) {
            ArrayList<Integer> inside = toCopy.get(a);
            ArrayList<Integer> copyInside = new ArrayList<>();

            for(int b = 0; b < inside.size(); b++) {
                copyInside.add(inside.get(b));
            }
            copy.add(copyInside);
        }

        return copy;
    }
}
