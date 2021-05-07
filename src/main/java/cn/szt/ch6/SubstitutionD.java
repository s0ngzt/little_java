package cn.szt.ch6;

abstract class SubstitutionD implements PizzaPieVisitorI {

    Object n;
    Object o;

    SubstitutionD(Object _n, Object _o) {
        n = _n;
        o = _o;
    }

    @Override
    public PizzaPieD forBottom() {
        return new Bottom();
    }

    public abstract PizzaPieD forTopping(Object t, PizzaPieD r);
}
