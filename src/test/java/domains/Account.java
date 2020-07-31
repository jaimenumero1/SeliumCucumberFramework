package domains;

public class Account {
    String type;
    String ownershipType;
    String accountName;
    double initDeposit;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        this.ownershipType = ownershipType;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getInitDeposit() {
        return initDeposit;
    }

    public void setInitDeposit(String initDeposit) {
        this.initDeposit = Double.parseDouble(initDeposit);
    }

    public void setInitDeposit(double initDeposit) {
        this.initDeposit = (initDeposit);
    }
}
