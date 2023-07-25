import java.util.*;

public class MonoSubstitutionBruteForce {
    public static void main(String[] args) {
        String ciphertext = "Ziol ol q ltektz dtllqut";
        bruteForceAttack(ciphertext);
    }

    public static void bruteForceAttack(String ciphertext) {
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        List<String> possibleSolutions = new ArrayList<>();

        for (int shift = 0; shift < alphabet.length; shift++) {
            char[] plaintext = new char[ciphertext.length()];

            for (int i = 0; i < ciphertext.length(); i++) {
                char c = ciphertext.charAt(i);
                if (Character.isLetter(c)) {
                    int index = Character.toLowerCase(c) - 'a';
                    int shiftedIndex = (index - shift + 26) % 26;
                    char decryptedChar = Character.isUpperCase(c) ? Character.toUpperCase(alphabet[shiftedIndex])
                            : alphabet[shiftedIndex];
                    plaintext[i] = decryptedChar;
                } else {
                    plaintext[i] = c;
                }
            }

            possibleSolutions.add(new String(plaintext));
        }

        System.out.println("Possible solutions:");
        for (String solution : possibleSolutions) {
            System.out.println(solution);
        }
    }
}
