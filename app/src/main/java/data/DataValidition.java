package data;

public class DataValidition {

    private String name;
    private String phone;
    private String password;

    public DataValidition(String name, String phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public DataValidition(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public boolean checkName()
    {
        if(name.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean checkPhone()
    {
        if(phone.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    private boolean checkPassword()
    {
        if(password.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean validSignUp()
    {
        if(checkName() && checkPhone() && checkPassword())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean validLogin()
    {
        if(checkPhone() && checkPassword())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
