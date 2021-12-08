package Serializable序列化;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeTest {
    public static void main(String[] args) throws IOException {
        //用输入流进行反序列化

        UserS s = null;
        try {
            FileInputStream fileIn = new FileInputStream("src/main/java/Serializable序列化/UserS.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            s = (UserS) in.readObject();
            in.close();
            fileIn.close();

        }catch(IOException i)
        {
            i.printStackTrace();
            return;
        }catch(ClassNotFoundException c)
        {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("通过对序列化文件的解析进行反序列化后的，从新拿回了对象属性：   ");
        System.out.println("名字: " + s.name);
        System.out.println("SSN: " + s.SSN);
        System.out.println("ID: " + s.id);
        System.out.println("邮箱: " + s.Email);
        }
    }