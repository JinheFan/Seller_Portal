package com.lazada.SellerPortal.common;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;


@Component
public class Utils {
    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz";

    Environment environment;

    public Utils(Environment environment) {
        this.environment = environment;
    }

    public String generateUserId(int length) {
        return generateRandomString(length);
    }

    public String generateAddressId(int length) {
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder builder = new StringBuilder();
        while (length-- > 0) {
            builder.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return builder.toString();
    }
}

