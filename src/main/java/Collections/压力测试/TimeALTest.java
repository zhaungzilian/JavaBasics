package Colletion集合问题.压力测试;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TimeALTest {
    static final int N = 600000;
    // 计算查询所需的值
    static long readList(List list) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            //模拟查询，只循环什么都不做
        }
        return System.currentTimeMillis() - start;
    }

    // 给集合里添加大量值
    @SuppressWarnings("unchecked")
    static List addList(List list) {
        Object o = new Object();
        for (int i = 0; i < N; i++) {
            //往容器里添加 6000 个数
            list.add(0, o);
        }
        return list;
    }

    @SuppressWarnings("rawtypes")
    public static void main(String[] args) {
        ArrayList arraylist = (ArrayList) addList(new ArrayList());
        LinkedList linkedlist = (LinkedList) addList(new LinkedList());
        System.out.println("ArrayList查找  " + arraylist.size() + "条耗时："+ readList(arraylist));
        System.out.println("LinkedList查找  " + linkedlist.size() + "条耗时："+ readList(linkedlist));
    }
}

