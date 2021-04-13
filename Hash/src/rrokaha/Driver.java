/**
 * Rishant Rokaha
 * Professor Vohra
 * Design and Analysis of Algorithms
 * 28 March 2021
 * Assignment 8
 */


package rrokaha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Driver {

    //main method
    public static void main(String[] args) throws NoSuchAlgorithmException {

        //create an instance of OurDictionary
        DictionaryInterface<String, String> passwordVault = new OurDictionary<>();

        //create an array of byte
        byte[] secureHash = createSecureHash("kjw7po09");
        String hex = bytesToHex(secureHash);
        passwordVault.add("uniqpoet", hex);

        secureHash = createSecureHash("eh7jfh89n");
        hex = bytesToHex(secureHash);
        passwordVault.add("yamabuddha", hex);

        secureHash = createSecureHash("leri93ubu");
        hex = bytesToHex(secureHash);
        passwordVault.add("easi12", hex);

        secureHash = createSecureHash("wuyrv8nd");
        hex = bytesToHex(secureHash);
        passwordVault.add("vten10", hex);

        secureHash = createSecureHash("ioe1yrw");
        hex = bytesToHex(secureHash);
        passwordVault.add("alpatra", hex);




        Scanner input = new Scanner(System.in);

        //input Username
        System.out.println("Please enter your Username : ");
        String enterUsername = input.nextLine();
        //retrieve password
        String realPassword = passwordVault.getValue(enterUsername);

        //check if username exists
        if (passwordVault.contains(enterUsername)) {

            //define attempts
            int attempt = 3;
            boolean success = false;

            while (!success) {
                //input password and create secureHash
                System.out.println("Please enter your Password : ");
                String enterPassword = input.nextLine();
                byte[] secureHashGuess = createSecureHash(enterPassword);
                String hexGuess = bytesToHex(secureHashGuess);

                //check if password match
                if (realPassword.equals(hexGuess)) {
                    System.out.println("You are successfully logged in!!!");
                    success = true;

                }
                // if password doesn't match
                else {
                    System.out.println("Incorrect password");
                    attempt -= 1;
                    System.out.println("You have " + attempt + " attempts remaining");

                    //if attempts exceed 3 times
                    if (attempt == 0) {
                        System.out.println("Your account has been blocked for multiple invalid attempts. Please contact administrator !!!");
                        break;
                    }//end if

                }//end if else

            }//end while

        }//end if

        //if username doesn't exists
        else{
            System.out.println("Username Wrong !!! You have been blocked lol");
        }//end else


    }//end main


    //create SecureHash Method
    public static byte[] createSecureHash(String guess) throws NoSuchAlgorithmException {
        //Create the MessengerDigest object
        MessageDigest myDigest = MessageDigest.getInstance("SHA-512");
        //Update the object with the hash of userinput
        myDigest.update(guess.getBytes());
        //Get the SHA-512 hash from the object
        byte byteHashValue[] = myDigest.digest();

        return byteHashValue;
    }//end createSecureHash Method


    //convert byte array To Hex for display purpose
    public static String bytesToHex(byte[] byteHashValue) {
        //create an instance of StringBuffer
        StringBuffer hexHash = new StringBuffer();
        for (int i = 0; i < byteHashValue.length; i++) {
            String hexChar = Integer.toHexString(0xff & byteHashValue[i]);
            if (hexChar.length() == 1) {
                hexHash.append('0');
            }//end if

            hexHash.append(hexChar);

        }//end for

        return hexHash.toString();

    }//end bytestoHex method


}//end Class
