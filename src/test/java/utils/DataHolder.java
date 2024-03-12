package utils;

public class DataHolder {
    private static DataHolder instance;
    private String proposalID;
    private String proposalName;



    private DataHolder() {
        // Private constructor to prevent instantiation
    }

    public static DataHolder getInstance() {
        if (instance == null) {
            instance = new DataHolder();
        }
        return instance;
    }

    public String getProposalID() {
        return proposalID;
    }

    public void setProposalID(String proposalID) {
        this.proposalID = proposalID;
    }
    public String getProposalName() {
        return proposalName;
    }

    public void setProposalName(String proposalName) {
        this.proposalName = proposalName;
    }
}
