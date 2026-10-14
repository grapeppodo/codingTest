import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        // 1. 모든 전화번호를 키에 다 넣고, 해시 맵을 만든다. 
        Set<String> phoneSet = new HashSet<>();        
        
        for(String phone: phone_book) {
            phoneSet.add(phone);
        }
        
        // 2. 해시 셋을 다 돌면서, phone_book 의 prefix가 있으면 false 아니면 true 
        for(String phone: phone_book) {
            
            // phone이 있냐? - 길이는 맞춰 자르면 됨. / 이중 for 없애라. 
            Integer length = phone.length();

            for(int i=0; i<length; i++) {  
                String prefix = phone.substring(0, i);

                if(phoneSet.contains(prefix)) {
                    return false;
                }
            }
        }
                    
        return true;
    }
}