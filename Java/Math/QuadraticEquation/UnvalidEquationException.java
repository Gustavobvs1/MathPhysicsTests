package QuadraticEquation;

public class UnvalidEquationException extends Exception {
    @Override
    public String getMessage() {
        return "Não é uma equação do segundo grau válida";
    }
}
