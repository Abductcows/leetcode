package utils;

import java.util.NoSuchElementException;

class MinHeap {

    static final int DEFAULT_SIZE = 64;
    int[] data;
    int elements;


    public MinHeap() {
        this(new int[DEFAULT_SIZE], 0);
    }

    public MinHeap(int[] data) {
        this(data, data.length);
    }

    public MinHeap(int[] data, int elements) {
        this.data = data;
        this.elements = elements;
        buildHeap();
    }

    void add(int e) {
        ensureCapacity();
        data[elements] = e;
        heapifyUp(elements++);
    }

    int pop() {
        if (elements == 0) throw new NoSuchElementException();
        int res = data[0];
        data[0] = data[--elements];
        heapifyDown(0);
        return res;
    }

    int size() {
        return elements;
    }

    void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (data[index] >= data[parentIndex]) break;

            int temp = data[index];
            data[index] = data[parentIndex];
            data[parentIndex] = temp;

            index = parentIndex;
        }
    }

    void heapifyDown(int index) {

        int bothChildrenLoops = -1 - (31 ^ Integer.numberOfLeadingZeros(index + 1)) + (31 ^ Integer.numberOfLeadingZeros(elements + 1));

        for (int i = 0; i < bothChildrenLoops; ++i) {
            int leftChild = 2 * index + 1;
            int minChild = data[leftChild] < data[leftChild + 1] ? leftChild : leftChild + 1;
            if (data[minChild] >= data[index]) return;

            int temp = data[index];
            data[index] = data[minChild];
            data[minChild] = temp;
            index = minChild;
        }

        int leftChild = 2 * index + 1;
        if (leftChild < elements) {
            int minChild;
            if (leftChild + 1 < elements) {
                minChild = data[leftChild] < data[leftChild + 1] ? leftChild : leftChild + 1;
            } else {
                minChild = leftChild;
            }
            if (data[minChild] >= data[index]) return;

            int temp = data[index];
            data[index] = data[minChild];
            data[minChild] = temp;
        }
    }

    void buildHeap() {
        if (elements <= 1) return;
        int start = -2 + (1 << (31 ^ Integer.numberOfLeadingZeros(elements)));

        for (int i = start; i >= 0; --i) heapifyDown(i);
    }


    void ensureCapacity() {
        if (elements < data.length) return;
        if (elements == Integer.MAX_VALUE) throw new IllegalStateException("Heap completely full. Size = " + elements);
        int newLength = (int) Math.min(2L * elements, Integer.MAX_VALUE);
        int[] newData = new int[newLength];
        System.arraycopy(data, 0, newData, 0, elements);
        data = newData;
    }
}
