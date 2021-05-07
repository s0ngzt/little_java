package cn.szt.ch7;

abstract class FruitD {
    @Override
    public String toString() {
        return "new " + getClass().getName();
    }
}

class Peach extends FruitD {
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Peach);
    }
}


class Apple extends FruitD {
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Apple);
    }
}

class Pear extends FruitD {
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Pear);
    }
}

class Lemon extends FruitD {
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Lemon);
    }
}

class Fig extends FruitD {
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Fig);
    }

    public static void main(String[] args) {
        Fig f = new Fig();
        System.out.println(f);
    }
}