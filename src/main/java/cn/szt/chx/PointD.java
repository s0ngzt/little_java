package cn.szt.chx;

abstract class PointD {
    int x;
    int y;

    PointD(int _x, int _y) {
        x = _x;
        y = _y;
    }

    abstract int distanceToO();

    boolean closerToO(PointD p) {
        return distanceToO() <= p.distanceToO();
    }

    PointD minus(PointD q) {
        return new CartesianPt(x - q.x, y - q.y);
    }

    int moveBy(int dx, int dy) {
        x = x + dx;
        y = y + dy;
        return distanceToO();
    }
}

class CartesianPt extends PointD {
    CartesianPt(int x1, int y1) {
        super(x1, y1);
    }

    @Override
    int distanceToO() {
        return (int) Math.sqrt(x * x + y * y);
    }
}

class ManhattanPt extends PointD {

    ManhattanPt(int x1, int y1) {
        super(x1, y1);
    }

    @Override
    int distanceToO() {
        return x + y;
    }
}

class ShadowedManhattanPt extends ManhattanPt {
    int deltaX;
    int deltaY;

    ShadowedManhattanPt(int x1, int y1, int xd, int yd) {
        super(x1, y1);
        deltaX = xd;
        deltaY = yd;
    }

    @Override
    int distanceToO() {
        return super.distanceToO() + deltaX + deltaY;
    }
}
