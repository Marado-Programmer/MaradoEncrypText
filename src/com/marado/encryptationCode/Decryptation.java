package com.marado.encryptationCode;

public class Decryptation {

    public static String numsToLetters(int[] nums){
        String decryptedText = "";
        char[] charChars = new char[nums.length];
        for(int i = 0; i < nums.length; i++){
            if (nums[i] == 0)
                charChars[i] = ' ';
            else
                charChars[i] = (char) (nums[i] + 96);
            decryptedText += charChars[i];
        }
        return decryptedText;
    }

}
