public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for(int i = 0; i < word.length(); i += 1) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    private boolean isPalindromeD(Deque d){
        if (d.isEmpty() || d.size() == 1) {
            return true;
        } else {
            return (d.removeFirst() == d.removeLast()) && isPalindromeD(d);
        }
    }
    private boolean isPalindromeD(Deque d, CharacterComparator c){
        if (d.isEmpty() || d.size() == 1) {
            return true;
        } else{
            char f = (char) d.removeFirst();
            char l = (char) d.removeLast();
            return (c.equalChars(f, l) || f == l) && isPalindromeD(d, c);
        }
    }
    public boolean isPalindrome(String word) {
        Deque deque = wordToDeque(word);
        return isPalindromeD(deque);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque deque = wordToDeque(word);
        cc = new OffByOne();
        return isPalindromeD(deque, cc);
    }
}
