public class Test3 {
    public static String stringToReduce(final String str) {
        StringBuffer result = new StringBuffer();
        final int count = str.length();
        char c1 = str.charAt(0);
        int sum = 1;
        for (int i = 1; i < count; i++) {
            char c2 = str.charAt(i);
            if (c1 == c2) {
                sum++;
                continue;
            }
            result.append(sum).append(c1);
            c1 = c2;
            sum = 1;
        }
        result.append(sum).append(c1);
        return result.toString();
    }

    public static void main(String[] args) {
        String[] s = new String[]{"ASASASACZCCSAC", "ACACACSDSDA", "DSADASXAXAXA"};
        for (String a : s) {
            System.out.println(stringToReduce(a));
        }
    }
}