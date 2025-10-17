package model.core.dto;

public class CreateUserRequest {
    private final String fName;
    private final String lName;

    public CreateUserRequest(String fName, String lName) {
        this.fName = fName;
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }
}
