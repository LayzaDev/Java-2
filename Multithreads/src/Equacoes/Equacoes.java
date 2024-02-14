package Equacoes;

import static java.lang.Math.sqrt;
import java.util.ArrayList;


// * a = #4321
// * b = #1234
// * c = #4234


public class Equacoes implements Runnable {

    private static double a, b, c;
    private static double x1, x2, delta;

    public static double calculaDelta() {
        return b * b - 4 * a * c;
    }

    public static String calculaRaizes(double a, double b, double c) {
        Equacoes.a = a;
        Equacoes.b = b;
        Equacoes.c = c;
        
        delta = calculaDelta();
        String result = "";

        if (delta >= 0) {
            x1 = (float) ((-b + Math.sqrt(delta)) / 2 * a);
            x2 = (float) ((-b - Math.sqrt(delta)) / 2 * a);

            result += "\n f(x)= " + a + "x² + (" + b + "x) + (" + c + ")"
                    + "\nΔ = " + delta
                    + "\nx1 = " + x1
                    + "\nx2 = " + x2;

        } else {
            result = "\n**** Erro: Delta negativo!****\n";
        }
        
        return result;
    }

    @Override
    public void run() {
        System.out.println(calculaRaizes(a, b, c));
    }
}
