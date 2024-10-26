package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {
    private final Map<String,String> resultMap = new HashMap<>();

    public void makeMap(List<String> names, List<String> kindOfResults, List<Integer> result){
        for(int i = 0; i<result.size(); i++){
            resultMap.put(names.get(i),kindOfResults.get(result.get(i)));
        }
    }

    public Map<String,String> getResultMap(){
        return resultMap;
    }

}
