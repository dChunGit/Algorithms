/**
 * Header
 * <David Chun>
 * <dc37875>
 * <16495> (Your section id)
 * Please fill inside < >  and do not remove < >.
 */

/**
 * Class to implement Assignment2 solution
 * findProgram method should be implemented.
 * Please do not include any main methods.
 */

import java.util.*;


public class Assignment2 {
    private static int[][] queued, visited;

	// Implement this function
	public static ArrayList<Airdrop> findProgram(int[][] map, int row, int column) {
	    //array to return
	    ArrayList<Airdrop> foundDrops = new ArrayList<>();
	    //create visited array
	    visited = new int[row][column];
        queued = new int[row][column];
		//loop through map rows and columns diagonally
        //max row+column sum is
        int maxArr = (row) + (column);

        for(int m = 0; m < maxArr; m++) {
            for(int r = 0; r < row; r++) {
                //calculate current column value from diagonal sum and row value
                int c = m - r;

                //if valid column number
                if(c >= 0 && c < column) {

                    //if not visited and not 0
                    if(map[r][c] != 0 && visited[r][c] != 1) {
                        //only visits nodes once
                        foundDrops.add(new Airdrop(r, c, runBFS(map, r, c)));

                    }
                }
            }
        }

        return foundDrops;

	}

	private static int runBFS(int[][] map, int r, int c) {

        //bfs
        Queue<Location> locationQueue = new LinkedList<>();
        locationQueue.add(new Location(r,c));

        queued[r][c] = 1;
        int sum = 0;

        while (!locationQueue.isEmpty()) {
            //pop off top && add to set; mark as visited
            Location top = locationQueue.poll();
            visited[top.getRow()][top.getColumn()] = 1;
            sum += map[top.getRow()][top.getColumn()];

            //find adjacents
            Set<Location> adjacent = getAdjacent(map, top.getRow(), top.getColumn());

            //add to queue
            locationQueue.addAll(adjacent);
        }
        return sum;
    }

    /**
     * getAdjacent
     * @param map values in map
     * @param r current row
     * @param c current column
     * @return Set of adjacent locations
     */
    private static Set<Location> getAdjacent(int[][] map, int r, int c) {
	    Set<Location> adjacent = new HashSet<>();

	    if(r - 1 >= 0) {
	        //check left
            if(map[r-1][c] != 0 && queued[r-1][c] != 1) {
                adjacent.add(new Location(r-1, c));
                queued[r-1][c] = 1;
            }
        }
        if(r + 1 < map.length) {
	        //check right
            if(map[r+1][c] != 0 && queued[r+1][c] != 1) {
                adjacent.add(new Location(r+1, c));
                queued[r+1][c] = 1;
            }
        }

        if(c - 1 >= 0) {
	        //check top
            if(map[r][c-1] != 0 && queued[r][c-1] != 1) {
                adjacent.add(new Location(r, c-1));
                queued[r][c-1] = 1;
            }
        }
        if(c + 1 < map[0].length) {
	        //check bottom
            if(map[r][c+1] != 0 && queued[r][c+1] != 1) {
                adjacent.add(new Location(r, c+1));
                queued[r][c+1] = 1;
            }
        }

        return adjacent;
    }
}

/**
 * Location in map with coordinates
 */
class Location {
    private int column, row;

    Location(int r, int c) {
        row = r;
        column = c;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}