package Colletion集合问题.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkListTest {

    public static void main(String[] args) {


        LinkedList<Integer> list = new LinkedList<>();
        //增
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //增加对象list
        LinkedList<User> users = new LinkedList<User>();
        users.add(new User(1,"李华","15428712@qq.com"));
        users.add(new User(2,"特斯拉","78r635722@qq.com"));

        for(User user:users){
            System.out.println("List参数为对象时---》： " + user);
        }

        //删
        //list.remove();
        //list.remove(0);
        //list.removeAll(list);
        //list.removeFirst();
        //list.removeLast();

        //改
        System.out.println("指定更改元素位置： -》 " +  list.set(2,20));



        System.out.println("\n--------------查-----------------\n");
        //查
        System.out.println("查询指定位置数：   \n"+list.get(1));
        System.out.println("查询前个数：  \n"+list.getFirst());
        System.out.println("\n查询后个数：  "+list.getLast());
        //查看list是否包含 该元素
        if (list.contains(2)){
            System.out.println("包含该元素"+list);
        }else {
            System.out.println("不存在该元素！");
        }

        //System.out.println(list);


    }


}
