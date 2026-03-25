package com.prmo.mock.domain.exception.validation;

public class InvalidOwnershipException extends ValidationException {

    public InvalidOwnershipException() {
        super("Нет доступа к данному осмотру");
    }

}
