import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class BowlingGame {
public Integer[] flameScore = new Integer[10];

    public int count(Integer[] score) {
        List<Integer> scoreList = new ArrayList<>(score.length);
        Collections.addAll(scoreList,score);
        for (int i = 0; i < 10; i++){
            if (scoreList.get(0) == 10) {
                flameScore[i] = scoreList.get(0)+scoreList.get(1)+scoreList.get(2);
                scoreList.remove(0);
            }else if (scoreList.get(0) + scoreList.get(1) == 10) {
                flameScore[i] = scoreList.get(0)+scoreList.get(1)+scoreList.get(2);
                scoreList.remove(0);
                scoreList.remove(0);
            }else if (scoreList.get(0) + scoreList.get(1) < 10) {
                flameScore[i] = scoreList.get(0)+scoreList.get(1);
                scoreList.remove(0);
                scoreList.remove(0);
            }else {
                throw new RuntimeException("input not valid");
            }
        }
        Stream<Integer> scoreStream = Arrays.stream(flameScore);
        int result = scoreStream.reduce(0, Integer::sum);
        return result;
    }
}
