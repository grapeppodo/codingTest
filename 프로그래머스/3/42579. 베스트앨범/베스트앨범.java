import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        // 1. genres 돌면서 map 에 장르멸 plays 기록
        Map<String, Integer> genresMap = new HashMap<>();
        
        for(int i=0; i<genres.length; i++) {
            if(genresMap.containsKey(genres[i])) {
                Integer totalPlays = genresMap.get(genres[i]);
                
                genresMap.remove(genres[i]);
                genresMap.put(genres[i], totalPlays +plays[i]);
            } else {
                genresMap.put(genres[i], plays[i]);   
            }
        }
        
        // 장르 개수만큼 for문 돌다가
        // 장르별 plays로 정렬하기 
        List<String> genreOrder = new ArrayList<>(genresMap.keySet());

        // 2. 값(총 재생수) 기준으로 큰 것부터 정렬
        genreOrder.sort((a, b) -> genresMap.get(b) - genresMap.get(a));
    
        
        Map<String, List<Integer>> playOrder = new HashMap<>();
        
        // playOrder
        // classic 800
        // classic 500
        // classic 150
        // pop 2500
        // pop 600
        // 이렇게 추정중
        
        // pop 먼저 2번, 그리고 classic 두번 출력해야하는데
        // 여기서 너무 어려워지는데? classic이 한번이면 한번 출력하고 나가야 하고
        // pop이 세번이면 두번만 하고 classic으로 넘어가야하는데 힌트 ,, 
        for (int i=0; i<genres.length; i++) {
            playOrder.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(i); 
        }
        

        for (String genre : playOrder.keySet()) {
            List<Integer> songs = playOrder.get(genre);
            songs.sort((a,b) -> plays[b] - plays[a]);
        }
        
        List<Integer> result = new ArrayList<>();
        for(String genre : genreOrder) {
            List<Integer> songs = playOrder.get(genre);
            
            for (int j=0; j< Math.min(2, songs.size()); j++) {
                result.add(songs.get(j));
            }
        }
        
        answer = new int[result.size()];
        for (int i=0; i< result.size(); i++) {
            answer[i] = result.get(i);
        }
                       
        return answer;
    }
}