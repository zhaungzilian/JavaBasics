package Collections.HashMap.性能测试;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//七种遍历方法
public  class HashMapTest {

         static Map<Integer, String> map = new HashMap() {
            {
                for(int var1 = 0; var1 < 2; ++var1  ) {
                    this.put(var1, "val:" + var1);
                }

            }
        };

        public HashMapTest() {
        }

        public  static void main(String[] var0) {
            entrySet();
            keySet();
            forEachEntrySet();
            forEachKeySet();
            lambda();
            streamApi();
            parallelStreamApi();
        }

        public static void entrySet() {
            Iterator var0 = map.entrySet().iterator();

            while(var0.hasNext()) {
                Map.Entry var1 = (Map.Entry)var0.next();
                System.out.println(var1.getKey());
                System.out.println((String)var1.getValue());
            }

        }

        public static void keySet() {
            Iterator var0 = map.keySet().iterator();

            while(var0.hasNext()) {
                Integer var1 = (Integer)var0.next();
                System.out.println(var1);
                System.out.println((String)map.get(var1));
            }

        }

        public static void forEachEntrySet() {
            Iterator var0 = map.entrySet().iterator();

            while(var0.hasNext()) {
                Map.Entry var1 = (Map.Entry)var0.next();
                System.out.println(var1.getKey());
                System.out.println((String)var1.getValue());
            }

        }

        public static void forEachKeySet() {

            Iterator var0 = map.keySet().iterator();

            while(var0.hasNext()) {
                Integer var1 = (Integer)var0.next();
                System.out.println(var1);
                System.out.println((String)map.get(var1));
            }

        }

        public static void lambda() {
            map.forEach((var0, var1) -> {
                System.out.println(var0);
                System.out.println(var1);
            });
        }

        public static  void streamApi() {
            map.entrySet().stream().forEach((var0) -> {
                System.out.println(var0.getKey());
                System.out.println((String)var0.getValue());
            });
        }

        public  static void parallelStreamApi() {
            map.entrySet().parallelStream().forEach((var0) -> {
                System.out.println(var0.getKey());
                System.out.println((String)var0.getValue());
            });
        }
    }

