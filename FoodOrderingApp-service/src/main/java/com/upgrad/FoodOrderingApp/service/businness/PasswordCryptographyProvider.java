package com.upgrad.FoodOrderingApp.service.businness;


import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Random;


@Component
public class PasswordCryptographyProvider {

    private static String SECRET_KEY_ALGORITHM = "PBKDF2WithHmacSHA512";
    private static int HASHING_ITERATIONS = 1000;
    private static int HASHING_KEY_LENGTH = 64;
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    /**
     * This method generates Salt and hashed Password
     *
     * @param password char array.
     * @return String array with [0] encoded salt [1] hashed password.
     */
    public String[] encrypt(final String password) {
        byte[] salt = generateSaltBytes();
        byte[] hashedPassword = hashPassword(password.toCharArray(), salt);
        return new String[]{getBase64EncodedBytesAsString(salt), bytesToHex(hashedPassword)};
    }

    /**
     * This method re-generates hashed Password from raw-password and salt.
     * This will be used during authentication.
     *
     * @param password char array.
     * @param salt     byte array.
     * @return byte array of hashed password.
     */
    public static String encrypt(final String password, String salt) {
        return bytesToHex(hashPassword(password.toCharArray(), getBase64DecodedStringAsBytes(salt)));
    }

    /**
     * This method generates Salt
     *
     * @return 32 bytes long array
     */
    private static byte[] generateSaltBytes() {
        final Random random = new SecureRandom();
        byte[] saltBytes = new byte[32];
        random.nextBytes(saltBytes);
        return saltBytes;
    }

    /**
     * This method generates hashed Password
     *
     * @param password char array.
     * @param salt     byte array.
     * @return byte array of hashed password.
     */
    private static byte[] hashPassword(final char[] password, final byte[] salt) {
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance(SECRET_KEY_ALGORITHM);
            PBEKeySpec spec = new PBEKeySpec(password, salt, HASHING_ITERATIONS, HASHING_KEY_LENGTH);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    private static String getBase64EncodedBytesAsString(byte bytes[]) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    private static byte[] getBase64DecodedStringAsBytes(String decode) {
        return Base64.getDecoder().decode(decode);
    }
}


