class Solutionzx {

    // todo
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        int fullRounds = -1;
        if (desiredTotal <= maxChoosableInteger) return true;
        int n = desiredTotal / (maxChoosableInteger + 1);
        return (desiredTotal - 2 * n) % (maxChoosableInteger + 1) == 0;
    }
}