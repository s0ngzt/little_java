package cn.szt.experiment;

class HelloWorld {
    int field1;
    int field2;

    @Override
    public String toString() {
        return "new " + getClass().getName() + "(" + field1 + ", " + field2 + ")";
    }

    public static void main(String[] args) {
        var hello = new HelloWorld();
        hello.field1 = 0;
        hello.field2 = 1;
        System.out.println(hello);
    }
}
