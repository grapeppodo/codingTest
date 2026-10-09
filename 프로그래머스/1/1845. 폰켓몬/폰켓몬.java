import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        // 1. 뽑을 수 있는 개수 = 배열 사이즈 / 2
        int answer = nums.length / 2;
        
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        
        int kind = set.size();
        
        // 2. 종류 수 구하기 = 각 숫자들의 개수를 카운팅 
        answer = Math.min(answer, kind);
        
        // 3. 정답 계산
        
        return answer;
    }
}

// 첫번째 예시
// 종류(kind) 3가지, 개수(count) 2개  => 2개
// max 공식 = if (kind > count) { 
    // max = count
// }else {
// max = kind
// }

// 두번째 예시
// 종류(kind) 3가지, 개수(count) 3개  => 3개

// 세번째 예시
// 3번 3개, 2번 2개
// 종류(kind) 2가지, 개수(count) 3개  => 2개
