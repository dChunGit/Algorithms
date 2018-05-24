import java.util.ArrayList;
import java.util.Arrays;

/**
 * Header
 * <firstName surName>
 * <eid>
 * <uniqueId> (Your section id)
 * Please fill inside < >  and do not remove < >.
 */

public class Assignment3 {

	private int totalClasses;
	private int maxGrade;
	private static int[][] gradearray;

	public Assignment3() {
		this.totalClasses = 0;
		this.maxGrade = 0;
		this.gradearray = null;
	}

	public void initialize(int totalClasses, int maxGrade,  int[][] gradearray) {//These varaibles are set from TestAssignment3.java
		this.totalClasses = totalClasses;
		this.maxGrade = maxGrade;
		this.gradearray = gradearray;
	}


	public result[] compute(int totalHours, result[] studentoutput) {
	    System.out.println(studentoutput.length);
		//Write your Code For Assignment 3 Here.
        int[][] grid = new int[totalClasses+1][totalHours+1];
        int[][] tracker = new int[totalClasses+1][totalHours+1];

        for(int a = 0; a < totalClasses + 1; a++) {
            for(int b = 0; b < totalHours+1; b++) {
                if(a == 0) {
                    grid[a][b] = 0;
                } else if(b == 0) {
                    grid[a][b] = grid[a-1][b] + gradearray[a - 1][b];
                    tracker[a][b] = b;
                } else {
                    int[] prevMax = calcMax(a, b, grid);
                    //double check what happens?

                        //System.out.println(Arrays.toString(prevMax));
                        grid[a][b] = prevMax[0];
                        tracker[a][b] = prevMax[1];
                    //}
                }
            }
        }

        System.out.println();
        System.out.println(Arrays.deepToString(grid).replace("], ", "]\n"));
        System.out.println();
        System.out.println(Arrays.deepToString(tracker).replace("], ", "]\n"));
        System.out.println();

        /*int max = 0, index = 0, c = 0;

        while(c < totalHours+1) {
            if (grid[grid.length - 1][c] >= max) {
                max = grid[grid.length - 1][c];
                index = c;
            }
            //System.out.println(grid[grid.length-1][c] + " " + c + " " + max + " " + index);
            c++;
        }
        System.out.println(max + " " + index);*/

        /*int a = 1, index = 0, usedTime = 0;
        while(a <= totalClasses && usedTime <= totalHours) {
            int i = tracker[a][totalHours - usedTime];
            index = tracker[a][i];
            usedTime += index;
            //System.out.println(index + " " + gradearray[a-1][index]);
            studentoutput[a-1].setHour(index);
            studentoutput[a-1].setGrade(gradearray[a-1][index]);
            a++;
        }*/
        int a = totalClasses, index = 0, usedTime = 0;
        while(a > 0 && usedTime <= totalHours) {
            /*int i = tracker[a][totalHours - usedTime];
            index = tracker[a][i];*/
            index = tracker[a][totalHours - usedTime];
            usedTime += index;
            System.out.println(index + " " + index + " " + gradearray[a-1][index]);
            studentoutput[a-1].setHour(index);
            studentoutput[a-1].setGrade(gradearray[a-1][index]);
            a--;
        }

        System.out.println(Arrays.toString(studentoutput));

        return studentoutput;
	}


	private int[] calcMax(int classnum, int hours, int[][] grid) {
	    int[] values = new int[2];

	    for(int a = 0; a <= hours; a++) {
	        int add = 0;
	        if(a < gradearray[0].length) {
	            add = gradearray[classnum-1][a];
            }
	        int compare = grid[classnum-1][hours-a] + add;
	        //System.out.println(add + " " + grid[classnum-1][hours-a] + " " + (hours-a) + " " + a);
	        if(compare > values[0]) {
	            values[0] = compare;
	            values[1] = a;
            }
        }
	    return values;
    }

}


/*  WRITE YOUR REPORT INSIDE THIS SECTION AS COMMENTED CODE
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
