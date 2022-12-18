import java.util.ArrayList;

class SolutionYay {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        final int maxF = firstList.length, maxS = secondList.length;
        ArrayList<int[]> result = new ArrayList<>(2 * Math.max(maxF, maxS) + 1);
        int i = 0, j = 0;
        while (i < maxF && j < maxS) {
            int l = Math.max(firstList[i][0], secondList[j][0]);
            int r = Math.min(firstList[i][1], secondList[j][1]);

            if (l <= r) {
                result.add(new int[]{l, r});
            }

            if (firstList[i][1] < secondList[j][1]) {
                ++i;
            } else {
                ++j;
            }
        }
        return result.toArray(int[][]::new);
    }
}