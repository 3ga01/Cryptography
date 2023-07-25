import java.math.BigInteger;
import java.util.Scanner;

public class DiffieHellma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the prime number (p): ");
        BigInteger p = new BigInteger(scanner.nextLine());

        System.out.print("Enter the generator (g): ");
        BigInteger g = new BigInteger(scanner.nextLine());

        System.out.print("Enter Alice's private key: ");
        BigInteger alicePrivate = new BigInteger(scanner.nextLine());

        System.out.print("Enter Bob's private key: ");
        BigInteger bobPrivate = new BigInteger(scanner.nextLine());

        // Alice and Bob compute their public keys
        BigInteger alicePublic = computePublicKey(g, p, alicePrivate);
        BigInteger bobPublic = computePublicKey(g, p, bobPrivate);

        // Alice and Bob exchange public keys and compute shared secrets
        BigInteger aliceSharedSecret = computeSharedSecret(bobPublic, p, alicePrivate);
        BigInteger bobSharedSecret = computeSharedSecret(alicePublic, p, bobPrivate);

        // Check if the shared secrets are the same (should be in a real scenario)
        System.out.println("Alice's shared secret: " + aliceSharedSecret.toString(16));
        System.out.println("Bob's shared secret: " + bobSharedSecret.toString(16));

        scanner.close();
    }

    // Compute the public key using private key
    private static BigInteger computePublicKey(BigInteger g, BigInteger p, BigInteger privateKey) {
        return g.modPow(privateKey, p);
    }

    // Compute the shared secret using private key and public key
    private static BigInteger computeSharedSecret(BigInteger publicKey, BigInteger p, BigInteger privateKey) {
        return publicKey.modPow(privateKey, p);
    }

}
