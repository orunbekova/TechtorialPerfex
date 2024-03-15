package utils;

public class DataHolder {
    private static DataHolder instance;
    private static String proposalID;
    private static String proposalName;



    private DataHolder() {
        // Private constructor to prevent instantiation
    }

    public static DataHolder getInstance() {
        if (instance == null) {
            instance = new DataHolder();
        }
        return instance;
    }

    public static String getProposalID() {
        return proposalID;
    }

    public static void setProposalID(String proposalID1) {
        proposalID = proposalID1;
    }
    public static String getProposalName() {
        return proposalName;
    }

    public static  void setProposalName(String proposalName1) {
        proposalName = proposalName1;
    }
}
