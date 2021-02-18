package home.day09;

import java.util.*;

/**
 * Created with Intellij IDEA
 * Description:
 * Users:123
 * Date:2021-02-15
 * Time:19:13
 */
public class 前k个高频单词 {
    public static void main(String[] args) {
        String[] strings = {"i", "love", "leetcode", "i", "love", "coding"};
        List<String> list = topKFrequent(strings, 2);
        System.out.println(list);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        // 建立哈希表统计单词频率
        Map<String,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        //大顶堆
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer o1Count = map.get(o1);
                Integer o2Count = map.get(o2);
                if (o1Count.equals(o2Count)) {
                    return o1.compareTo(o2);//,相同频率下，字母顺序低的在前
                }else {
                    return o2Count-o1Count;
                }
            }
        });
        //全部入队列，大顶堆，所有是降序入队的
        queue.addAll(map.keySet());
        //出前k个单词出队列放入list
        for (int i = 0;i < k;i++) {
            list.add(queue.poll());
        }
        return list;
    }
}
