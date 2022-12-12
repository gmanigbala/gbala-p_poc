import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class ShiftJisTest {
    public static void main(String[] args) {
        // ??_??????????2019?1?10??;[2019????]????DC?????????????
        String s = "\u7e70\u623b\u005f\u65e5\u7d4c\u9078\u6319\u30b7\u30b9\u30c6\u30e0\u4fdd\u5b88\u0032\u0030\u0031\u0039\u5e74\u0031\u6708\u0031\u0030\u65e5\uff5e\u003b\u005b\u0032\u0030\u0031\u0039\u5e74\u5ea6\u66f4\u65b0\u005d\u6a2a\u6d5c\u7b2c\uff11\u0044\u0043\u30b3\u30ed\u30b1\u2015\u30b7\u30e7\u30f3\uff08\uff12\u30e9\u30c3\u30af\uff09";
        Charset charset = Charset.forName("Shift-JIS");
        for (char c : s.toCharArray()) {
            CharsetEncoder encoder = charset.newEncoder();
            if (!encoder.canEncode(c)) {
                System.out.printf("%s (U+%04X)%n", c, (int) c);
            }
        }
        
        try {
            charset.newEncoder().encode(CharBuffer.wrap(s));
        } catch (CharacterCodingException e) {
            // java.nio.charset.UnmappableCharacterException: Input length = 1
            e.printStackTrace();
        }
    }
}