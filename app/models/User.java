package app.models;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.math.BigInteger;
import java.security.spec.InvalidKeySpecException;


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
        setPassword(password);
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
    public void setPassword(String password){
        try{
            String passwordHash = generatePasswordHash(password);
            this.password = passwordHash;
        }catch(NoSuchAlgorithmException e){
            System.err.println(e);
            System.exit(1);
        }catch(InvalidKeySpecException e){
            System.err.println(e);
            System.exit(1);
        }
    }

    public boolean checkPassword(String password){
        boolean result = false;;
        try{
            result = validatePassword(password, this.password);
        }catch(NoSuchAlgorithmException e){
            System.err.println(e);
            System.exit(1);
        }
        catch(InvalidKeySpecException e){
            System.err.println(e);
            System.exit(1);
        }
        return result;
    }

    public User getUser(){
        return null;
    }

    private static String generatePasswordHash(String password) throws NoSuchAlgorithmException, InvalidKeySpecException{
        int iterations = 1000;
        char[] chars = password.toCharArray();
        byte[] salt = getSalt();

        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }

    private static byte[] getSalt() throws NoSuchAlgorithmException{
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }

    private static String toHex(byte[] array) throws NoSuchAlgorithmException{
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0){
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }

    private static boolean validatePassword(String originalPassword, String storedPassword) throws NoSuchAlgorithmException, InvalidKeySpecException{
        String[] parts = storedPassword.split(":");
        int iterations = Integer.parseInt(parts[0]);
        byte[] salt = fromHex(parts[1]);
        byte[] hash = fromHex(parts[2]);

        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] testHash = skf.generateSecret(spec).getEncoded();

        int diff = hash.length ^ testHash.length;
        for(int i = 0; i < hash.length && i < testHash.length; i++){
            diff |= hash[i] ^ testHash[i];
        }
        return diff == 0;
    }

    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException{
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++){
            bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }
}
