/*Autores Savio e Taina*/

package graph.generator;

public class Vertice implements Comparable<Vertice> {

    private String nome;
    private boolean visitado;

    public Vertice(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public String toString() {
        return this.getNome();
    }

    public int compareTo(Vertice vertice) {
        return this.getNome().compareTo(vertice.getNome());
    }

}
