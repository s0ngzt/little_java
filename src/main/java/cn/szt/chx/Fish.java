package cn.szt.chx;

abstract class Fish {
    @Override
    public String toString() {
        return "new " + getClass().getName();
    }
}

class Anchovy extends Fish {
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Anchovy);
    }
}

class Salmon extends Fish {
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Salmon);
    }
}

class Tuna extends Fish {
    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Tuna);
    }
}
