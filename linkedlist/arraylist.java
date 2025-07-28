import java.util.ArrayList;

class ListNode{
    int data;
    ListNode next;

    ListNode(int data){
        this.data = data;
        this.next = null;
    }
}


public class arraylist{

    public boolean isPalandome(ListNode head){
        ArrayList<Integer> arr = new ArrayList<>();

        ListNode current = head;
        while(current != null){
            arr.add(current.data);
            current = current.next;
        }
        int low = 0; 
        int high = arr.size() - 1;

        while(low < high){
            if(!arr.get(low).equals(arr.get(high))){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}