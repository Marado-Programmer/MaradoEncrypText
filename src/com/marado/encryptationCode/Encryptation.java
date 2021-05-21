package com.marado.encryptationCode;

import java.io.UnsupportedEncodingException;

public class Encryptation {

    static final int LETTERSONALPHABET = 26;

    private static int[] lettersToNums(String text){
        char[] textChars = new char[text.length()];
        int[] charInt = new int[textChars.length + 1];
        for (int i = 0; i < text.length(); i++){
            textChars[i] = text.charAt(i);
            if (textChars[i] >= 'a' && textChars[i] <= 'z')
                charInt[i] = textChars[i] - 96;
            else if (textChars[i] >= 'A' && textChars[i] <= 'Z')
                charInt[i] = textChars[i] - 64 + LETTERSONALPHABET;
            else
                charInt[i] = 0;
            System.out.println(charInt[i]);
        }
        charInt[charInt.length - 1] = 0;
        return charInt;
    }

    private static String transformNums(int[] nums) throws UnsupportedEncodingException {
        String transformedText = "";
        int reminder = 0;
        boolean singleNums = false;
        for (int i = 0; i < nums.length - 1; i++){
            System.out.println(nums[i]);
            System.out.println(transformedText);
            System.out.println(reminder+"\n");
            if (nums[i] >= 0 && nums[i] <= 26) {
                if (nums[i+1] > 0) {
                    if (Math.ceil((nums[i] + reminder) / nums[i + 1]) < 10){
                        if (!singleNums) {
                            singleNums = true;
                            transformedText += "\\";
                        }
                        transformedText += (int) Math.ceil((nums[i] + reminder) / nums[i + 1]);
                    }else{
                        singleNums = false;
                        transformedText += "/" + (int)Math.ceil((nums[i] + reminder) / nums[i + 1]);
                    }
                    reminder = (nums[i] + reminder) % nums[i + 1];
                }else {
                    transformedText += altWinCode(nums[i] + reminder);
                    reminder = 0;
                }
            }else if (nums[i] >= 1 + LETTERSONALPHABET && nums[i] <= 26 + LETTERSONALPHABET)
                if ((nums[i] + reminder) * nums[i+1] < 10) {
                    if (!singleNums) {
                        singleNums = true;
                        transformedText += "\\";
                    }
                    transformedText += (nums[i] - LETTERSONALPHABET + reminder) * nums[i + 1];
                }else{
                    singleNums = false;
                    transformedText += "/" + (nums[i] - LETTERSONALPHABET + reminder) * nums[i + 1];
                }
        }
        return transformedText;
    }

    private static char altWinCode(int codePoint) throws UnsupportedEncodingException {
        char character = new String(new byte[] { (byte) codePoint }, "Cp437").charAt(0);
        return character;
    }

    protected static String Encrypt(String text) throws UnsupportedEncodingException {
        String encryptedText;
        encryptedText = transformNums(lettersToNums(text));
        return encryptedText;
    }

}
