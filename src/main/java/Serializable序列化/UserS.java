package Serializable序列化;

import java.io.Serializable;

public class UserS implements Serializable {
    public int id;
    public String name;
    public String Email;
    public transient int SSN;

//    public void mailCheck()
//    {
//        System.out.println("Mailing a check to " + name
//                + " " + Email);
//    }

}
