package ex09.entities;

public abstract class Contact {
    private String name;
    private String primaryPhoneNumber;
    private String secondaryPhoneNumber;
    private String docId;

    public Contact(String name, String primaryPhoneNumber, String secondaryPhoneNumber, String docId){
        this.name = name;
        this.primaryPhoneNumber = primaryPhoneNumber;
        this.secondaryPhoneNumber = secondaryPhoneNumber;
        this.docId = docId;
    }

    public String getName(){
        return this.name;
    }

    public String getPrimaryPhoneNumber(){
        return this.primaryPhoneNumber;
    }

    public String getSecondaryPhoneNumber(){
        return this.secondaryPhoneNumber;
    }

    public String getDocId(){
        return this.docId;
    }

    @Override
    public String toString(){
        return String.format(
            "Name: %s%nPrimary phone number: %s%nSecondary phone number: %s%nDocument Id: %s%n",
            this.getName(),
            this.getPrimaryPhoneNumber(),
            this.getSecondaryPhoneNumber(),
            this.getDocId()
        );
    }
}
