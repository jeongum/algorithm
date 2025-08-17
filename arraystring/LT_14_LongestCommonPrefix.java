public class LT_14_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        LT_14_LongestCommonPrefix solver = new LT_14_LongestCommonPrefix();

        System.out.println(solver.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
