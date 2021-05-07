package cn.szt.chx;

interface PizzaPieVisitorI {
    Object forBottom(Bottom that);
    Object forTopping(Topping that);
}

class RemoveV implements PizzaPieVisitorI {
    Object o;

    RemoveV(Object _o) {
        o = _o;
    }

    @Override
    public Object forBottom(Bottom that) {
        return new Bottom();
    }

    @Override
    public Object forTopping(Topping that) {
        if (o.equals(that.t)) {
            return that.r.accept(this);
        } else {
            return new Topping(that.t, (PizzaPieD) that.r.accept(this));
        }
    }
}

class SubstitutionV implements PizzaPieVisitorI {
    Object n;
    Object o;

    SubstitutionV(Object _n, Object _o) {
        n = _n;
        o = _o;
    }

    @Override
    public Object forBottom(Bottom that) {
        return that;
    }

    @Override
    public Object forTopping(Topping that) {
        if (o.equals(that.t)) {
            that.t = n;
        }
        that.r.accept(this);
        return that;
    }
}

class OccursV implements PizzaPieVisitorI {
    Object a;
    OccursV(Object _a) {
        a = _a;
    }

    @Override
    public Object forBottom(Bottom that) {
        return 0;
    }

    @Override
    public Object forTopping(Topping that) {
        if(that.t.equals(a)) {
            return 1 + (Integer) that.r.accept(this);
        } else {
            return that.r.accept(this);
        }
    }
}

abstract class PizzaPieD {
    abstract Object accept(PizzaPieVisitorI ask);
}

class Bottom extends PizzaPieD {
    @Override
    public String toString() {
        return "new " + getClass().getName();
    }

    @Override
    Object accept(PizzaPieVisitorI ask) {
        return ask.forBottom(this);
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
    Object accept(PizzaPieVisitorI ask) {
        return ask.forTopping(this);
    }
}
