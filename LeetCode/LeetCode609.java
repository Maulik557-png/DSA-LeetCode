import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode609 {
    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)"};
        List<List<String>>res = findDuplicate(paths);
        for (List<String> l : res) {
            System.out.println(l);
        }
    }

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(String path : paths) {
            String[] parts = path.split(" ");
            String dir = parts[0];
            for(int i = 1; i < parts.length; i++) {
                StringBuilder sb = new StringBuilder();
                int start = parts[i].indexOf('(');
                int end = parts[i].indexOf(')');
                String content = parts[i].substring(start + 1, end);
                sb.append(dir);
                sb.append("/");
                sb.append(parts[i].substring(0, start));
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(sb.toString());
            }
        }

        for(List<String> group : map.values()) if(group.size() > 1) result.add(group);
        return result;
    }

    // public static List<List<String>> findDuplicate(String[] paths) {
    //     Map<String, List<String>> map = new HashMap<>();
    //     List<List<String>> result = new ArrayList<>();

    //     for(String path : paths){
    //         String[] parts = path.split(" ");
    //         String dir = parts[0];
    //         for(int i = 1; i < parts.length; i++){
    //             String file = parts[i];
    //             int start = file.indexOf('(');
    //             int end = file.indexOf(')');
    //             String fileName = file.substring(0, start);
    //             String content = file.substring(start + 1, end);
    //             String fullPath = dir + "/" + fileName;

    //             map.putIfAbsent(content, new ArrayList<>());
    //             map.get(content).add(fullPath);
    //         }
    //     }

    //     for(List<String> group : map.values()){
    //         if(group.size() > 1) result.add(group);
    //     }
    //     return result;
    // }

    // public static List<List<String>> findDuplicate(String[] paths) {
    //     Map<String, List<String>> map = new HashMap<>();
    //     List<List<String>> res = new ArrayList<>();

    //     for (String s : paths) {
    //         String[] p = s.split(" ");
    //         String dir = p[0];
    //         for (int i = 1; i < p.length; i++) {
    //             String content = p[i].substring(p[i].indexOf('(') + 1, p[i].indexOf(')'));
    //             map.putIfAbsent(content, new ArrayList<>());
    //             map.get(content).add(dir + "/" + p[i].substring(0, p[i].indexOf('(')));
    //         }
    //     }

    //     for (List<String> l: map.values()) {
    //         if(l.size() >= 2) {
    //             res.add(l);
    //         }
    //     }
    //     return res;
    // }
}
