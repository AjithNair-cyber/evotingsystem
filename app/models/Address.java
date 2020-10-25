package app.models;

public class Address{
    private long addressId;
    private String flatNo;
    private String state;
    private String city;
    private String sector;
    private String pinCode;
    private int constituencyId;

    public Address(long addressId, String flatNo, String state, String city,
            String sector, String pinCode, int constituencyId){
        this.addressId = addressId;
        this.flatNo = flatNo;
        this.state = state;
        this.city = city;
        this.sector = sector;
        this.pinCode = pinCode;
        this.constituencyId = constituencyId;
    }

    public Address(String flatNo, String state, String city,
            String sector, String pinCode, int constituencyId){
        this.addressId = -1;
        this.flatNo = flatNo;
        this.state = state;
        this.city = city;
        this.sector = sector;
        this.pinCode = pinCode;
        this.constituencyId = constituencyId;
    }

    public long getId(){
        return addressId;
    }

    public String getFlatNo(){
        return flatNo;
    }

    public String getState(){
        return state;
    }

    public String getCity(){
        return city;
    }

    public String getSector(){
        return sector;
    }

    public String getPinCode(){
        return pinCode;
    }

    public int getConstituencyId(){
        return constituencyId;
    }

}
