package Colletion集合问题.LinkedList;

public class User {
    private int id;
    private String name;
    private String Emil;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmil() {
        return Emil;
    }

    public void setEmil(String emil) {
        Emil = emil;
    }

    public User(int id, String name, String emil) {
        this.id = id;
        this.name = name;
        Emil = emil;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Emil='" + Emil + '\'' +
                '}';
    }
}

