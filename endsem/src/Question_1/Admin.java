package Question_1;

import java.util.HashMap;

public class Admin {
    private static Admin admin = null;
    private HashMap<String,String> users;

    private Admin(){
        this.users = new HashMap<String,String>();
    }
    public static Admin getInstance(){
        if (admin == null){
            admin = new Admin();
        }
        return admin;
    }

    public void addUser(String u,String p){
        users.put(u,p);
    }

    public HashMap<String, String> getUsers() {
        return users;
    }
    public void setUsers(HashMap<String, String> users) {
        this.users = users;
    }
}
