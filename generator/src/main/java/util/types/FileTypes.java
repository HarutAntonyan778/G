package util.types;

public enum FileTypes {

    TXT(".txt"),
    FEATURE(".feature"),
    JAVA(".java");

    private final String endsWith;

    FileTypes(final String endsWith) {
        this.endsWith = endsWith;
    }

    public String getEndsWith() {
        return endsWith;
    }
}
