package utils;

class FastIntQueue {
    static final int SIZE = 1 << 8;

    int head = 0, tail = SIZE - 1;
    int[] data = new int[SIZE];

    void reset() {
        head = 0;
        tail = SIZE - 1;
    }

    void add(int e) {
        tail = tail + 1 & SIZE - 1;
        data[tail] = e;
    }

    int poll() {
        int e = data[head];
        head = head + 1 & SIZE - 1;
        return e;
    }
}
