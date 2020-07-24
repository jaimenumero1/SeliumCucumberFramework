package domains;

/**
 * This class will be used for Cucumber DataTable mapping.
 * Create encapsulated fields for:
 * title, firstName, lastName, gender,dob, password,address, locality, region, postalCode, country, homePhone, mobilePhone, workPhone
 * Create getter methods for each field.
 *
 */

public class User {

    private String title;
    private String firstName;
    private String lastName;
    private char gender;
    private String dob;
    private String password;
    private String address;
    private String locality;
    private String region;
    private String postalCode;
    private String country;

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getLocality() {
        return locality;
    }

    public String getRegion() {
        return region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }
}



