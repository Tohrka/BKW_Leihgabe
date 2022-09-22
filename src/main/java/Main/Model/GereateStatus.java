package Main.Model;

public enum GereateStatus {
    GELAGERT, VERLIEHEN, BESCHAEDIGT, WARTUNG;
    public static GereateStatus getStatus(String status) {
        switch (status.toUpperCase()) {
            case "GELAGERT":
                return GELAGERT;
            case "VERLIEHEN":
                return VERLIEHEN;
            case "BESCHAEDIGT":
                return BESCHAEDIGT;
            case "WARTUNG":
                return WARTUNG;
            default:
                return null;
        }
    }
}
