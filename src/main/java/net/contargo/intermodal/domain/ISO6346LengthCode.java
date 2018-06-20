package net.contargo.intermodal.domain;

import java.util.Arrays;
import java.util.Optional;


/**
 * Overview of valid ISO 6346 length codes and their according length in foot.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public enum ISO6346LengthCode {

    ONE('1', 10.0),
    TWO('2', 20.0),
    THREE('3', 30.0),
    FOUR('4', 40.0),
    A('A', 23.5),
    B('B', 24.0),
    C('C', 24.6),
    D('D', 24.5),
    E('E', 25.7),
    F('F', 26.6),
    G('G', 41.0),
    H('H', 43.0),
    K('K', 44.7),
    L('L', 45.0),
    M('M', 48.0),
    N('N', 49.0),
    P('P', 53.0);

    private char character;
    private Double lengthInFoot;

    ISO6346LengthCode(char character, Double lengthInFoot) {

        this.character = character;
        this.lengthInFoot = lengthInFoot;
    }

    public char getCharacter() {

        return character;
    }


    public Double getLengthInFoot() {

        return lengthInFoot;
    }


    public static Optional<ISO6346LengthCode> getByCharacter(char character) {

        return Arrays.stream(ISO6346LengthCode.values()).filter(code -> code.getCharacter() == character).findAny();
    }
}
