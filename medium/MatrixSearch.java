/**
 * MatrixSearch
 */
public class MatrixSearch {
    
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, 0, matrix[0].length, 0, matrix.length, target);
    }
    

    boolean search(int[][] matrix, int left, int right, int top, int bottom,int target){
        if(right <= left || bottom <= top) return false;

        int vertMid = (right - left) /2 + left;
        int hrztMid = (bottom - top) / 2 + top;
        boolean bool = false;

        int max = matrix[bottom - 1][right - 1];

        int min = matrix[top][left];
        if(target == min || target == max) return true;

        if( !(target > min && target < max) ) return false;

        //left top

        bool |=search(matrix, left, vertMid, top, hrztMid, target);

        //right top

        bool |=search(matrix, vertMid, right, top, hrztMid, target);

        //left bottom

        bool |=search(matrix, left, vertMid, hrztMid, bottom, target);

        //right bottom

        bool |=search(matrix, vertMid, right, hrztMid, bottom, target);

        return bool;

    }

    public static void main(String[] args) {
        new MatrixSearch().searchMatrix(new int[][]{{1,4,7,11,15},}, 5);
    }
    
}