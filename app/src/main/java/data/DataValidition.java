package data;

public class DataValidition {

    private String name;
    private String phone;

    public DataValidition(String name, String phone) {
        this.name = name;
        this.phone = phone;

    }
    public DataValidition() {

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
        if(!phone.isEmpty() && phone.length()==11)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean checkBoth()
    {
        if((!phone.isEmpty() && phone.length()==11) && !name.isEmpty())
        {
            return true;
        }
        return false;
    }

}
