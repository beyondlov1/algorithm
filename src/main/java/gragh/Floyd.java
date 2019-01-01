package gragh;

import java.util.Arrays;

/**
 * 最短路径
 * @author beyondlov1
 * @date 2019/01/01
 */
public class Floyd {
    private static int[][] graph(){
        final int m = 65535;
        return new int[][]{
                {0,1,5,m,m,m,m,m,m},
                {1,0,3,7,5,m,m,m,m},
                {5,3,0,m,1,7,m,m,m},
                {m,7,m,0,2,m,3,m,m},
                {m,5,1,2,0,4,6,9,m},
                {m,m,7,m,3,0,m,5,m},
                {m,m,m,3,6,m,0,2,7},
                {m,m,m,m,9,5,2,0,4},
                {m,m,m,m,m,m,7,4,0}
        };
    }

    public static void main(String[] args) {
        int[][] graph = graph();
        go(graph);
    }

    private static void go(int[][] graph) {
        int row = graph.length;
        int col = graph.length;
        int[][] d = new int[row][col];
        int[][] p = new int[row][col];
        //初始化
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                d[i][j] = graph[i][j];
                p[i][j] = j;
            }
        }

        //计算
        for (int k = 0; k < row; k++) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    if (d[i][j]>(d[i][k]+d[k][j])){
                        d[i][j] = d[i][k]+d[k][j];
                        p[i][j] = p[i][k];//路径设置经过k
                    }
                }
            }
        }

        for (int i = 0; i < row; i++) {
            String s = Arrays.toString(d[i]);
            System.out.println(s);
        }
        System.out.println("------------------------");
        for (int i = 0; i < row; i++) {
            String s = Arrays.toString(p[i]);
            System.out.println(s);
        }
    }
}
