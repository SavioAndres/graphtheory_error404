package main;

import java.util.HashSet;
import java.util.Set;
import graph.*;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class Main {

    Set<Vertice> vertices;
    Set<Aresta> arestas;

    Grafo grafo;

    Vertice v1;
    Vertice v2;
    Vertice v3;

    Aresta aresta1;
    Aresta aresta2;
    Aresta aresta3;


    @Before
    public void setUp(){
        vertices = new HashSet<>();
        arestas = new HashSet<>();

        v1 = new Vertice("v1");
        v2 = new Vertice("v2");
        v3 = new Vertice("v3");

        aresta1 = new Aresta(v1, v2, 0);
        aresta2 = new Aresta(v1, v3, 0);
        aresta3 = new Aresta(v3, v2, 0);

        vertices.add(v1);
        vertices.add(v2);
        vertices.add(v3);

        arestas.add(aresta1);
        arestas.add(aresta2);
        arestas.add(aresta3);

        grafo = new Grafo(vertices, arestas);
    }

    @Test
    public void testEhCompleto(){
        assertTrue(grafo.ehCompleto());
    }

    @Test
    public void testEhConexo(){
        assertFalse(grafo.ehConexo());
    }

    @Test
    public void testEhRegular(){
        assertTrue(grafo.ehRegular());
    }
}
