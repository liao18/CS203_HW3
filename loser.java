public class loser {
    public static void main(String[] args) {
        int[] abc = {1, -8, 0, -2, 2, 293, -1290, 4, 1, 8, 16};

        int N = 0;
        for(int i = 0; i <= abc.length; i++)
        {
            if(abc[i] < 0)
            {
                N++;
            }

        }
    }
}