import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        Map<String, Integer> combination = new HashMap<>();
        
        for(int i=0; i<clothes.length; i++) {
            String category = clothes[i][1];
            combination.put(category, combination.getOrDefault(category, 0) + 1);
        }
        
        for (int m : combination.values()) {
            answer *= (m + 1);                 // "안 입음" 선택지
        }

        return answer - 1;
    }
}