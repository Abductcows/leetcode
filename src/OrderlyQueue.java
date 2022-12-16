import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class SolutionKKKKK {
    public String orderlyQueue(String s, int k) {

        byte[] letters = s.getBytes();

        if (k > 1) {
            Arrays.sort(letters);
            return new String(letters);
        }

        // find min characters in word
        char minChar = Character.MAX_VALUE;
        List<Integer> minPositions = new ArrayList<>();

        for (int i = 0; i < letters.length; i++) {
            char current = (char) letters[i];
            if (current < minChar) {
                minPositions.clear();
                minChar = current;
                minPositions.add(i);
            } else if (current == minChar) {
                minPositions.add(i);
            }
        }
        if (minPositions.size() == 1 && minPositions.get(0) == 0) return s;

        // try rotations
        PriorityQueue<String> minHeap = new PriorityQueue<>();
        byte[] rotatedWord = new byte[letters.length];

        for (int wordStart : minPositions) {

            int firstPartLength = letters.length - wordStart;
            System.arraycopy(letters, wordStart, rotatedWord, 0, firstPartLength);
            int secondPartLength = letters.length - firstPartLength;
            System.arraycopy(letters, 0, rotatedWord, firstPartLength, secondPartLength);
            minHeap.add(new String(rotatedWord));
        }

        return minHeap.poll();
    }

    public static void main(String[] args) {
        String input, output;

        input = "xitavoyjqiupzadbdyymyvuteolyeerecnuptghlzsynozeuuvteryojyokpufanyrqqmtgxhyycltlnusyeyyqygwupcaagtkuq";
        output = new SolutionKKKKK().orderlyQueue(input, 1);

        System.out.println(input);
        System.out.println(output);
    }
}