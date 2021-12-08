package Colletion集合问题.AarryList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class ArrayListTest {

    public static void main(String[] args) throws IOException{
//............................当构造方法为普通数据类型的时候......................................
        //基本操作 增加 删除 查询 添加 更改
        ArrayList<String> a = new ArrayList<String>();
        a.add("name：lihua");
        a.add("emil 154542@github.com");
        a.add("age: 19");
        //删
        a.remove(0);
        //更改
        a.set(0,"张泽明");
        a.indexOf(a);
        //普通的输出
        if (!a.isEmpty()){
            System.out.print("添加内容为： " + a + "\n列中的总数" +a.size());
            System.out.print("\n查看元素: " +  a.get(1));
        }
        System.out.println("\n------------------------------------------------------\n");
//............................当构造方法为对象时......................................
        ArrayList<User> users = new ArrayList<>();
        User user = new User();
        user.setId(1);
        user.setName("李华");
        user.setEmil("154082146@github.com");
        //加入到数组链表中
        users.add(user);
        //用迭代器遍历它
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User user1 = iterator.next();
            System.out.println("输出泛型为对象时的原素：  " + user1.getId() + user1.getName()+ user1.getEmil());
        }
        System.out.println("\n------------------------------------------------------\n");
        //for
        if (!users.isEmpty()) {
            for (User get : users) {
                System.out.println("增器for输出  ： " + get.getId() + get.getName() + get.getEmil());
            }
        }
        System.out.println("\n------------------------多线程线程安全测试------------------------------\n");
        //由于arraylist多线程不安全，集合提供了几个对符线程安全的同步锁方法
        Collections.synchronizedList(users);

        new Thread(()-> {
            try {
                //设置线程数
                for (int i = 20;i>0;i--){

                    System.out.println("线程名： "+Thread.currentThread().getName()+"\ni: "+i);
                    ArrayList<String> a2 = new ArrayList<>();
                    ArrayList<String> a1 = new ArrayList<>();
                        a2.add("name：lihua");
                        a2.add("emil 154542@github.com");
                        a2.add("age: 19");
                        a1.add("name：江小蜜瓜");
                        a1.add("emil 22374774@github.com");
                        a1.add("age: 29");

           //方法一： 将arraylist加入同步锁
                   Collections.synchronizedList(a2);
           //方法二： 用并发包中的拷贝数组测试
                    CopyOnWriteArrayList copyOnWriteArrayLis= new CopyOnWriteArrayList();
                    copyOnWriteArrayLis.add(a2);
                    copyOnWriteArrayLis.add(a1);

                    System.out.println("拷贝类解决arraylist并法问题：   "+copyOnWriteArrayLis);

                    Iterator<String> gt = a.iterator();
                    while (gt.hasNext()){
                        System.out.println("加入到同步锁的数组： ----》"+ gt.next());
                    }
                    //Thread.sleep(1000);

                }
            }catch (Exception e){
                System.out.println(e);
            }finally {
                //查看线程状态
                System.out.println("当前线程是否活着：--->"+Thread.currentThread().isAlive());
                System.out.println("\n当前是否存在线程：--->"+Thread.getAllStackTraces().isEmpty());
            }

        }).start();


    }


}
