import java.util.HashMap;
import java.util.Map;

public class MonoSubstitutionEncryption {
    public static void main(String[] args) {
        String plaintext = "This is a secret message.";
        String key = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String ciphertext = encrypt(plaintext, key);
        System.out.println("Ciphertext: " + ciphertext);
    }

    public static String encrypt(String plaintext, String key) {
        Map<Character, Character> encryptionMap = generateEncryptionMap(key);
        StringBuilder ciphertext = new StringBuilder();

        for (char c : plaintext.toCharArray()) {
            if (Character.isLetter(c)) {
                char encryptedChar = encryptionMap.get(Character.toUpperCase(c));
                ciphertext.append(Character.isUpperCase(c) ? encryptedChar : Character.toLowerCase(encryptedChar));
            } else {
                ciphertext.append(c);
            }
        }

        return ciphertext.toString();
    }

    public static Map<Character, Character> generateEncryptionMap(String key) {
        Map<Character, Character> encryptionMap = new HashMap<>();

        // Generate mapping for uppercase letters
        for (int i = 0; i < 26; i++) {
            char plainChar = (char) ('A' + i);
            char encryptedChar = key.charAt(i);
            encryptionMap.put(plainChar, encryptedChar);
        }

        // Generate mapping for lowercase letters
        for (int i = 0; i < 26; i++) {
            char plainChar = (char) ('a' + i);
            char encryptedChar = Character.toLowerCase(key.charAt(i));
            encryptionMap.put(plainChar, encryptedChar);
        }

        return encryptionMap;
    }
}
