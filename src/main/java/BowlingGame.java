import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class BowlingGame {
    public final int flameNumber = 10;
    public final int maxScore = 10;

    public List<Integer> flameScore = new ArrayList<>();

    public int count(Integer[] score) {
        List<Integer> scoreList = new ArrayList<>(score.length);
        Collections.addAll(scoreList,score);
        for (int i = 0; i < flameNumber; i++){
            if (scoreList.get(0) == maxScore) {
                flameScore.add(countTopNumberScore(scoreList,3));
                scoreList.remove(0);
            }else if (countTopNumberScore(scoreList,2) == maxScore) {
                flameScore.add(countTopNumberScore(scoreList,3));
                scoreList.remove(0);
                scoreList.remove(0);
            }else if (countTopNumberScore(scoreList,2) < maxScore) {
                flameScore.add(countTopNumberScore(scoreList,2));
                scoreList.remove(0);
                scoreList.remove(0);
            }else {
                throw new RuntimeException("input not valid");
            }
        }
        int result = flameScore.stream().reduce(0, Integer::sum);
        return result;
    }

    public int countTopNumberScore(List<Integer> scoreList,int number) {
        int result = scoreList.stream().limit(number).reduce(Integer::sum).get();
        return result;
    }
}
