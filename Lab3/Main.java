import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Assignment3 program = new Assignment3();
        int[][] gradeArray = new int[3][3];
        gradeArray[0][0] = 1;
        gradeArray[0][1] = 3;
        gradeArray[0][2] = 3;
        gradeArray[1][0] = 1;
        gradeArray[1][1] = 2;
        gradeArray[1][2] = 3;
        gradeArray[2][0] = 0;
        gradeArray[2][1] = 4;
        gradeArray[2][2] = 4;
        System.out.println(Arrays.deepToString(gradeArray).replace("], ", "]\n"));

        program.initialize(3, 10, gradeArray);
        result[] studentoutput=new result[3];

        for(int i=0;i<3;i++) {
            studentoutput[i]=new result(0,0);//initializing arrays of object type result
        }
        studentoutput=program.compute(5, studentoutput);//Returns computed Values from Assignment3.java
        //System.out.println(Arrays.toString(studentoutput));

    }
}
