package cn.szt.ch5;

abstract class NumD {}

class Zero extends NumD {
    @Override
    public String toString() {
        return "new " + getClass().getName();
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Zero);
    }
}

class OneMoreThan extends NumD {
    NumD predecessor;

    OneMoreThan(NumD p) {
        predecessor = p;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof OneMoreThan) {
            return predecessor.equals(((OneMoreThan) o).predecessor);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "new " + getClass().getName() + "(" + predecessor + ")";
    }
}
