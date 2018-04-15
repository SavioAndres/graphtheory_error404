package graph;

import java.util.HashSet;
import java.util.Set;
import graph.interfaces.IGrafo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Grafo implements IGrafo {

    private Set<Vertice> visitados = new HashSet<Vertice>();
    private List<Vertice> explorados = new ArrayList<Vertice>();

    private Set<Vertice> vertices = new HashSet<Vertice>();
    private Set<Aresta> arestas = new HashSet<Aresta>();

    public Grafo(Set<Vertice> vertices, Set<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    @Override
    public boolean ehCompleto() {
        for (Vertice verticeAux : vertices) {
            if (getAdjacentes(verticeAux).size() == vertices.size() - 1) {

            } else {
                return false;
            }
        }
        return true;
    }

    @Override
    public Set<Vertice> getAdjacentes(Vertice v) {
        Set<Vertice> adjacentes = new HashSet<>();

        for (Aresta arestaAux : arestas) {
            if (arestaAux.getA().equals(v)) {
                adjacentes.add(arestaAux.getB());
            } else if (arestaAux.getB().equals(v)) {
                adjacentes.add(arestaAux.getA());
            }

        }
        return adjacentes;
    }

    @Override
    public boolean ehConexo() {

        for (Vertice verticeAux : vertices) {
            if (buscaProfundidade(verticeAux).size() == this.vertices.size()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean ehRegular() {
        for (Vertice verticeAux : vertices) {
            for (Vertice verticeAux2 : vertices) {
                if (getAdjacentes(verticeAux).size() == getAdjacentes(verticeAux2).size()) {

                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private Vertice getProximo(Set<Vertice> adjacentes) {

        Vertice verticeRetorno = null;

        for (Vertice v : adjacentes) {
            if (!v.isVisitado()) {
                verticeRetorno = v;
                break;
            }

        }
        return verticeRetorno;
    }

    public Vertice getNaoVisitado() {
        for (Vertice vertice : this.vertices) {
            if (vertice.isVisitado() == false) {
                return vertice;
            }
        }

        return null;
    }

    @Override
    public Set<Vertice> buscaProfundidade(Vertice vet) {
        Stack<Vertice> pilha = new Stack<>();
        vet.setVisitado(true);
        pilha.push(vet);

        while (!pilha.isEmpty()) {
            for (Vertice vetAux : vertices) {
                if (!(vetAux.isVisitado()) && this.getAdjacentes(vet) == vetAux) {
                    visitados.add(vetAux);
                    vetAux.setVisitado(true);
                    pilha.push(vetAux);
                }
            }

            this.explorados.add(pilha.lastElement());
            pilha.pop();
        }
        return visitados;
    }

    @Override
    public boolean buscaLargura(Vertice v) {
        Queue<Vertice> fila = new LinkedList<>();
        v.setVisitado(true);
        fila.add(v);
        Vertice u = null;
        while (!fila.isEmpty()) {
            u = fila.peek();
            fila.remove(u);
            for (Vertice verticeAux : vertices) {
                if (this.getAdjacentes(v) == verticeAux && !(verticeAux.isVisitado())) {
                    verticeAux.setVisitado(true);
                    fila.add(verticeAux);
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public void buscaProfundidade2(Vertice v) {
        Stack<Vertice> pilha = new Stack<>();
        v.setVisitado(true);
        pilha.push(v);
        
        while (!pilha.empty()) {
            Vertice w = getAdjacentes(pilha.firstElement()).iterator().next();
            while (!w.isVisitado()) {
                w.setVisitado(true);
                pilha.push(w);
            }
            pilha.remove(pilha.firstElement());
        }
    }
    
    @Override
    public void buscaLargura2(Vertice v) {
        Queue<Vertice> fila = new LinkedList<>();
        v.setVisitado(true);
        fila.add(v);
        
        while (!fila.isEmpty()) {            
            Vertice u = fila.poll();
            for (int i = 0; i < getAdjacentes(u).size(); i++) {
                Vertice w = getAdjacentes(u).iterator().next();
                if(!w.isVisitado()){
                    w.setVisitado(true);
                    fila.add(w);
                }
            }
        }
    }
    
    private Vertice getArestaPeso(Vertice v) {
        double peso = 233000;
        Vertice menorPeso = null;
        for (Vertice vertice : vertices) {
            for (Aresta aresta : arestas) {
                if (!vertice.isVisitado() && vertice == aresta.getA() || vertice == aresta.getB()) {
                    if (aresta.getPeso() < peso) {
                        peso = aresta.getPeso();
                        vertice.setVisitado(true);
                        if (aresta.getA() != v) {
                            menorPeso = aresta.getA();
                        } else {
                            menorPeso = aresta.getB();
                        }
                    }
                }
            }
        }
        return menorPeso;
    }
    
    @Override
    public String toString() {

        String retorno = "";

        for (Vertice v : vertices) {
            retorno += v.toString() + "[ ";

            Set<Vertice> adjacentes = this.getAdjacentes(v);

            for (Vertice adj : adjacentes) {
                retorno += adj.toString() + " ";
                if (adj.isVisitado()) {
                    retorno += "(*) ";
                } else {
                    retorno += "( ) ";
                }
            }

            retorno += "]\n";

        }

        retorno += "\n";
        retorno += "Ordem Visitados: " + this.visitados.size();
        retorno += "\n";
        retorno += "Ordem Explorados: " + this.explorados.size();

        return retorno;

    }
    
    //        String retorno = "";
//
//        for (Vertice v : vertices) {
//            retorno += v.toString() + "[ ";
//
//            Set<Vertice> adjacentes = this.getAdjacentes(v);
//
//            for (Vertice adj : adjacentes) {
//                retorno += adj.toString() + " ";
//            }
//
//            retorno += "]\n";
//
//        }
//
//        return retorno;
//    }


}
