package cn.szt.experiment;

class OnlyOnions {
    boolean forSkewer() {
        return true;
    }
    boolean forOnion(Shish s) {
        return s.onlyOnions();
    }
    boolean forLamb(Shish s) {
        return false;
    }
    boolean forTomato(Shish s) {
        return false;
    }
}

class IsVegetarian {
    boolean forSkewer() {
        return true;
    }
    boolean forOnion(Shish s) {
        return s.onlyOnions();
    }
    boolean forLamb(Shish s) {
        return false;
    }
    boolean forTomato(Shish s) {
        return s.isVegetarian();
    }
}


abstract class Shish {
    OnlyOnions ooFn = new OnlyOnions();
    IsVegetarian ivFn = new IsVegetarian();

    abstract boolean onlyOnions();
    abstract boolean isVegetarian();
}

class Skewer extends Shish {
    @Override
    boolean onlyOnions() {
        return ooFn.forSkewer();
    }

    @Override
    boolean isVegetarian() {
        return ivFn.forSkewer();
    }
}

class Onion extends Shish {
    Shish s;

    Onion(Shish shish) {
        s = shish;
    }

    @Override
    boolean onlyOnions() {
        return ooFn.forOnion(s);
    }

    @Override
    boolean isVegetarian() {
        return ivFn.forOnion(s);
    }
}

class Lamb extends Shish {
    Shish s;

    Lamb(Shish shish) {
        s = shish;
    }

    @Override
    boolean onlyOnions() {
        return ooFn.forLamb(s);
    }

    @Override
    boolean isVegetarian() {
        return ivFn.forLamb(s);
    }
}

class Tomato extends Shish {
    Shish s;

    Tomato(Shish shish) {
        s = shish;
    }

    @Override
    boolean onlyOnions() {
        return ooFn.forTomato(s);
    }

    @Override
    boolean isVegetarian() {
        return ivFn.forTomato(s);
    }
}
