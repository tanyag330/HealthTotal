package healthtotal.example.com.healthtotal.models;

/**
 * Created by Admin on 8/23/2016.
 */
public class LoginSignUpDetails {

    String name,email,password,bloodgroup,phnno,address;
    Integer age;

    public LoginSignUpDetails(String name, String email, String password, String bloodgroup, String phnno, String address, Integer age) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.bloodgroup = bloodgroup;
        this.phnno = phnno;
        this.address = address;
        this.age = age;
    }

    public void setName(String name)
    {
        this.name=name;
    }
    public String getName()
    {
        return this.name;
    }
    public void setAge(Integer age)
    {
        this.age=age;
    }
    public Integer getAge()
    {
        return this.age;
    }
    public void setEmail(String email)
    {
        this.email=email;
    }
    public String getEmail()
    {
        return this.email;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getPassword()
    {
        return this.password;
    }
    public void setBloodgroup(String bloodgroup)
    {
        this.bloodgroup=bloodgroup;
    }
    public String getBloodgroup()
    {
        return  this.bloodgroup;
    }
    public void setPhnno(String phnno)
    {
        this.phnno=phnno;
    }
    public String getPhnno()
    {
        return this.phnno;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public String getAddress()
    {
        return this.address;
    }




}
