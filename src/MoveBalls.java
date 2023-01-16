import java.util.Arrays;

class SolutionTODO {

    // todo
    public int[] minOperations(String bs) {

        byte[] boxes = bs.getBytes();
        final int n = boxes.length;
        int[] result = new int[n];

        int oneCount = 0;
        for (int i = 0; i < n - 1; ++i) {
            int val = boxes[i] - '0';
            oneCount += val;
            result[0] += val * i;
            result[n - 1] += oneCount;
        }
        oneCount += boxes[n - 1] - '0';
        result[0] += (boxes[n - 1] - '0') * (n - 1);

        int left = boxes[0] - '0', right = oneCount - left;
        for (int i = 1; i < n - 1; ++i) {
            result[i] = result[i - 1] - right + left;
            left += boxes[i] - '0';
            right -= boxes[i + 1] - '0';
        }

        return result;
    }

    public static void main(String[] args) {
        String boxes;

        //boxes = "110";
        //System.out.println(Arrays.toString(new Solution().minOperations(boxes)));


        boxes = "001011";
        System.out.println(Arrays.toString(new SolutionTODO().minOperations(boxes)));
    }
}