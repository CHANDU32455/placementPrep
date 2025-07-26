public class digitDiffDecoder {
    public static void main(String[] args){
        int num = 8357;
        String s = Integer.toString(num);
        int res = s.charAt(0) - '0';
        for(int i=1; i<s.length(); i++){
            int diff = Math.abs(s.charAt(i) - s.charAt(i-1));
            res = res*10 + diff;
        }
        System.out.println(res); // 8522
    }
}

/**
 * 
 * first dig -- unchanged
 * abs(3-8) = 5
 * abs(5-3) = 2
 * abs(7-5) = 2
 * 
 * output: 8522
 */