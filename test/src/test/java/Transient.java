import lombok.Data;

import java.io.*;

/**
 * transient关键字
 * 将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会被序列化。
 * 1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 * 2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
 * 3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 *
 *
 * @author lt
 * @date 2021/4/5 9:50
 */
public class Transient {
    public static void main(String[] args) throws Exception,IOException{
        SerializeUser();

        DeSerializeUser();
    }
    //序列化
    private static void SerializeUser()throws FileNotFoundException,IOException,ClassNotFoundException{
        User user  = new User();
        user.setName("Transient");
        user.setAge(24);
        ObjectOutputStream oos =
                new ObjectOutputStream(new FileOutputStream("D:\\home"));
        oos.writeObject(user);
        oos.close();
        System.out.println("age:"+user.getName());
    }
    //反序列化
    private static  void DeSerializeUser() throws IOException,ClassNotFoundException{
        File file = new File("D:\\home");
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        User newUser = (User) ois.readObject();
        System.out.println("反序列化"+newUser.getAge());
    }
}

class User implements Serializable{
    private static  final long serialVersionUId = 123456L;
    private transient int age;
    private String name;

    public static long getSerialVersionUId() {
        return serialVersionUId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
