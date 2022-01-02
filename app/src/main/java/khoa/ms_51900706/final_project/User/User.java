package khoa.ms_51900706.final_project.User;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private String email, uid;
    private String image;

    public User(String uid, String name, String email, String image) {
        this.uid = uid;
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public User() {

    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
