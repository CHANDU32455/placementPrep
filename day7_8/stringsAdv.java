
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class stringsAdv {

    public static void revString() {
        // StringBuilder s = new StringBuilder("hello world..");
        // s.reverse();
        char[] s = "chandu".toCharArray();
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.print(s[i]);
        }
    }

    public static void revWith2ptrApproach() {
        String s = "something...";
        char[] ch = s.toCharArray();
        int low = 0, high = s.length() - 1;
        while (low < high) {
            char temp = ch[high];
            ch[high] = ch[low];
            ch[low] = temp;
            low++;
            high--;
        }
        for (char c : ch) {
            System.out.print(c);
        }
    }

    public static boolean isPalandome() {
        String s = "madamm";
        int low = 0, high = s.length() - 1;
        while (low < high) {
            if (s.charAt(high) != s.charAt(low)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void vowels_cons_count(String s) {
        int vcount = 0, ccount = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
            /**
             * if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
             * || s.charAt(i) == 'o' || s.charAt(i) == 'u'){ vcount++; }else
             * if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){ ccount++; }
             */
            if ("aeiou".indexOf(i) != -1) {
                vcount++; 
            }else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                ccount++;
            }
        }
        System.out.println("vowels count : " + vcount);
        System.out.println("consonants count : " + ccount);
    }

    public static void firstHalfVCount_SecondHalfVCount(String s) {
        int v1count = 0, v2count = 0;
        s = s.toLowerCase();
        int n = s.length();
        int left = 0, right = n - 1;
        /**
         * for(int i = 0; i<n/2; i++){ if("aeiou".indexOf(s.charAt(i)) != -1)
         * v1count++; } for(int i = n/2;i<n; i++){
         * if("aeiou".indexOf(s.charAt(i))!= -1) v2count++; }
         */
        while (left < right) {
            if ("aeiou".indexOf(s.charAt(left)) != -1 && left != right) {
                v1count++;
            }
            if ("aeiou".indexOf(s.charAt(right)) != -1) {
                v2count++;
            }
            left++;
            right--;
        }
        System.out.println("v1count:" + v1count + " " + "v2count:" + v2count);
        System.out.println("final abs diff: " + Math.abs(v1count - v2count));
    }

    public static void noDuplicates(String s) {
        char[] ch = s.toCharArray();
        char[] res = new char[s.length()];
        int resIdx = 0;

        for (int i = 0; i < ch.length; i++) {
            boolean found = false;
            for (int j = 0; j < resIdx; j++) {
                if (ch[i] == res[j]) {
                    found = true;
                    break;
                }
            }
            // first time seeing
            if (!found) {
                res[resIdx++] = ch[i];
            }
        }
        for (char c : res) {
            System.out.print(c);
        }
    }

    public static void positionXvowel(String s) {
        s = s.toLowerCase();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                System.out.println("printing vowel " + i + "(pos) times: " + String.valueOf(ch).repeat(i));
            }
        }
    }

    public static void vowelsExperiments(String s) {
        s = s.toLowerCase();
        System.out.println("printing vowels caps");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if ("aeiou".indexOf(ch) != -1) {
                System.out.print(Character.toUpperCase(ch)); 
            }else {
                System.out.print(ch);
            }
        }
        System.out.println();

        // printing even indices chars caps
        System.out.println("printing even indices chars caps");
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                System.out.print(Character.toUpperCase(s.charAt(i))); 
            }else {
                System.out.print(s.charAt(i));
            }
        }

        System.out.println("lowercase to upper and upper to lower...");
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch)) {
                System.out.print(Character.toLowerCase(ch)); 
            }else {
                System.out.print(Character.toUpperCase(ch));
            }
        }

        System.out.println("Printing all words in sentence..");
        String[] words = s.split(" ");
        for (String word : words) {
            char firstLtr = word.charAt(0);
            System.out.println(Character.toUpperCase(firstLtr) + word.substring(1) + " ");
        }
    }

    public static void areAnagrams() {
        String s1 = "silent";
        String s2 = "listen";
        char[] s11 = s1.toCharArray();
        char[] s22 = s2.toCharArray();
        Arrays.sort(s11);
        Arrays.sort(s22);
        if (Arrays.equals(s11, s22)) {
            System.out.println("Anagrams"); 
        }else {
            System.out.println("not anagrams");
        }
    }

    public static void countCharOcc(String s) {
        HashMap<Character, Integer> charCounts = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            System.out.println("Character: " + entry.getKey() + ", Count: " + entry.getValue());
        }
    }

    public static void continouesLongestString(String s) {
        String longest = "", current = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (current.indexOf(ch) != -1) {
                current = current.substring(current.indexOf(ch) + 1);
            }
            current += ch;
            if (current.length() > longest.length()) {
                longest = current;
            }
        }
        System.out.println("string: " + s);
        System.out.println("Longest continuous string: " + longest);
        System.out.println("After removing longest substring: " + s.replace(longest, ""));
    }

    public static void main(String[] args) {
        // revString();
        // revWith2ptrApproach();
        // System.out.println(isPalandome());
        // vowels_cons_count("Somebody... is doing @#$");
        // firstHalfVCount_SecondHalfVCount("somebodyIsDoingSomething");
        // noDuplicates("programming");
        // positionXvowel("i love programming");
        // vowelsExperiments("i love programming");
        // areAnagrams();
        // countCharOcc("OnePunchMan");
        continouesLongestString("abcabcd");
    }
}
