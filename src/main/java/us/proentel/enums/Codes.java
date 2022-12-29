package us.proentel.enums;

public enum Codes {

    IDENTIFICATION_CANNOT_BE_NULL("app.invalidFieldsDataError", "identification cannot be null"),
    NAME_CANNOT_BE_NULL("app.invalidFieldsDataError", "name cannot be null");

    /** The error code. */
    private String errorCode;
    /**
     * Default (server side) error message. The UI can provide a more meaningful message based on the error code, if needed.
     */
    private String errorMessage;

    /**
     * Gets the error code.
     *
     * @return the error
     */
    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Instantiates a new codes.
     *
     * @param error
     *          the error
     */
    private Codes(String error) {
        this.errorCode = error;
    }

    /**
     * Instantiates a new codes.
     *
     * @param error
     *          the error
     */
    private Codes(String error, String errorMessage) {
        this.errorCode = error;
        this.errorMessage = errorMessage;
    }


}
