package com.prmo.mock.domain.exception.validation;

public class DoctorAlreadyStartedException extends ValidationException {

    public DoctorAlreadyStartedException() {
        super("Водитель не прошел осмотр");
    }

}
