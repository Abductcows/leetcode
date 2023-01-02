public class Binary2DArray {


    public static final int MAX_SIZE = Long.SIZE;
    private final int size;

    private final long[] rows;
    private final long[] cols;

    public Binary2DArray(int size) {
        this.size = size;
        rows = new long[size];
        cols = new long[size];
    }

    public boolean set(int row, int col, boolean value) {
        checkIndex(row, size);
        checkIndex(col, size);
        boolean oldVal = (rows[row] & (Long.MIN_VALUE >>> col)) != 0;

        if (value) {
            rows[row] |= Long.MIN_VALUE >>> col;
            cols[col] |= Long.MIN_VALUE >>> row;
        } else {
            rows[row] &= ~(Long.MIN_VALUE >>> col);
            cols[col] &= ~(Long.MIN_VALUE >>> row);
        }
        return oldVal;
    }

    /*
     * Returns the contents of the argument row right-adjusted
     */
    public long getRow(int rowIndex) {
        return rows[rowIndex] >>> (MAX_SIZE - size);
    }

    public long getCol(int colIndex) {
        return cols[colIndex] >>> (MAX_SIZE - size);
    }

    public long getMainDiagonal() {
        long result = 0L;
        for (int i = 0; i < size; ++i) {
            result |= rows[i] & Long.MIN_VALUE >>> i;
        }
        return result >>> (MAX_SIZE - size);
    }

    public long getSecondaryDiagonal() {
        long result = 0L;
        for (int i = 0; i < size; ++i) {
            result |= rows[i] & Long.MIN_VALUE >>> size - 1 - i;
        }
        return result >>> (MAX_SIZE - size);
    }


    void checkIndex(int index, int maxExclusive) {

        if (index < 0 || index >= maxExclusive) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
    }

    public static void main(String[] args) {
        final int SIZE = 5;
        var a = new Binary2DArray(SIZE);
        for (int i = 0; i < SIZE; ++i) {
            a.set(2, i, true);
        }
        System.out.println("Rows");
        for (int i = 0; i < SIZE; ++i) {
            System.out.println(Long.toBinaryString(a.getRow(i)));
        }
        System.out.println("Cols");
        for (int i = 0; i < SIZE; ++i) {
            System.out.println(Long.toBinaryString(a.getCol(i)));
        }
    }
}
