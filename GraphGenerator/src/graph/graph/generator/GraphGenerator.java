package graph.generator;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.List;
import java.util.LinkedList;

public class GraphGenerator {

    private int quantidadeVertices;

    private int quantidadeArestas;

    private String[] letrasDosVertices;

    private Set<Vertice> vertices;

    private Set<Aresta> arestas;

    private Random geradorNumeros;

    public GraphGenerator() {

        geradorNumeros = new Random();

        quantidadeVertices = geradorNumeros.nextInt(26) + 2;

        quantidadeArestas = geradorNumeros.nextInt(50) + 1;

        this(quantidadeVertices, quantidadeArestas);
    }

    public GraphGenerator(int quantidadeVertices, int quantidadeArestas) {

        letrasDosVertices = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

        vertices = gerarVertices(quantidadeVertices);

        arestas = gerarArestas(quantidadeArestas, vertices);
    }

    public Grafo getGrafo(Set<Vertice> vertices, Set<Aresta> arestas) {

    }

    private Set<Vertice> gerarVertices(int quantidade) {

        Set<Vertice> novosVertices = new HashSet<Vertice>();

        for (int x = 0; i < quantidade; i++) {
            novosVertices.add( new Vertice(letrasDosVertices[i]))
        }

        return novosVertices;
    }

    private Set<Aresta> gerarArestas(int quantidade, Set<Vertice> vertices) {
        Set<Aresta> novasArestas = new HashSet<Aresta>();

        Vertice verticeA;

        Vertice verticeB;

        for (int i = 0; i < quantidade; i++) {
            verticeA = vertices.get(geradorNumeros.nextInt(vertices.size()) + 2);

            verticeB = vertices.get(geradorNumeros.nextInt(vertices.size()) + 2);

            if (verticeA.equals(verticeB))
                continue;

            novasArestas.add(verticeA, verticeB, 0);
        }

        return novasArestas;
    }

}