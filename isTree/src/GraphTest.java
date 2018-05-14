import org.junit.Assert;
import org.junit.Test;

public class GraphTest {

    int[][] g1 = {
            {0, 1, 1, 0, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {1, 0, 0, 1, 1, 1},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 1, 0, 0, 0}
    };
    int g2[][] = {
            {0, 1, 0, 0, 1, 0},
            {1, 0, 1, 1, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}
    };
    int g3[][] = {
            {0, 1, 1, 0},
            {1, 0, 1, 0},
            {1, 1, 0, 0},
            {0, 0, 0, 0}
    };
    int g4[][] = {
            {0, 1, 1, 0, 0},
            {1, 0, 1, 0, 0},
            {1, 1, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0}
    };
    int g5[][] = {
            {0, 1, 1, 0},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {0, 0, 0, 0}
    };
    int g6[][] = {
            {0, 1, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0}
    };

    @Test
    public void isTree1() {
        Graph graph = new Graph(g1);
        Assert.assertTrue(graph.isTree());
    }
    @Test
    public void isTree2() {
        Graph graph = new Graph(g2);
        Assert.assertFalse(graph.isTree());
    }
    @Test
    public void isTree3() {
        Graph graph = new Graph(g3);
        Assert.assertFalse(graph.isTree());
    }
    @Test
    public void isTree4() {
        Graph graph = new Graph(g4);
        Assert.assertFalse(graph.isTree());
    }
    @Test
    public void isTree5() {
        Graph graph = new Graph(g5);
        Assert.assertFalse(graph.isTree());
    }
    @Test
    public void isTree6() {
        Graph graph = new Graph(g6);
        Assert.assertFalse(graph.isTree());
    }
}
