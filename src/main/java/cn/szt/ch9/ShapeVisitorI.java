package cn.szt.ch9;

interface ShapeVisitorI {
    boolean forCircle(int r);
    boolean forSquare(int s);
    boolean forTrans(PointD q, ShapeD s);
}

interface UnionVisitorI extends ShapeVisitorI {
    boolean forUnion(ShapeD s, ShapeD t);
}

class HasPtV implements ShapeVisitorI {
    PointD p;
    HasPtV(PointD _p) {
        p = _p;
    }

    ShapeVisitorI newHasPtV(PointD p) {
        return new HasPtV(p);
    }

    @Override
    public boolean forCircle(int r) {
        return p.distanceToO() <= r;
    }

    @Override
    public boolean forSquare(int s) {
        return p.x <= s && p.y <= s;
    }

    @Override
    public boolean forTrans(PointD q, ShapeD s) {
        return s.accept(newHasPtV(p.minus(q)));
    }
}

class UnionHasPtV extends HasPtV implements UnionVisitorI {

    UnionHasPtV(PointD _p) {
        super(_p);
    }

    @Override
    ShapeVisitorI newHasPtV(PointD p) {
        return new UnionHasPtV(p);
    }

    public boolean forUnion(ShapeD s, ShapeD t) {
        return s.accept(this) || t.accept(this);
    }
}
