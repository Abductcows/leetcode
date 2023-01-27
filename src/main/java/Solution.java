import java.util.*;

class OrderedStream {

    String[] values;

    public OrderedStream(int n) {
        values = new String[n];
    }

    public List<String> insert(int key, String value) {
        values[key - 1] = value;
        return new Haha(key);
    }

    class Haha extends AbstractList<String> implements RandomAccess {

        int start;
        String[] values;

        Haha(int start) {
            this.start = start;
            this.values = OrderedStream.this.values;
        }

        public String get(int index) {
            int i = start;
            while (index > 0) {
                if (values[i] != null) {
                    --index;
                }
                ++i;
            }
            while (values[i] == null) ++i;
            return values[i];
        }

        public int size() {
            return (int) Arrays.stream(values, start, values.length)
                    .filter(Objects::nonNull)
                    .count();
        }
    }
}