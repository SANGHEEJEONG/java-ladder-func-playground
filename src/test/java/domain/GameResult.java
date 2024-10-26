package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private final Map<String,Integer> resultMap = new HashMap<>();

    public Map<String,Integer> makeMap(List<String> names, List<Integer> result){
        for(int i = 0; i<result.size(); i++){
            resultMap.put(names.get(i),result.get(i));
        }
        return resultMap;
    }
}
