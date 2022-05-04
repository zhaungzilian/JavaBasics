package Java基本类;
/**
 * @author  zzy

    类用于对单个字符进行操作。


 **/



public class CharacterClass {

    //public static Character character;
    public String s = "s";
    public static char c = 's';

    public static void main(String[] args) {

        if (Character.isUpperCase(c) == true ){
            System.out.println("yes");
        }else {
            //如果不是大写则转成大写
            char c = Character.toUpperCase(CharacterClass.c);
            System.out.println(c);


        }
    }


}
