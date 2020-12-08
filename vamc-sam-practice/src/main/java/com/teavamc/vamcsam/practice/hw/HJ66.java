package com.teavamc.vamcsam.practice.hw;

import java.util.*;

/**
 * 有6条配置命令，它们执行的结果分别是：
 * <p>
 * 命   令	执   行
 * reset	reset what
 * reset board	board fault
 * board add	where to add
 * board delete	no board at all
 * reboot backplane	impossible
 * backplane abort	install first
 * he he	unknown command
 * 注意：he he不是命令。
 * <p>
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unkown command。
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
 * 6、若匹配失败，打印“unknown command”
 */
public class HJ66 {

//    public static void main(String[] args) {
//        Map<String, String> map = new LinkedHashMap<>();
//        map.put("reset", "reset what");
//        map.put("reset board", "board fault");
//        map.put("board add", "where to add");
//        map.put("board delet", "no board at all");
//        map.put("reboot backplane", "impossible");
//        map.put("backplane abort", "install first");
//
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String input = sc.nextLine();
//            // 分隔输入中的空格
//            String[] words = input.split(" ");
//            int len = words.length;
//            List<String> output = new ArrayList<>();
//            // 遍历预定的命令集合
//            for (String key: map.keySet()) {
//                // 拿到预定命令分隔符
//                String[] comWords = key.split(" ");
//                // 如果预定命令的字符串数量与输入的相等,进入匹配逻辑
//                if (comWords.length == len) {
//                    // 初始化通过标记
//                    boolean passed = true;
//                    // 如果字符不以这个开始,那就设置为 false
//                    for (int i = 0; i < len; i++) {
//                        if (!comWords[i].startsWith(words[i])) {
//                            passed = false;
//                        }
//                    }
//                    // 如果通过就放进通过集合
//                    if (passed) {
//                        output.add(key);
//                    }
//                }
//            }
//            // 如果候选项大于 1 就表示未知
//            if (output.size() != 1)
//                System.out.println("unkown command");
//            else
//                System.out.println(map.get(output.get(0)));
//        }
//    }


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("board delete", "no board at all");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            // 分隔输入中的空格
            String[] str_arr = input.split(" ");
            String pass_res = null;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String backupCom = entry.getKey();
                // 遍历预设指令集
                String[] backupCom_arr = backupCom.split(" ");
                boolean pass = true;
                if (backupCom_arr.length == str_arr.length) {
                    for (int i = 0; i <= backupCom_arr.length - 1; i++) {
                        // 分别匹配开头
                        if (!backupCom_arr[i].startsWith(str_arr[i])) {
                            pass = false;
                            break;
                        }
                    }
                } else {
                    pass = false;
                }
                // 如果是重复匹配两次则设置 null
                if (pass) {
                    pass_res = pass_res == null ? entry.getValue() : null;
                }
            }
            if (pass_res == null) {
                System.out.println("unknown command");
            } else {
                System.out.println(pass_res);
            }
        }
    }
}
