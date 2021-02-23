package offer;

import java.util.ArrayList;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-19
 * Time:18:01
 */
public class 顺时针打印矩阵 {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        ArrayList<Integer> list = printMatrix(arr);
        System.out.println(list);
    }
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if(matrix == null) {
            return list;
        }

        int firstRow = 0;//第一行
        int lastRow = matrix.length-1;//最后一行
        int firstColumn = 0;//第一列
        int lastColumn = matrix[0].length-1;//最后一列
        while(firstRow <= lastRow && firstColumn <= lastColumn) {
            //1.向右遍历
            for(int i = firstColumn;i <= lastColumn;i++) {
                list.add(matrix[firstRow][i]);
            }
            //2.向下遍历
            for(int i = firstRow+1;i <= lastRow;i++) {
                list.add(matrix[i][lastColumn]);
            }
            //3.向左遍历
            //可能只有一行的测试用例，所以增加条件 firstRow < lastRow
            if(firstRow < lastRow) {
                for(int i = lastColumn-1;i >= firstColumn;i--) {
                    list.add(matrix[lastRow][i]);
                }
            }
            //4.向上遍历
            //同上可能只有一列的测试用例，增加条件 firstColumn < lastColumn
            if(firstColumn < lastColumn) {
                for(int i = lastRow-1;i > firstRow;i--) {
                    list.add(matrix[i][firstColumn]);
                }
            }
            //走完一圈后向内圈缩小，则四个标志位要变换
            firstRow++;
            lastRow--;
            firstColumn++;
            lastColumn--;
        }
        return list;
    }
}
