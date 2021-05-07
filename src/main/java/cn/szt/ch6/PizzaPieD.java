package cn.szt.ch6;

interface PizzaPieVisitorI {
    PizzaPieD forBottom();
    PizzaPieD forTopping(Object t, PizzaPieD r);
}

class RemoveV implements PizzaPieVisitorI {
    Object o;

    RemoveV(Object _o) {
        o = _o;
    }

    @Override
    public PizzaPieD forBottom() {
        return new Bottom();
    }

    @Override
    public PizzaPieD forTopping(Object t, PizzaPieD r) {
        if (o.equals(t)) {
            return r.accept(this);
        } else {
            return new Topping(t, r.accept(this));
        }
    }
}

class SubstitutionV extends SubstitutionD {

    SubstitutionV(Object _n, Object _o) {
        super(_n, _o);
    }

    @Override
    public PizzaPieD forTopping(Object t, PizzaPieD r) {
        if (o.equals(t)) {
            return new Topping(n, r.accept(this));
        } else {
            return new Topping(t, r.accept(this));
        }
    }
}

class LimitedSubstitutionV extends SubstitutionD {
    int c;

    LimitedSubstitutionV(int _c, Object _n, Object _o) {
        super(_n, _o);
        c = _c;
    }

    @Override
    public PizzaPieD forTopping(Object t, PizzaPieD r) {
        if (c == 0) {
            return new Topping(t, r);
        } else {
            if (o.equals(t)) {
                return new Topping(n, r.accept(new LimitedSubstitutionV(c-1, n, o)));
            } else {
                return new Topping(t, r.accept(this));
            }
        }
    }
}

abstract class PizzaPieD {
    abstract PizzaPieD accept(PizzaPieVisitorI ask);
}

class Bottom extends PizzaPieD {
    @Override
    public String toString() {
        return "new " + getClass().getName();
    }

    @Override
    PizzaPieD accept(PizzaPieVisitorI ask) {
        return ask.forBottom();
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
    PizzaPieD accept(PizzaPieVisitorI ask) {
        return ask.forTopping(t, r);
    }

    public static void main(String[] args) {
        PizzaPieD p = new Topping(new Salmon(), new Topping(new Anchovy(), new Topping(new Tuna(), new Bottom())));
        System.out.println("remove:");
        System.out.println(p);
        System.out.println(p.accept(new RemoveV(new Anchovy())));

        PizzaPieD p2 = new Topping(2, new Topping(3, new Topping(2, new Bottom())));
        System.out.println("remove:");
        System.out.println(p2);
        System.out.println(p2.accept(new RemoveV(3)));

        PizzaPieD p3 = new Topping(2, new Topping(new Tuna(), new Topping(new Zero(), new Bottom())));
        System.out.println("substitution:");
        System.out.println(p3);
        System.out.println(p3.accept(new SubstitutionV(0, new Zero())));

        PizzaPieD p4 = new Topping(1, new Topping(1, new Topping(1, new Bottom())));
        System.out.println("limited substitution:");
        System.out.println(p4);
        System.out.println(p4.accept(new LimitedSubstitutionV(2, 0, 1)));
    }
}
