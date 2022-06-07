package co.edu.unipilito;

public class User {
    static int id, gender;
    static String FullName, UserName, eMail, Password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", gender=" + gender +
                ", FullName='" + FullName + '\'' +
                ", UserName='" + UserName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public User() {
    }

    public static int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public static String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public static String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public static String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public static String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
