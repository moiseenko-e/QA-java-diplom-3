package praktikum.user;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static User random() {
        return new User(RandomStringUtils.randomAlphabetic(10) + "@test.com", "012345", RandomStringUtils.randomAlphabetic(10));
    }
}
