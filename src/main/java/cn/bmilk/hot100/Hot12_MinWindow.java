package cn.bmilk.hot100;



public class Hot12_MinWindow {
    public static void main(String[] args) {
        Hot12_MinWindow hot12MinWindow = new Hot12_MinWindow();
        String s = "a";
        String t = "aa";
        String s1 = hot12MinWindow.minWindow(s, t);
    }
    public String minWindow(String s, String t) {

        int[] intsT = new int[128];
        for (Character c : t.toCharArray()){
            intsT[c] = intsT[c]+1;
        }
        int slow =0 , quick=0;
        String res = null;
        int[] intsS = new int[128];
        boolean contains = false;
        while ( slow<=quick && quick<s.length()){
            while (quick < s.length()){
                intsS[s.charAt(quick)] = intsS[s.charAt(quick)] +1;
                quick++;
                if(contains(intsS, intsT)){
                    contains = true;
                    break;
                }
            }
            if(!contains){
                continue;
            }
            while (slow <= quick){

                res = res == null || quick -slow < res.length() ? s.substring(slow, quick) : res;
                intsS[s.charAt(slow)] = intsS[s.charAt(slow)] -1;
                slow++;
                if(!contains(intsS, intsT)){
                    contains = false;
                    break;
                }
            }

        }
        return res == null ? "" : res;
    }

    public boolean contains(int[] array1 , int[] array2){
        if(array1.length != array2.length){
            return false;
        }
        for (int i = 0; i< array1.length; i++){
            if(array2[i] - array1[i] > 0){
                return false;
            }
        }
        return true;
    }
}
