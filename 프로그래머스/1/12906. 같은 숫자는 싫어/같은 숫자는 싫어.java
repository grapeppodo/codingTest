import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        
        // 1. [1, 1, 3, 3, 0, 1, 1]
        Deque<Integer> queue = new ArrayDeque<>();
        
        for(int i=0; i<arr.length; i++) {    
            if(queue.isEmpty()) {
                queue.offer(arr[i]);
            } else if(queue.peekLast() != arr[i]) {
                queue.offer(arr[i]);
            }
        }
        
        answer = new int[queue.size()];
        for (int i=0; i < answer.length; i++) {
            answer[i] = queue.poll();
        }
        
        return answer;
    }
}