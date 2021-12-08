package Colletion集合问题.LinkedList;

import java.util.LinkedList;

public class LinklistTest01 {

}

//以Stack的出和进方式模拟
class ListtoStack{

    private LinkedList list = new LinkedList();
    public void push(Object v) {
        //最先进
        list.addFirst(v);
    }
    public Object top() {
        //返回该值
        return list.getFirst();
    }
    public Object pop() {
        //删除最前
        return list.removeFirst();
    }

//    public static void main(String[] args) {
//        ListtoStack listtoStack = new ListtoStack();
//        for (int i = 0 ;i<10;i++){
//            listtoStack.push(i);
//            System.out.println(listtoStack.top());
//            System.out.println(listtoStack.pop());
//
//        }
//    }
}
//使用链表来实现队列效果
class Queue {
    private LinkedList list = new LinkedList();
    public void put(Object v) {
        list.addFirst(v);
    }
    public Object get() {
        return list.removeLast();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }

//    public static void main(String[] args) {
//        Queue queue = new Queue();
//        for (int i = 0; i < 10; i++)
//            queue.put(Integer.toString(i));
//        while (!queue.isEmpty())
//            System.out.println(queue.get());
//
//    }
}
//将linkedlist转变成arraylsit
