package BackTrack;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    // 结果集
    private List<List<String>> res;

    // 当前路径
    private List<String> path;

    // 存放可选择元素
    private Set<String> wordSet;

    public boolean wordBreak1 (String s, List<String> wordDict){
        return false;
    }


    public List<List<String>> wordBreak2 (String s, List<String> wordDict){
        wordSet = new HashSet<>();
        res = new ArrayList<>();
        path = new ArrayList<>();
        wordSet.addAll(wordDict);
        backTrack(s, 0);
        return res;
    }

    public void backTrack (String s, int start) {
        if (start >= s.length() - 1) {
            res.add(new ArrayList<>(path));
        }
        for (int i = start; i < s.length(); i++) {
            String currentWord = s.substring(start, i + 1);
            if (!wordSet.contains(currentWord)) {
                continue;
            }
            path.add(currentWord);
            backTrack(s, i + 1);
            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test () {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        wordDict.add("lee");
        wordDict.add("tcode");
        System.out.println(wordBreak2(s, wordDict));
    }
}
