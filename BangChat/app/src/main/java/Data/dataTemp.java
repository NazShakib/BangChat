package Data;

public class dataTemp {

    private String name;
    private int phoneNumber;
    private String password;

    public dataTemp(String name, int phoneNumber, String password) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getPassword() {

        if(password==this.password)
        {
            return true;
        }
        return false;
    }
    private void setPassword(String password) {
        this.password = password;
    }


}
