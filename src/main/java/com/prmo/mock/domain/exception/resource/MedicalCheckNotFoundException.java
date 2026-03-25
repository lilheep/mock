package com.prmo.mock.domain.exception.resource;

public class MedicalCheckNotFoundException extends ResourceNotFoundException {

    public MedicalCheckNotFoundException() {
        super("Осмотр не найден.");
    }

}
