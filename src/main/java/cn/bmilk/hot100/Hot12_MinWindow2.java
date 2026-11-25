package cn.bmilk.hot100;



public class Hot12_MinWindow2 {
    public static void main(String[] args) {
        Hot12_MinWindow2 hot12MinWindow = new Hot12_MinWindow2();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(hot12MinWindow.minWindow(s, t));
    }
    public String minWindow(String s, String t) {

        int[] baseArray = new int[128];
        int[] countArray = new int[128];
        for (Character c : t.toCharArray()){
            baseArray[c] = baseArray[c]+1;
            countArray[c] = countArray[c]+1;
        }
        int miss = t.length();
        int slow =0 , quick=0;
        String res = null;
        while ( slow<=quick && quick<s.length()){
            while (miss!= 0 && quick < s.length()){
                miss = countArray[s.charAt(quick)] >0 ? miss-1 : miss;
                countArray[s.charAt(quick)] = countArray[s.charAt(quick)] -1;
                quick++;
            }
            while (miss == 0 && slow <= quick){
                res = res == null || quick -slow < res.length() ? s.substring(slow, quick) : res;
                countArray[s.charAt(slow)] = countArray[s.charAt(slow)] +1;
                if (baseArray[s.charAt(slow)] > 0 && countArray[s.charAt(slow)] > 0) {
                    miss++;
                }
                slow++;
            }

        }
        return res == null ? "" : res;
    }
}
