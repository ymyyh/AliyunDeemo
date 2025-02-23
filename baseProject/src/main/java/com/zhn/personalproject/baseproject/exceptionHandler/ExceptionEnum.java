package com.zhn.personalproject.baseproject.exceptionHandler;

public enum ExceptionEnum {
    RUNTIME_EXCEPTION("runtime_exception", "runtime_exception"),
    IO_EXCEPTION("io_exception", "io_exception"),
    SQL_EXCEPTION("sql_exception", "sql_exception"),
    CLASS_NOT_FOUND_EXCEPTION("class_not_found_exception", "class_not_found_exception");

    ExceptionEnum(String key, String value){
        this.key = key;
        this.value = value;
    }
    public String key;
    public String value;
}
