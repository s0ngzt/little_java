package cn.szt.ch7;

interface TreeVisitorI {
    Object forBud();

    Object forFlat(FruitD f, TreeD t);

    Object forSplit(TreeD l, TreeD r);
}

class IsFlatV implements TreeVisitorI {

    @Override
    public Object forBud() {
        return Boolean.TRUE;
    }

    @Override
    public Object forFlat(FruitD f, TreeD t) {
        return t.accept(this);
    }

    @Override
    public Object forSplit(TreeD l, TreeD r) {
        return Boolean.FALSE;
    }
}

class IsSplitV implements TreeVisitorI {

    @Override
    public Object forBud() {
        return Boolean.TRUE;
    }

    @Override
    public Object forFlat(FruitD f, TreeD t) {
        return Boolean.FALSE;
    }

    @Override
    public Object forSplit(TreeD l, TreeD r) {
        if ((Boolean) (l.accept(this))) {
            return r.accept(this);
        } else {
            return Boolean.FALSE;
        }
    }
}

class HasFruitV implements TreeVisitorI {

    @Override
    public Object forBud() {
        return Boolean.FALSE;
    }

    @Override
    public Object forFlat(FruitD f, TreeD t) {
        return Boolean.TRUE;
    }

    @Override
    public Object forSplit(TreeD l, TreeD r) {
        if ((Boolean) (l.accept(this))) {
            return Boolean.TRUE;
        } else {
            return r.accept(this);
        }
    }
}

class HeightV implements TreeVisitorI {

    @Override
    public Object forBud() {
        return 0;
    }

    @Override
    public Object forFlat(FruitD f, TreeD t) {
        return (Integer) t.accept(this) + 1;
    }

    @Override
    public Object forSplit(TreeD l, TreeD r) {
        return Math.max((Integer) l.accept(this), (Integer) r.accept(this)) + 1;
    }
}

class OccursV implements TreeVisitorI {
    FruitD o;

    OccursV(FruitD _o) {
        o = _o;
    }

    @Override
    public Object forBud() {
        return 0;
    }

    @Override
    public Object forFlat(FruitD f, TreeD t) {
        if(f.equals(o)) {
            return 1 + (Integer) t.accept(this);
        } else {
            return t.accept(this);
        }
    }

    @Override
    public Object forSplit(TreeD l, TreeD r) {
        return (Integer) l.accept(this) + (Integer) r.accept(this);
    }
}

class SubstitutionV implements TreeVisitorI {
    FruitD n;
    FruitD o;

    SubstitutionV(FruitD _n, FruitD _o) {
        n = _n;
        o = _o;
    }

    @Override
    public Object forBud() {
        return new Bud();
    }

    @Override
    public TreeD forFlat(FruitD f, TreeD t) {
        if (o.equals(f)) {
            return new Flat(n, (TreeD) t.accept(this));
        } else {
            return new Flat(f, (TreeD) t.accept(this));
        }
    }

    @Override
    public TreeD forSplit(TreeD l, TreeD r) {
        return new Split((TreeD) l.accept(this), (TreeD) r.accept(this));
    }
}

abstract class TreeD {
    abstract Object accept(TreeVisitorI ask);
}

class Bud extends TreeD {
    @Override
    Object accept(TreeVisitorI ask) {
        return ask.forBud();
    }

    @Override
    public String toString() {
        return "new " + getClass().getName();
    }
}

class Flat extends TreeD {
    FruitD f;
    TreeD t;

    Flat(FruitD _f, TreeD _t) {
        f = _f;
        t = _t;
    }

    @Override
    Object accept(TreeVisitorI ask) {
        return ask.forFlat(f, t);
    }

    @Override
    public String toString() {
        return "new " + getClass().getName() + "(" + f + ", " + t + ")";
    }
}

class Split extends TreeD {
    TreeD l;
    TreeD r;

    Split(TreeD _l, TreeD _r) {
        l = _l;
        r = _r;
    }

    @Override
    Object accept(TreeVisitorI ask) {
        return ask.forSplit(l, r);
    }

    @Override
    public String toString() {
        return "new " + getClass().getName() + "(" + l + ", " + r + ")";
    }

    public static void main(String[] args) {
        TreeD t = new Split(
                new Split(new Bud(), new Bud()),
                new Flat(new Fig(), new Flat(new Lemon(), new Flat(new Apple(), new Bud())))
        );
        System.out.printf("hasFruit: %b\n", t.accept(new HasFruitV()));
        System.out.printf("isSplit: %b\n", t.accept(new IsSplitV()));
        System.out.println("subst lemon with apple:");
        System.out.println(t);
        System.out.println(t.accept(new SubstitutionV(new Apple(), new Lemon())));
    }
}