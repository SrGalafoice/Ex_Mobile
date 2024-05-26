package br.edu.fateczl.atividade10.Controller;

import br.edu.fateczl.atividade10.Retangulo;

public class RetanguloController implements IGeometriaController<Retangulo>{
    @Override
    public float calcArea(Retangulo retangulo) {
        float Area = retangulo.getBase() * retangulo.getAltura();
        return Area;
    }

    @Override
    public float calcPerimetro(Retangulo retangulo) {
        float Perimetro = (retangulo.getAltura() + retangulo.getBase()) * 2;
        return Perimetro;
    }
}
