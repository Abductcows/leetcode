package utils;

import java.util.AbstractList;
import java.util.Comparator;
import java.util.RandomAccess;

class DangerList extends AbstractList<String> implements RandomAccess {

    final String[] arr;
    final int size;

    public DangerList(String[] arr, int size) {
        this.arr = arr;
        this.size = size;
    }

    public String get(int index) {
        return arr[index];
    }

    public int size() {
        return size;
    }

}
