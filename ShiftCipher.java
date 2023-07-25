public class ShiftCipher {
    public static void main(String[] args) {
        int shift = 17;
        String plaintext = "I am a cipher text";
        String ciphertext = encrypt(plaintext, shift);
        System.out.println("Ciphertext: " + ciphertext);
    }

    public static String encrypt(String plaintext, int shift) {
        StringBuilder ciphertext = new StringBuilder();
        int length = plaintext.length();

        for (int i = 0; i < length; i++) {
            char c = plaintext.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + shift) % 26 + base);
            }

            ciphertext.append(c);
        }

        return ciphertext.toString();
    }
}
