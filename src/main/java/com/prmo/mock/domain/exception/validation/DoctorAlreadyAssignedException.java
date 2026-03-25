package com.prmo.mock.domain.exception.validation;

public class DoctorAlreadyAssignedException extends ValidationException {

    public DoctorAlreadyAssignedException() {
        super("Данный осмотр уже начат другим врачом.");
    }

}
