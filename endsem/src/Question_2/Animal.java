package Question_2;

public abstract class Animal {
    private int id;
    private String name;

    public void feedMe(){
        System.out.println("feed "+this.name);
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
}
