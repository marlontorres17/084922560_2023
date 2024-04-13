package com.sena.servicesecurity.DTO;

public interface IClienteDTO extends IGenericDto{
	String getCode();
    void setCode(String code);
    String getFirstName();
    void setFirstName(String firstName);
    String getLastName();
    void setLastName(String lastName);
}
