public class BoundedType {
    public <U extends Comparable<U>> int count(U[] arr, U limit) {
        int c = 0;
        for (U a : arr) {
            if (a.compareTo(limit) < 0)
                c++;
        }
        return c;
    }

    public interface I {
        public void doI();
    }

    public static class A {
        public void doA() {
            System.err.println("doing A");
        }
    }

    public static class B extends A implements I {
        @Override
        public void doI() {
            System.err.println("doing I");
        }
    }

    public <T extends  A & I> void select( T func) {
        func.doI();
        func.doA();
    }
    public void count(String a, String b) {}

    public static void main(String[] args) {
        BoundedType bt = new BoundedType();
        int c = bt.count(new Integer[] {0,1,2,3,4,5,6,7,8,9}, 2);
        System.err.println("count="+c);
        bt.select(new B());
//        bt.select(new A());
    }
}
