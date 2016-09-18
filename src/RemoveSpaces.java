import java.util.HashSet;

/**
 * Created by ravinderk on 7/5/2016.
 */
public class RemoveSpaces {
    public static void main(String[] args) {
        System.out.println(removeSpaces(new StringBuffer("   Hello Geeks . Welcome   to  GeeksforGeeks   .    ")));
      }

    static enum STATE {
        SPACE, WORD
    }
    private static StringBuffer removeSpaces(StringBuffer str) {
        STATE state = STATE.SPACE;
        int new_pos = 0;
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if(Character.isSpaceChar(str.charAt(i))) {
                if(state == STATE.WORD) {
                    str.setCharAt(new_pos, str.charAt(i));
                    new_pos++;
                    state = STATE.SPACE;
                }
            } else {
                if(state == STATE.SPACE) {
                    state = STATE.WORD;
                }
                if(isPunctuationChar(str.charAt(i))) {
                    new_pos--;
                }
                str.setCharAt(new_pos, str.charAt(i));
                new_pos++;
            }
        }
        if(Character.isSpaceChar(str.charAt(new_pos-1))) {
            new_pos--;
        }
        str.setCharAt(new_pos, '\0');
        str.setLength(new_pos);
        return str;
    }

    private static boolean isPunctuationChar(char c) {
        return c == '.' || c == ',' || c == ';';
    }
}