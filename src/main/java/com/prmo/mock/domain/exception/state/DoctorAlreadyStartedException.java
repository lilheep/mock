package com.prmo.mock.domain.exception.state;

public class DoctorAlreadyStartedException extends IllegalStateException {

    public DoctorAlreadyStartedException() {
        super("Водитель не прошел осмотр");
    }

}
