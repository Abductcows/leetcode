class Solutionjjjj {
    // todo
    public String longestPalindrome(String s) {

        byte[] chars = s.getBytes();
        final int n = chars.length;

        int maxLength = 1;
        String maxString = Character.toString((char) chars[0]);
        for (int i = 0; i < n; i++) {

            int currentLength = 1;
            final int evenBias;
            if (i + 1 < n && chars[i + 1] == chars[i] && (i == 0 || (i + 2 < n && (chars[i - 1] != chars[i] || i == n / 2 - (n + 1) % 2)))) {
                evenBias = 1;
                ++currentLength;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    maxString = s.substring(i, i + 2);
                }
            } else {
                evenBias = 0;
            }

            for (int j = 1; i - j >= 0 && i + j + evenBias < n; ++j) {
                if (chars[i - j] == chars[i + j + evenBias]) {
                    currentLength += 2;

                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                        maxString = s.substring(i - j, i + j + evenBias + 1);
                    }
                } else {
                    break;
                }
            }
        }

        return maxString;
    }

    public static void main(String[] args) {
        String input, output, expected;

        input = "azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc";
        expected = "sooos";
        output = new Solutionjjjj().longestPalindrome(input);
        System.out.println("Output: " + output + " - Expected: " + expected);

        input = "abbcccbbbcaaccbababcbcabca";
        expected = "bbcccbb";
        output = new Solutionjjjj().longestPalindrome(input);
        System.out.println("Output: " + output + " - Expected: " + expected);

        input = "eabcb";
        expected = "bcb";
        output = new Solutionjjjj().longestPalindrome(input);
        System.out.println("Output: " + output + " - Expected: " + expected);

        input = "aaaa";
        expected = "aaaa";
        output = new Solutionjjjj().longestPalindrome(input);
        System.out.println("Output: " + output + " - Expected: " + expected);

        input = "ccc";
        expected = "ccc";
        output = new Solutionjjjj().longestPalindrome(input);
        System.out.println("Output: " + output + " - Expected: " + expected);

        input = "cbbd";
        expected = "bb";
        output = new Solutionjjjj().longestPalindrome(input);
        System.out.println("Output: " + output + " - Expected: " + expected);

        input = "babad";
        expected = "bab";
        output = new Solutionjjjj().longestPalindrome(input);
        System.out.println("Output: " + output + " - Expected: " + expected);
    }
}