import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    /*
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.

    // Your tests go here.
    Uncomment this class once you've created your CharacterComparator interface and OffByOne class. **/

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testequalChars() {
        assertFalse(offByOne.equalChars('a', 'a'));
        assertTrue(offByOne.equalChars('a','b'));

    }
}
