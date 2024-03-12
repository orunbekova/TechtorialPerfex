package utils;

public class DataHolder {
    private static DataHolder instance;
    private String proposalID;

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
}
