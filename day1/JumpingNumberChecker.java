
public class JumpingNumberChecker {

    public static void main(String[] args) {
        int num = 12345;
        String s = Integer.toString(num);
        boolean jumping = true;

        for (int i = 1; i<s.length(); i++){
            int diff = Math.abs(s.charAt(i) - s.charAt(i-1));
            if (diff != 1){
                jumping = false;
                break;
            }
        }
        if(jumping) System.out.println("jumping japang jimpak jimpak...eeewwww...");
        else System.out.println("sorry no jumping here..");
    }
}
