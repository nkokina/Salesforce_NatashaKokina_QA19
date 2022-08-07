package enums;

public enum LeadSource {
    ADVERTISEMENT("Advertisement"),
    CUSTOMER("Customer Event"),
    EMPLOYEE("Employee Referral"),
    EXTERNAL("External Referral"),
    GOOGLE("Google AdWords"),
    OTHER("Other"),
    PARTNER("Partner"),
    PURCHASED("Purchased List"),
    TRADE("Trade Show"),
    WEBINAR("Webinar"),
    WEBSITE("Website");

    public final String name;

    LeadSource(final String name) {
        this.name = name;
    }

    public String getName() {
        return this.name();
    }

    public static LeadSource fromString (String value) {
        for (LeadSource contactLeadSource : LeadSource.values()) {
            if (contactLeadSource.getName().equals(value)) {
                return contactLeadSource;
            }
        }
        return null;
    }
}

