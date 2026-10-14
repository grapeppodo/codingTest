import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
 // map.containsKey(이름) /  map.get(이름) / map.put(이름, 숫자)       
//      participant 참여자 배열에 있는데 완주자 배열에 없으면 answer에 대입
        Map<String, Integer> participantMap = new HashMap<>();
        
        for(String p : participant) {
            // index에 동일한 이름이 이미 있으면 value + 1
            if(participantMap.containsKey(p)) {
                Integer count = participantMap.get(p);
                
                participantMap.put(p, count+1);
            } else {
                participantMap.put(p, 1);   
            }
            
        }
        
        for(String c : completion) {
            if(participantMap.containsKey(c)) {
                Integer count = participantMap.get(c);
                
                participantMap.put(c, count-1);            
            }
        }
        
        // 값이 0이 아닌 키 찾아서 answer 에 대입   
        for (String p : participantMap.keySet()) {   
            if(participantMap.get(p) != 0) {
                answer = p;
            }
        }
        return answer;
    }
}
