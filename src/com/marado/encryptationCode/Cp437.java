package com.marado.encryptationCode;

public enum Cp437 {
    char1(1, '\u0000'),
    char2(2, '\u263A'),
    char3(3, '\u2665'),
    char4(4, '\u2666'),
    char5(5, '\u2663'),
    char6(6, '\u2660'),
    char7(7, '\u2022'),
    char8(8, '\u25D8'),
    char9(9, '\u25CB'),
    char10(10, '\u263A'),
    char11(11, '\u263A'),
    char12(12, '\u263A'),
    char13(13, '\u263A'),
    char14(14, '\u263A'),
    char15(15, '\u263A'),
    char16(16, '\u263A'),
    ;

    private final int num;
    private final char charCode;

    private Cp437(int num, char charCode){
        this.num = num;
        this.charCode = charCode;
    }
}
