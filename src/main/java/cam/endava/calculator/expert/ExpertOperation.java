package cam.endava.calculator.expert;

import cam.endava.calculator.basic.BasicOperation;

public interface ExpertOperation extends BasicOperation {

    abstract double pow(int base, int exponent);
    abstract double root(int a);
    abstract double rootmax(int base, int exponent);
    abstract long fact(int n);
    abstract long factRec(int n);
    abstract double calculate(String s);

}
