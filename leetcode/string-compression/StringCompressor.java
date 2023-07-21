import java.util.Arrays;

public class StringCompressor {

    public StringCompressor() {
    };

    public static int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }

        char element;
        int writePos = 0;
        int counter = 0;
        int readPos = 0;
        while (readPos < chars.length) {
            counter = 0;
            element = chars[readPos];
            while (counter < chars.length && readPos < chars.length && element == chars[readPos]) {
                readPos++;
                counter++;
            }

            chars[writePos++] = element;

            if (counter > 1) {
                for (char c : String.valueOf(counter).toCharArray()) {
                    chars[writePos++] = c;
                }
            }
        }

        return writePos;
    }
}
