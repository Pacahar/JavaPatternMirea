package task6;

public class BuilderPattern {
    public static void main(String[] args) {
        AccountBuilder randomBuilder = new RandomAccountBuilder();
        AutomaticSignIn randomRegistration = new AutomaticSignIn(randomBuilder);

        Account account1 = randomRegistration.signIn();
        Account account2 = randomRegistration.signIn();

        System.out.println(account1);
        System.out.println(account2);
    }
}

class Account {

    private String name;
    private String surname;
    private String city;
    private String status;

    public Account() {
        super();
    }

    public Account(String name, String surname, String city, String status) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCity() {
        return city;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(String city) {
        this.city = city;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean doQualityCheck() {
        return (name != null && !name.trim().isEmpty())
                && (surname != null && !surname.trim().isEmpty())
                && (city != null && !city.trim().isEmpty())
                && (status != null && !status.trim().isEmpty());
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Account [name=").append(name).
                append(", surname=").append(surname).
                append(", city=").append(city).
                append(", status=").append(status).
                append("]");
        return builder.toString();
    }
}

interface AccountBuilder {

    public AccountBuilder specifyName();

    public AccountBuilder specifySurname();

    public AccountBuilder specifyCity();

    public AccountBuilder specifyStatus();

    // Создание аккаунта
    public Account build();
}

class RandomAccountBuilder implements AccountBuilder {

    private String name;
    private String surname;
    private String city;
    private String status;

    public RandomAccountBuilder() {
        super();
    }

    @Override
    public AccountBuilder specifyName() {
        this.name = RandomStringGenerator.generateRandomString(5);
        return this;
    }

    @Override
    public AccountBuilder specifySurname() {
        this.surname = RandomStringGenerator.generateRandomString(5);
        return this;
    }

    @Override
    public AccountBuilder specifyCity() {
        this.city = RandomStringGenerator.generateRandomString(5);
        return this;
    }

    @Override
    public AccountBuilder specifyStatus() {
        this.status = RandomStringGenerator.generateRandomString(5);
        return this;
    }

    @Override
    public Account build() {
        Account account = new Account(name, surname, city, status);
        if (account.doQualityCheck()) {
            return account;
        } else {
            System.out.println("Account assembly is incomplete.");
        }
        return null;
    }
}

class AutomaticSignIn {

    private AccountBuilder builder;

    public AutomaticSignIn(AccountBuilder builder) {
        super();
        this.builder = builder;
        if (this.builder == null) {
            throw new IllegalArgumentException("No builder - no account!");
        }
    }

    public Account signIn() {
        return builder.specifyName().specifySurname().
                specifyCity().specifyStatus().build();
    }
}