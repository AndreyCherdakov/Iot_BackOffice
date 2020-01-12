package main.java.iot.mapper;

public interface IMapper<T, R> {

    public R entityToDto(T entity);
    public T dtoToEntity(R dto);
}
