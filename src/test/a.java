package test;/**
 * @author shkstart
 * @create 2020-10-28 17:22
 */

/**
 * @program: StudentInfo
 *
 * @description:
 *
 * @author: wwq
 *
 * @create: 2020-10-28 17:22
 **/
public class a {

    public void ccc(){
        System.out.println("aaa");
    }

    public a(){
        ccc();
        System.out.println("f");
        new b().b();
        new b();
    }

    public static void main(String[] args) {
        new a();
        int a =1 ;
        System.out.println("........................");
        int b = a ==2 ? 2 :3;
        System.out.println(b);
    }
}





