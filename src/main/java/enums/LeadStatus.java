package enums;

public enum LeadStatus {
    UNQUALIFIED("Unqualified"),
    NEW("New"),
    WORKING("Working"),
    NURTURING("Nurturing"),
    QUALIFIED("Qualified");

    public final String name;

    LeadStatus(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name();
    }

    public static LeadStatus fromString(String value) {
        for (LeadStatus contactLeadStatus : LeadStatus.values()) {
            if (contactLeadStatus.getName().equals(value)) {
                return contactLeadStatus;
            }
        }
        return null;
    }
}



