class SolutionLZKdo {
    public int mySqrt(int x) {

        return (int) Math.floor(
                Math.exp(0.5 * Math.log(x))
        );
    }
}