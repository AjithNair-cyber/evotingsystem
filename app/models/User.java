package app.models;

public class User{
    private long personId;
    private String name;
    private String username;
    private String password;
    private String DOB;
    private String email;
    private String mobileNo;
    private Address address;


    public User(long personId, String name, String username, 
            String password, String DOB, String email, 
            String mobileNo, Address address){
        this.personId = personId;
        this.name = name;
        this.username = username;
        this.password = password;
        this.DOB = DOB;
        this.email = email;
        this.mobileNo = mobileNo;
        this.address = address;
    }

    public User(String name, String username, 
            String password, String DOB, String email, 
            String mobileNo, Address address){
        //-1 is an invalid id, correct id will be provided by the database upon inserting the User.
        this.personId = -1;
        this.name = name;
        this.username = username;
        this.password = password;
        this.DOB = DOB;
        this.email = email;
        this.mobileNo = mobileNo;
        this.address = address;
    }

    public long getId(){
        return personId;
    }

    public String getName(){
        return name;
    }

    public String getUsername(){
        return username;
    }

    public Address getAddress(){
        return address;
    }

    public long getAddressId(){
        return address.getId();
    }

    public String getEmail(){
        return email;
    }

    //The following functions will be implemented later.
    public void setPassword(){
    }

    public boolean checkPassword(){
        return false;
    }

    public User getUser(){
        return null;
    }

}
