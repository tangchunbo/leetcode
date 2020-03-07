package study.sort;

public class KMP {

    private static int[] getNext(char[] t) {
        int[] next = new int[t.length];
        next[0] = -1;
        next[1] = 0;
        int k;
        for (int j = 2; j < t.length; j++) {
            k = next[j-1];// 前一位的值
            while (k != -1) {
                if(t[j-1] == t[k]) {
                    next[j] = k+1;
                    break;
                } else {
                    k = next[k];
                }
                next[j] = 0;
            }
        }
        return next;
    }

    public static int kmpMatch(String s, String t) {
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();
        int[] next = getNext(t_arr);
        int i = 0, j = 0;
        while (i < s_arr.length && j < t_arr.length) {
            if(j == -1 || s_arr[i] == t_arr[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == t.length() ? i - j : -1;
    }

    public static void main(String[] args) {
        System.out.println(kmpMatch("abcabaabaabcacb", "abaabcac"));
    }
}