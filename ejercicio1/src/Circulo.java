public class Circulo implements IFigura{
    private double diametro;
    double radio = diametro /2;

    public Circulo( double diametro ){
        this.diametro = diametro;
    }
    public double getDiametro(){
        return diametro;
    }

    @Override
    public void mostrarArea(){
        double formulaArea = Math.PI * Math.sqrt( radio );
        System.out.println( "Area Circulo: " + formulaArea );
    }
    @Override
    public void mostrarPerimetro(){
        double formulaPerimetro = 2 * Math.PI * (radio);
        System.out.println( "Perimetro Circulo:" + formulaPerimetro );
    }
}
