package graph.generator;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;
import graph.*;

public class GraphGenerator {

    private int quantidadeVertices;

    private int quantidadeArestas;

    private String[] letrasDosVertices;

    private Set<Vertice> vertices;

    private Random geradorNumeros;

    private Set<Aresta> arestas;

    private Grafo grafo;

    public GraphGenerator(int qntVertices, int qntArestas) {

        this.quantidadeVertices = qntVertices;

        this.quantidadeArestas = qntArestas;

        letrasDosVertices = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        geradorNumeros = new Random();

        vertices = gerarVertices(quantidadeVertices);

        arestas = gerarArestas(quantidadeArestas, vertices);

        grafo = new Grafo(vertices, arestas);
    }

    public Grafo getGrafo() {
        return grafo;
    }

    private Set<Vertice> gerarVertices(int quantidade) {

        Set<Vertice> novosVertices = new HashSet<Vertice>();

        for (int i = 0; i < quantidade; i++) {
            novosVertices.add( new Vertice(letrasDosVertices[i]));
        }

        return novosVertices;
    }

    private Set<Aresta> gerarArestas(int quantidade, Set<Vertice> vertices) {
        Set<Aresta> novasArestas = new HashSet<Aresta>();

        Vertice[] arrayVertices = vertices.toArray(new Vertice[vertices.size()]);

        Vertice verticeA;

        Vertice verticeB;

        for (int i = 0; i < quantidade; i++) {
            verticeA = arrayVertices[geradorNumeros.nextInt(arrayVertices.length) + 2];

            verticeB = arrayVertices[geradorNumeros.nextInt(arrayVertices.length) + 2];

            if (verticeA.equals(verticeB))
                continue;

            novasArestas.add(new Aresta(verticeA, verticeB, 0));
        }

        return novasArestas;
    }

}