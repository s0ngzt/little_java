package cn.szt.experiment;

abstract class Point {
    int x;
    int y;

    Point(int _x, int _y) {
        x = _x;
        y = _y;
    }

    abstract int distanceToO();

    boolean closerToO(Point p) {
        return distanceToO() <= p.distanceToO();
    }
}

class CartesianPt extends Point {
    CartesianPt(int x1, int y1) {
        super(x1, y1);
    }

    @Override
    int distanceToO() {
        return (int) Math.sqrt(x * x + y * y);
    }
}

class ManhattanPt extends Point {

    ManhattanPt(int x1, int y1) {
        super(x1, y1);
    }

    @Override
    int distanceToO() {
        return x + y;
    }

    public static void main(String[] args) {
        System.out.println(new CartesianPt(3, 4).distanceToO());
        System.out.println(new ManhattanPt(3, 4).distanceToO());
        System.out.println(new ManhattanPt(3, 4).closerToO(new CartesianPt(3, 4)));
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

class ShadowedCartesianPt extends CartesianPt {
    int deltaX;
    int deltaY;

    ShadowedCartesianPt(int x1, int y1, int xd, int yd) {
        super(x1, y1);
        deltaX = xd;
        deltaY = yd;
    }

    @Override
    int distanceToO() {
        return new CartesianPt(x + deltaX, y + deltaY).distanceToO();
    }
}
