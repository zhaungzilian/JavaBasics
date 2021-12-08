package Collections.HashMap;

import java.util.HashMap;

public class UseHashMapTest {

    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>();
        //增
        hashMap.put(1,"zhuangsna");
        hashMap.put(2,"lihau");
        hashMap.put(5, "Runoob");
        hashMap.put(3, "Taobao");
        hashMap.put(4, "Zhihu");
        //删
        //hashMap.remove(1);
        //hashMap.clear();//删除所以key value
        //改
        hashMap.replace(1,"李磊");//替换
        //查
        System.out.println("当前hash值为: " + hashMap.get(1)+"\n当前hashmap有: "+hashMap.size()+"个" );
        //遍历
        if (!hashMap.isEmpty()) {
            for (Integer key : hashMap.keySet()) {
                System.out.println("key: " + key + "   value: " + hashMap.get(key));
            }
        }

        //映射
        //containsKey()  containsValue()  forEach() entrySet()

        System.out.println("\n-----------------映射------------------------\n");
        HashMap<String, Integer> hashMap1 = new HashMap<>();
        // 往 HashMap 中插入映射项
        hashMap1.put("Shoes", 200);
        hashMap1.put("Bag", 300);
        hashMap1.put("Pant", 150);
        //forEach()
        hashMap1.forEach((key,value)->{
            //对值通过映射做修改
            value = value - 40;
            System.out.println("key: "+key+"value: "+value);
        });
        //containsKey() 查看是否包含某个值
        if (hashMap1.containsKey("Pant")){
            System.out.println("存在 pant 值");
        }
        //containsValue() 查看是否包含指定value值
        if (hashMap1.containsValue(5555)){
            System.out.println("存在value 为150");
        }else {
            System.out.println("输出：  "+hashMap1.values());
        }
        //返回此映射中包含的映射的 （Set 视图 == key value)
        //注意：Set 视图意思是 HashMap 中所有的键值对都被看作是一个 set 集合。
        System.out.println("返回所以set视图： "+ hashMap1.entrySet());
    }

}
