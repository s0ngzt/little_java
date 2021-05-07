package cn.szt.experiment;

abstract class Num {}

class Zero extends Num {
    @Override
    public String toString() {
        return "new " + getClass().getName();
    }
}

class OneMoreThan extends Num {
    Num predecessor;

    OneMoreThan(Num p) {
        predecessor = p;
    }

    @Override
    public String toString() {
        return "new " + getClass().getName() + "(" + predecessor + ")";
    }

    public static void main(String[] args) {
        System.out.println(new Zero());
        System.out.println(new OneMoreThan(new Zero()));
        System.out.println(new OneMoreThan(new OneMoreThan(new Zero())));
    }
}