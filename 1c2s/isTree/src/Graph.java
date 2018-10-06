public class Graph {
    private int matrix[][];
    private int vertexAmount;

    Graph(int[][] m) {
        this.matrix = m;
        vertexAmount = 0;
    }

    public boolean isTree() {
        return dfs(0, 0, new int[matrix.length]) && (matrix.length == vertexAmount);
    }

    private boolean dfs(int v, int p, int color[]) {
        vertexAmount++;
        color[v]++;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[v][i] == 1 && i != p) {
                if (color[i] > 0) return false;
                if (!dfs(i,v,color)) return false;
            }
        }
        color[v]--;
        return true;
    }

}
