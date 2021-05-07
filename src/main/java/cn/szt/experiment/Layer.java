package cn.szt.experiment;

abstract class Layer {}

class Base extends Layer {
    Object o;

    Base(Object obj) {
        o = obj;
    }

    @Override
    public String toString() {
        return "new " + getClass().getName() + "(" + o + ")";
    }
}

class Slice extends Layer {
    Layer l;

    Slice(Layer layer) {
        l = layer;
    }

    @Override
    public String toString() {
        return "new " + getClass().getName() + "(" + l + ")";
    }

    public static void main(String[] args) {
        System.out.println(new Zero());
        System.out.println(new Base(new Zero()));
        System.out.println(new Slice(new Base(new Zero())));
    }
}
