class Solution {
    public int fib(int n) {

        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }

        int a = 0;
        int b = 1;

        for (int i = 0; i < n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }

        return a;
    }
}