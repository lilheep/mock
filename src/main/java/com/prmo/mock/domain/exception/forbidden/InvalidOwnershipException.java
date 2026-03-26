package com.prmo.mock.domain.exception.forbidden;

public class InvalidOwnershipException extends ForbiddenException {

    public InvalidOwnershipException() {
        super("Нет доступа к данному осмотру");
    }

}
