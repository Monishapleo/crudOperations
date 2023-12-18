//Model class 
public class UserDetails {
    private int uid;
    private String name;
    private String mailId;

    public UserDetails(String name, String mailId) {
        this.name = name;
        this.mailId = mailId;
    }

    public UserDetails(int uid, String name, String mailId) {
        this.uid = uid;
        this.name = name;
        this.mailId = mailId;
    }


    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }
}
