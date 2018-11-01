package demo.ceshi.CeshiGoogleMvp.model;

/**
 * 创建数据模型
 */
public class UserModel {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserModel(String name, int age, String address) {

        this.name = name;
        this.age = age;
        this.address = address;
    }
}
