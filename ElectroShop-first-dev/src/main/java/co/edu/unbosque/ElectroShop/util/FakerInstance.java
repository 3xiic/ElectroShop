package co.edu.unbosque.ElectroShop.util;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerInstance {
    static Faker fakerEsp = Faker.instance(new Locale("es", "CO"));

    /**
     * Returns a Faker instance configured for the Spanish language in Colombia.
     *
     * @return A Faker instance with the Spanish language in Colombia locale.
     */
    public static Faker getFakerEsp() {
        return fakerEsp;
    }
}
