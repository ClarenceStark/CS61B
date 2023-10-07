import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('t', 's'));
        assertFalse(offByOne.equalChars('j', 'c'));
        assertFalse(offByOne.equalChars('h', 's'));
    }
    // Your tests go here.
}
