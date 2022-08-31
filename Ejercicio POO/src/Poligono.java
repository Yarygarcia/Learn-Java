public abstract class Poligono {
    protected int nLados;
    public Poligono(int nLados){
        this.nLados = nLados;
    }

    public int getnLados() {
        return nLados;
    }

    public String toString(){
        return "Lados: " + nLados;
    }
    public abstract String area();
}
