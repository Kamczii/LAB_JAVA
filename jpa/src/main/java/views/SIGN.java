package views;

public enum SIGN {
    EQ("="),
    GT(">"),
    LT("<");

    final String label;

    SIGN(String s) {
        label = s;
    }

    public String getLabel() {
        return label;
    }
}
