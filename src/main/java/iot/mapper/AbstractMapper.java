package main.java.iot.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class AbstractMapper<E, D> implements IMapper<E, D> {

    @Autowired
    private ModelMapper modelMapper;

    private Class<E> entityClass;
    private Class<D> dtoClass;

    public AbstractMapper(Class<E> entityClass, Class<D> dtoClass) {
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public D entityToDto(E entity) {
        return Objects.isNull(entity) ? null : modelMapper.map(entity, dtoClass);
    }

    @Override
    public E dtoToEntity(D dto) {
        return Objects.isNull(dto) ? null : modelMapper.map(dto, entityClass);
    }

    public Converter<E, D> toEntityConverter(){
        return data -> {
            E source = data.getSource();
            D destination = data.getDestination();
            mapSpecificFieldsToEntity(source, destination);
            return data.getDestination();
        };
    }

    public Converter<D, E> toDtoConverter() {
        return data -> {
          D source = data.getSource();
          E destination = data.getDestination();
          mapSpecificFieldsToDto(source, destination);
          return data.getDestination();
        };
    }

    private void mapSpecificFieldsToDto(D source, E destination) {
    }

    private void mapSpecificFieldsToEntity(E source, D destination) {
    }
}
