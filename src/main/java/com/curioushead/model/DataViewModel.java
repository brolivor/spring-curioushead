package com.curioushead.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.SecureRandom;
import java.util.UUID;

@Getter
@Setter
@Document(collection = "profile_configuration")
public class DataViewModel {
    String id = generateType1UUID().toString();
    @Id
    String name;
    String schema;
    private static SecureRandom random = new SecureRandom();

    public static UUID generateType1UUID() {
        long most64SigBits = get64MostSignificantBitsForVersion1();
        long least64SigBits = get64LeastSignificantBitsForVersion1();
        return new UUID(most64SigBits, least64SigBits);
    }

    private static long get64LeastSignificantBitsForVersion1() {
        int rValue = random.nextInt();
        long random63BitLong = rValue & 0x3FFFFFFFFFFFFFFFL;
        long variant3BitFlag = 0x8000000000000000L;
        return random63BitLong | variant3BitFlag;
    }

    private static long get64MostSignificantBitsForVersion1() {
        final long currentTimeMillis = System.currentTimeMillis();
        final long time_low = (currentTimeMillis & 0x0000_0000_FFFF_FFFFL) << 32;
        final long time_mid = ((currentTimeMillis >> 32) & 0xFFFF) << 16;
        final long version = 1 << 12;
        final long time_hi = ((currentTimeMillis >> 48) & 0x0FFF);
        return time_low | time_mid | version | time_hi;
    }


}
