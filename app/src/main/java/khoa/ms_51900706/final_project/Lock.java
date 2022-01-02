package khoa.ms_51900706.final_project;



public class Lock {
    int id;
    public String password;
    public String isLock;


    public String flag;

    public Lock(int id, String password, String isLock, String flag) {
        this.id = id;
        this.password = password;
        this.isLock = isLock;
        this.flag = flag;
    }

    public Lock(String password, String isLock, String flag) {
        super();
        this.id = id;
        this.password = password;
        this.isLock = isLock;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLock() {
        return isLock;
    }

    public void setLock(String lock) {
        isLock = lock;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", isLock='" + isLock + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
