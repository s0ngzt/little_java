package cn.szt.experiment;

abstract class Kebab {
    abstract boolean isVeggie();
    abstract Object whatHolder();
}

class Holder extends Kebab {
    Object o;

    Holder(Object obj) {
        o = obj;
    }

    @Override
    boolean isVeggie() {
        return true;
    }

    @Override
    Object whatHolder() {
        return o;
    }
}

class Shallot extends Kebab {
    Kebab k;

    Shallot(Kebab kebab) {
        k = kebab;
    }

    @Override
    boolean isVeggie() {
        return k.isVeggie();
    }

    @Override
    Object whatHolder() {
        return k.whatHolder();
    }
}

class Shrimp extends Kebab {
    Kebab k;

    Shrimp(Kebab kebab) {
        k = kebab;
    }

    @Override
    boolean isVeggie() {
        return false;
    }

    @Override
    Object whatHolder() {
        return k.whatHolder();
    }
}

class Radish extends Kebab {
    Kebab k;

    Radish(Kebab kebab) {
        k = kebab;
    }

    @Override
    boolean isVeggie() {
        return k.isVeggie();
    }

    @Override
    Object whatHolder() {
        return k.whatHolder();
    }
}

class Pepper extends Kebab {
    Kebab k;

    Pepper(Kebab kebab) {
        k = kebab;
    }

    @Override
    boolean isVeggie() {
        return k.isVeggie();
    }

    @Override
    Object whatHolder() {
        return k.whatHolder();
    }
}

class Zucchini extends Kebab {
    Kebab k;

    Zucchini(Kebab kebab) {
        k = kebab;
    }

    @Override
    boolean isVeggie() {
        return k.isVeggie();
    }

    @Override
    Object whatHolder() {
        return k.whatHolder();
    }
}
