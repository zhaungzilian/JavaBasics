package Serializable序列化;

import javax.xml.bind.SchemaOutputResolver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//将对象序列化后保存 xxxx.ser
public class SerializableTest  {

    public static void main(String[] args) throws IOException {

        UserS userS = new UserS();
        userS.id=1;
        userS.name = "李华";
        userS.Email="1625252746@qq.com";
        userS.SSN = 11122333;
      try {
          //将对象储存信息 用字节流输出保存到别的文件里
          FileOutputStream fileOutputStream = new FileOutputStream("src/main/java/Serializable序列化/UserS.ser");
          ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
          out.writeObject(userS);

          out.close();
          fileOutputStream.close();
      }catch (IOException E){
          System.out.println("使用失败!!!!!!!!!!!!!!!!!!!!!");
          System.out.println(E);
      }

    }

}
