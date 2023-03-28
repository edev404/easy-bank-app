package tech.edev404.easybank.model.mapper;

public interface GenericMapper<P, D> {

    P dtoToPojo(D dto);
    D pojoToDto(P pojo);
    
}
