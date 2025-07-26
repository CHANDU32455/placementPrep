
import java.util.Arrays;

class strings {

    public static void warmup() {
        String name = "chandu";
        String name1 = "cHandu";
        String name2 = new String("chandu");
        System.out.println(name1 == name);
        System.out.println(name == name2);
        System.out.println(name1.equals(name));
        System.out.println(name);
        String str = "cha ndua nana";
        // str.concat("cool");
        // System.out.println(val);  // chandu

        String val = str.concat(" is cool"); // now due to assignment it adds.. in new var.. thats immutability
        System.out.println(val);

        System.out.println("original string: " + str);

        System.out.println("length() :" + str.length());
        System.out.println("charAt(0) :" + str.charAt(0));
        System.out.println("substring(2):" + str.substring(2));
        System.out.println("substring(2,5):" + str.substring(2, 5));
        System.out.println("toLowerCase():" + str.toLowerCase());
        System.out.println("toUpperCase():" + str.toUpperCase());

        System.out.println("trim() " + str.trim());
        String str1 = "is cool";
        System.out.println("equals() " + str.equals(str1));
        String lower = "chandu";
        String upper = "CHANDU";
        System.out.println("equalsIgnoreCase() " + lower.equalsIgnoreCase(upper));

        // compareto, contains. replace
        System.out.println("compareTo(): " + str.compareTo(str1));
        System.out.println("apple".compareTo("apple"));
        System.out.println("apple".compareTo("banana"));
        System.out.println("bananaa".compareTo("banana"));

        System.out.println("compareToIgnoreCase(): " + str.compareToIgnoreCase(str1));
        System.out.println("contains(): " + str.contains("a"));
        System.out.println("replace('a', 'z')" + str.replace('a', 'z'));

        String[] parts = str1.trim().split(" ");
        System.out.println("split() : firstword:" + parts[0] + "  secondword:" + parts[1]);

        System.out.println("indexOf() :" + str.indexOf("n"));
        System.out.println("lastIndexOf(): " + str1.lastIndexOf("a"));
        System.out.println("stsrtsWith(): " + str1.startsWith("is"));
        System.out.println("endsWith(): " + str.endsWith("nan"));

        System.out.println(name + name2 + str.concat(name));

        char[] chars = "name".toCharArray();
        System.out.println(Arrays.toString(chars));
        for (char c : chars) {
            System.out.print(c + " ");
        }
        System.out.println();
        byte[] btes = "something".getBytes();
        System.out.println(Arrays.toString(btes));
        for (byte b : btes) {
            System.out.print(b + " ");
        }

        System.out.println();
        // int i = Integer.parseInt("coolbuddy"); // error because it needs to be int..
        // System.out.println(i);
        int x = Integer.parseInt("890");
        System.out.println(x);
        double num = Double.parseDouble("123179213742934973537");
        System.out.println(num);
    }

    public static void stringbuilder(){
        StringBuilder s = new StringBuilder("chandu");
        // append, insert, delete, repace, reverse methids..
        s.append(" is cool");
        System.out.println(s);

        s.insert(3, "oy..");
        System.out.println(s);

        s.replace(2, 5, "kooooo");
        System.out.println(s);

        s.reverse();
        System.out.println(s);

        System.out.println(s.toString());

        s.delete(1, 9);
        System.out.println(s);
    }

    public static void numOfConsonants(String str){
        str = str.toLowerCase();
        int count = 0; String res = "";
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) != 'a' && str.charAt(i) != 'e' && str.charAt(i) != 'i' && str.charAt(i) != 'o' && str.charAt(i) != 'u'){
                count++;
                res += str.charAt(i);
            }
        }
        System.out.println(res);
        System.out.println("count: " + count);
    }

    public static void form2Words_owels_cons(String s){
        s = s.toLowerCase();
        char[] str = s.toCharArray();
        String vowels = "", cons = "";
        for(char ch : str){
            if(!(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u')) cons += ch;
            else vowels += ch;
        }
        System.out.println(vowels);
        System.out.println(cons);
    }

    public static void main(String[] args) {
        // warmup();
        // stringbuilder();
        // numOfConsonants("Ashok");
        form2Words_owels_cons("OnePunchMan");
    }
}
