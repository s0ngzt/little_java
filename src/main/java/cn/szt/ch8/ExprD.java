package cn.szt.ch8;

interface ExprVisitorI {
    Object forPlus(ExprD l, ExprD r);
    Object forDiff(ExprD l, ExprD r);
    Object forProd(ExprD l, ExprD r);
    Object forConst(Object c);
}

abstract class ExprD {
    abstract Object accept(ExprVisitorI ask);
}

class Plus extends ExprD {
    ExprD l;
    ExprD r;
    Plus(ExprD _l, ExprD _r) {
        l = _l;
        r = _r;
    }

    Object accept(ExprVisitorI ask) {
        return ask.forPlus(l, r);
    }
}

class Diff extends ExprD {
    ExprD l;
    ExprD r;
    Diff(ExprD _l, ExprD _r) {
        l = _l;
        r = _r;
    }

    Object accept(ExprVisitorI ask) {
        return ask.forDiff(l, r);
    }
}

class Prod extends ExprD {
    ExprD l;
    ExprD r;
    Prod(ExprD _l, ExprD _r) {
        l = _l;
        r = _r;
    }

    Object accept(ExprVisitorI ask) {
        return ask.forProd(l, r);
    }
}

class Const extends ExprD {
    Object c;
    Const(Object _c) {
        c = _c;
    }

    @Override
    Object accept(ExprVisitorI ask) {
        return ask.forConst(c);
    }
}

class IntEvalV extends EvalD {
    Object plus(Object l, Object r) {
        return (Integer) l + (Integer) r;
    }

    Object diff(Object l, Object r) {
        return (Integer) l - (Integer) r;
    }

    Object prod(Object l, Object r) {
        return (Integer) l * (Integer) r;
    }
}