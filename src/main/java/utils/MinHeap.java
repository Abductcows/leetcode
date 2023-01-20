package utils;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {

    public static final int DEFAULT_SIZE = 64;
    public int[] data;
    public int elements;

    public MinHeap() {
        this(DEFAULT_SIZE);
    }

    public MinHeap(int initialSize) {
        this(new int[initialSize], 0);
    }

    public MinHeap(int[] data) {
        this(data, data.length);
    }

    public MinHeap(int[] data, int elements) {
        this.data = data;
        this.elements = elements;
        buildHeap();
    }

    public void add(int e) {
        ensureCapacity();
        data[elements] = e;
        heapifyUp(elements++);
    }

    public int pop() {
        if (elements == 0) throw new NoSuchElementException();
        int res = data[0];
        data[0] = data[--elements];
        heapifyDown(0);
        return res;
    }

    public int size() {
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

        int bothChildrenLoops = -1 + Integer.numberOfLeadingZeros(index + 1) - Integer.numberOfLeadingZeros(elements + 1);

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

    public void buildHeap() {
        if (elements <= 1) return;

        int start = -2 + (1 << (31 ^ Integer.numberOfLeadingZeros(elements)));
        for (int i = start; i >= 0; --i) heapifyDown(i);
    }

    void ensureCapacity() {
        if (elements < data.length) return;
        if (elements == Integer.MAX_VALUE) throw new IllegalStateException("Heap completely full. Size = " + elements);
        int newLength = (int) Math.min(2L * elements, Integer.MAX_VALUE);
        data = Arrays.copyOf(data, newLength);
    }

    /**
     * This kills the heap
     */
    public int[] heapSort() {
        int[] result = new int[elements];
        for (int i = 0, n = elements; i < n; ++i) result[i] = pop();
        return result;
    }
}

