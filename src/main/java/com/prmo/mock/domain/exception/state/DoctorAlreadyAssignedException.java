package com.prmo.mock.domain.exception.state;

public class DoctorAlreadyAssignedException extends IllegalStateException {

    public DoctorAlreadyAssignedException() {
        super("Данный осмотр уже начат другим врачом.");
    }

}
