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
        type = type.trim().toLowerCase();
        if(!type.equals("standard") || !type.equals("interest"))
            type = "standard";

        this.type = type.substring(0, 1).toUpperCase() + type.substring(1);
    }

    public String getOwnershipType() {
        return ownershipType;
    }

    public void setOwnershipType(String ownershipType) {
        ownershipType = ownershipType.trim().toLowerCase();

        if(!ownershipType.equals("individual")
                || !ownershipType.equals("joint"))
            ownershipType = "individual";

        this.ownershipType = ownershipType.substring(0, 1).toUpperCase()
                + ownershipType.substring(1);
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
