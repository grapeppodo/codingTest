import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 1. 각 작업이 끝나는 시간 기록해서 
        // 1-1. 끝나는 시간 = 남은 양(100 - 진도) / 속도
        // 1-2. 나머지 있으면 +1 
        List<Integer> endTime = new ArrayList<>();
        for(int i=0; i<progresses.length; i++) {
            int day = 0;

            day = (100 - progresses[i]) / speeds[i];
            
            if((100 - progresses[i]) % speeds[i] > 0) {
                day+= 1;
            }
            
            endTime.add(day);
        }
       
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        
        // 2. 큐가 비었거나 끝나는 날이 맨 앞 이하 -> 큐에 넣기
        // 2-1. 맨 앞보다 크면 -> 큐 사이즈 답에 추가, 큐 비우기, 지금 거 넣기
        for (int day : endTime) {
            if (!queue.isEmpty() && day > queue.peek()) {
                result.add(queue.size());
                queue.clear();
            }
            queue.add(day);
        }
        
        // 3. 반복문 끝나면 남은 큐 사이즈 답에 추가
        result.add(queue.size());
        
        // 4. 답 (list) -> int[]로 변환
        int[] answer = new int[result.size()];

        for(int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}