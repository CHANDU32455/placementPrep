public class BalancedNumber{
    public static void main(String[] args){
        int num = 103450008;
        String s = Integer.toString(num);
        int length = s.length();

        System.out.println(length + "is the num length.");
        if(length%2 == 0){
            int mid = length/2;
            System.err.println("even len logic executing..");
            int leftsum = 0;
            for(int i = 0; i<mid; i++){
                leftsum += s.charAt(i) - '0';
            }
            int rightsum = 0;
            for(int i = mid; i<length; i++){
                rightsum += s.charAt(i) - '0';
            }
            if(leftsum == rightsum) System.out.println("Balanced...");
            else System.out.println("unbalanced..");
        }else{
            int mid = (length / 2);        
            System.out.println("odd len logic executing..");
            int leftsum = 0;
            for(int i = 0; i<mid; i++){
                leftsum += s.charAt(i) - '0';
            }
            int rightsum = 0;
            for(int i = mid+1; i<length; i++){
                rightsum += s.charAt(i) - '0';
            }
            if(leftsum == rightsum) System.out.println("Balanced...");
            else System.out.println("unbalanced..");
        }
    }
}