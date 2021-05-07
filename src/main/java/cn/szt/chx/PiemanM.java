package cn.szt.chx;


class PiemanM implements PiemanI {
    PizzaPieD p = new Bottom();

    @Override
    public int addTop(Object t) {
        p = new Topping(t, p);
        return occTop(t);
    }

    @Override
    public int removeTop(Object t) {
        p = (PizzaPieD) p.accept(new RemoveV(t));
        return occTop(t);
    }

    @Override
    public int substituteTop(Object n, Object o) {
        p = (PizzaPieD) p.accept(new SubstitutionV(n ,o));
        return occTop(n);
    }

    @Override
    public int occTop(Object o) {
        return (int) p.accept(new OccursV(o));
    }
}
