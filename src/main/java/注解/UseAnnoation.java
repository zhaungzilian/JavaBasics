package 注解;

public class UseAnnoation {

    @AnnoationTest()
    public void getuser(){
        System.out.println("登录信息");
    }

    public static void main(String[] args) {
        UseAnnoation useAnnoation = new UseAnnoation();
        useAnnoation.getuser();
    }
}
