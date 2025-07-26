
public class StrongNum{
    public static void main(String[] args){
        for (int num = 1; num <= 100; num++) {
            int result = 0, temp = num;
            while(temp > 0){
                int digit = temp % 10;
                int f = 1;
                for (int i = 1; i <= digit; i++){
                    f = f * i;
                }
                result += f;
                temp /= 10;
            }
            if (result == num){
                System.out.println(num + " is a Strong number");
            }
        }
    }
}

