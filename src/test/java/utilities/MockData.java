package utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import net.bytebuddy.asm.Advice;

import java.util.Locale;
import java.util.Random;

/**
 * 1. Create a method that generates Random Email using JavaFaker library.
 * generateRandomEmail() should return random email
 * Use FakeValuesService bothify() method. Ex: fakeValuesService.bothify(new Faker().name().firstName() +"####@testemail.com");
 * 2. Create a method that generates Random SSN using Random() library.
 * SSN should be 9-digits
 */
public class MockData {

    private FakeValuesService fakeValuesService =
            new FakeValuesService(new Locale("en-US"), new RandomService());

    public String generateRandomEmail() {
        String email = fakeValuesService.bothify(new Faker().name().firstName() + "####@testemail.com");
        return email;
    }

    public String generateRandomSsn(){
        String ssn = String.format("%09d", new Random().nextInt(10000000));
        return ssn;
    }



}
