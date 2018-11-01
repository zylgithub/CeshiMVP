package demo.ceshi.googlemvp.model;

/**
 * 数据模型
 */
public class UserInfoModel {
    private String name;
    private int age;
    private String address;

    @Override
    public String toString() {
        return "{" + "name=" + name + ",age=" + age + ",address=" + address + "}";
    }

    public UserInfoModel(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
