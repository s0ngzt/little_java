package cn.szt.ch5;

class RemoveV {
    PizzaPieD forBottom() {
        return new Bottom();
    }
    PizzaPieD forTopping(Object t, PizzaPieD r, Object o) {
        if (o.equals(t)) {
            return r.remove(o);
        } else {
            return new Topping(t, r.remove(o));
        }
    }
}

class SubstV {
    PizzaPieD forBottom() {
        return new Bottom();
    }
    PizzaPieD forTopping(Object t, PizzaPieD r, Object n, Object o) {
        if (o.equals(t)) {
            return new Topping(n, r.subst(n, o));
        } else {
            return new Topping(t, r.subst(n, o));
        }
    }
}

abstract class PizzaPieD {
    RemoveV rmFn = new RemoveV();
    SubstV subFn = new SubstV();

    abstract PizzaPieD remove(Object o);
    abstract PizzaPieD subst(Object n, Object o);
}

class Bottom extends PizzaPieD {
    @Override
    public String toString() {
        return "new " + getClass().getName();
    }

    @Override
    PizzaPieD remove(Object o) {
        return rmFn.forBottom();
    }

    @Override
    PizzaPieD subst(Object n, Object o) {
        return subFn.forBottom();
    }
}

class Topping extends PizzaPieD {
    Object t;
    PizzaPieD r;

    Topping(Object obj, PizzaPieD pie) {
        t = obj;
        r = pie;
    }

    @Override
    public String toString() {
        return "new " + getClass().getName() + "(" + t + ", " + r + ")";
    }

    @Override
    PizzaPieD remove(Object o) {
        return rmFn.forTopping(t, r, o);
    }

    @Override
    PizzaPieD subst(Object n, Object o) {
        return subFn.forTopping(t, r, n, o);
    }

    public static void main(String[] args) {
        PizzaPieD p = new Topping(new Salmon(), new Topping(new Anchovy(), new Topping(new Tuna(), new Bottom())));
        System.out.println(p);
        System.out.println(p.remove(new Anchovy()));

        PizzaPieD p2 = new Topping(2, new Topping(3, new Topping(2, new Bottom())));
        System.out.println(p2);
        System.out.println(p2.remove(3));

        PizzaPieD p3 = new Topping(2, new Topping(new Tuna(), new Topping(new Zero(), new Bottom())));
        System.out.println(p3);
        System.out.println(p3.remove(new Zero()));
        System.out.println(p3.subst(0, new Zero()));
    }
}
