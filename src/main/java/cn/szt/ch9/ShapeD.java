package cn.szt.ch9;

abstract class ShapeD {
    abstract boolean accept(ShapeVisitorI ask);
}

class Circle extends ShapeD {
    int r;
    Circle(int _r) {
        r = _r;
    }

    @Override
    boolean accept(ShapeVisitorI ask) {
        return ask.forCircle(r);
    }
}

class Square extends ShapeD {
    int s;
    Square(int _s) {
        s = _s;
    }

    @Override
    boolean accept(ShapeVisitorI ask) {
        return ask.forSquare(s);
    }
}

class Translation extends ShapeD {
    PointD q;
    ShapeD s;

    Translation(PointD _q, ShapeD _s) {
        q = _q;
        s = _s;
    }

    @Override
    boolean accept(ShapeVisitorI ask) {
        return ask.forTrans(q, s);
    }
}

class Union extends ShapeD {
    ShapeD s;
    ShapeD t;
    Union(ShapeD _s, ShapeD _t) {
        s = _s;
        t = _t;
    }

    @Override
    boolean accept(ShapeVisitorI ask) {
        return ((UnionVisitorI)ask).forUnion(s, t);
    }

    public static void main(String[] args) {
        ShapeD s = new Translation(new CartesianPt(3, 7),
                new Union(new Square(10), new Circle(10)));
        System.out.println(s.accept(new UnionHasPtV(new CartesianPt(13, 17))));
    }
}
