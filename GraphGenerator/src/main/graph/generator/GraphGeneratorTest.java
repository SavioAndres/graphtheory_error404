package graph.generator;

import java.util.HashSet;
import java.util.Set;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class GraphGeneratorTest {

    GraphGenerator grafoGerador;

    Grafo grafo;

    @Before
    public void setUp(){

        grafoGerador = new GraphGenerator(5, 10);

        grafo = grafoGerador.getGrafo();
    }

    @Test
    public void testEhCompleto(){
        assertFalse(grafo.ehCompleto());
    }

    @Test
    public void testEhConexo(){
        assertFalse(grafo.ehConexo());
    }

    @Test
    public void testEhRegular(){
        assertFalse(grafo.ehRegular());
    }
}
