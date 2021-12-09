package Reflection;

class Users{
    private int id;
    private int age;
    private String names;
    private String Email;

    public Users() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", age=" + age +
                ", names='" + names + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}