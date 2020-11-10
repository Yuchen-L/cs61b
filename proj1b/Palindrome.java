public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> que = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            char chr = word.charAt(i);
            que.addLast(chr);
        }
        return que;
    }

    public boolean isPalindrome(String word) {
        Deque d = wordToDeque(word);
        return isPalindromhelper(d);
//        for (int i = 0; i < d.size(); i++) {
//            if (d.get(i).equals(d.get(d.size() - i - 1))) {
//                continue;
//            } else {
//                return false;
//            }
//        }
//        return true;
    }

    private boolean isPalindromhelper(Deque dword) {
        if (dword.size() == 0 || dword.size() == 1) {
            return true;
        }
        if (dword.removeFirst().equals(dword.removeLast())) {
            return isPalindromhelper(dword);
        } else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        return isPalindromhelper(d, cc);
    }

    private boolean isPalindromhelper(Deque dword, CharacterComparator cc) {
        if (dword.size() == 0 || dword.size() == 1) {
            return true;
        }
        if (cc.equalChars((char) dword.removeFirst(), (char) dword.removeLast())) {
            return isPalindromhelper(dword, cc);
        } else {
            return false;
        }
    }
}
