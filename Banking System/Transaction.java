
class Transaction {
    int transactionId; // unique
    String transactionType; // deposit or widraw
    int amount;

    public Transaction(int transactionId, String transactionType, int amount) {
        this.transactionId = transactionId;
        this.transactionType = transactionType;
        this.amount = amount;
    }

    public int id() {
        return transactionId;
    }

    public String gettype() {
        return transactionType;
    }

    public int getamount() {
        return amount;
    }

}
