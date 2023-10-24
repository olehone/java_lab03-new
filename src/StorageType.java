public enum StorageType {
    KILOGRAM("kg"),
    PIECE("pc");
    private String abbreviation;
    StorageType(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
