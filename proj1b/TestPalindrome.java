import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("Noon"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("n"));
        assertTrue(palindrome.isPalindrome(""));

        OffByOne off = new OffByOne();
        assertFalse(palindrome.isPalindrome("noon", off));
        assertTrue(palindrome.isPalindrome("ab", off));
        assertTrue(palindrome.isPalindrome("flake", off));

        OffByN offN = new OffByN(5);
        assertFalse(palindrome.isPalindrome("noon", offN));
        assertTrue(palindrome.isPalindrome("af", offN));
        assertTrue(palindrome.isPalindrome("abf", offN));
        assertTrue(palindrome.isPalindrome("abczhgf", offN));





    }

}
