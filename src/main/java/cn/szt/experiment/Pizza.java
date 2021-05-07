package cn.szt.experiment;

import java.util.Currency;

class RemoveAnchovy {
    Pizza forCrust() {
        return new Crust();
    }
    Pizza forCheese(Pizza p) {
        return new Cheese(p.removeAnchovy());
    }
    Pizza forOlive(Pizza p) {
        return new Olive(p.removeAnchovy());
    }
    Pizza forAnchovy(Pizza p) {
        return p.removeAnchovy();
    }
    Pizza forSausage(Pizza p) {
        return new Sausage(p.removeAnchovy());
    }
}

class TopAnchovyWithCheese {
    Pizza forCrust() {
        return new Crust();
    }
    Pizza forCheese(Pizza p) {
        return new Cheese(p.topAnchovyWithCheese());
    }
    Pizza forOlive(Pizza p) {
        return new Olive(p.topAnchovyWithCheese());
    }
    Pizza forAnchovy(Pizza p) {
        return new Cheese(new Anchovy(p.topAnchovyWithCheese()));
    }
    Pizza forSausage(Pizza p) {
        return new Sausage(p.topAnchovyWithCheese());
    }
}

class SubstituteAnchovyByCheese {
    Pizza forCrust() {
        return new Crust();
    }
    Pizza forCheese(Pizza p) {
        return new Cheese(p.substituteAnchovyByCheese());
    }
    Pizza forOlive(Pizza p) {
        return new Olive(p.substituteAnchovyByCheese());
    }
    Pizza forAnchovy(Pizza p) {
        return new Cheese(p.substituteAnchovyByCheese());
    }
    Pizza forSausage(Pizza p) {
        return new Sausage(p.substituteAnchovyByCheese());
    }
}

abstract class Pizza {
    RemoveAnchovy raFn = new RemoveAnchovy();
    TopAnchovyWithCheese tawcFn = new TopAnchovyWithCheese();
    SubstituteAnchovyByCheese sabcFn = new SubstituteAnchovyByCheese();
    abstract Pizza removeAnchovy();
    abstract Pizza topAnchovyWithCheese();
    abstract Pizza substituteAnchovyByCheese();
}

class Crust extends Pizza {
    @Override
    Pizza removeAnchovy() {
        return raFn.forCrust();
    }

    @Override
    Pizza topAnchovyWithCheese() {
        return tawcFn.forCrust();
    }

    @Override
    Pizza substituteAnchovyByCheese() {
        return sabcFn.forCrust();
    }
}

class Cheese extends Pizza {
    Pizza p;

    Cheese(Pizza pizza) {
        p = pizza;
    }

    @Override
    Pizza removeAnchovy() {
        return raFn.forCheese(p);
    }

    @Override
    Pizza topAnchovyWithCheese() {
        return tawcFn.forCheese(p);
    }

    @Override
    Pizza substituteAnchovyByCheese() {
        return sabcFn.forCheese(p);
    }
}

class Olive extends Pizza {
    Pizza p;

    Olive(Pizza pizza) {
        p = pizza;
    }

    @Override
    Pizza removeAnchovy() {
        return raFn.forOlive(p);
    }

    @Override
    Pizza topAnchovyWithCheese() {
        return tawcFn.forOlive(p);
    }

    @Override
    Pizza substituteAnchovyByCheese() {
        return sabcFn.forOlive(p);
    }
}

class Anchovy extends Pizza {
    Pizza p;

    Anchovy(Pizza pizza) {
        p = pizza;
    }

    @Override
    Pizza removeAnchovy() {
        return raFn.forAnchovy(p);
    }

    @Override
    Pizza topAnchovyWithCheese() {
        return tawcFn.forAnchovy(p);
    }

    @Override
    Pizza substituteAnchovyByCheese() {
        return sabcFn.forAnchovy(p);
    }
}

class Sausage extends Pizza {
    Pizza p;

    Sausage(Pizza pizza) {
        p = pizza;
    }

    @Override
    Pizza removeAnchovy() {
        return raFn.forSausage(p);
    }

    @Override
    Pizza topAnchovyWithCheese() {
        return tawcFn.forSausage(p);
    }

    @Override
    Pizza substituteAnchovyByCheese() {
        return sabcFn.forSausage(p);
    }
}
