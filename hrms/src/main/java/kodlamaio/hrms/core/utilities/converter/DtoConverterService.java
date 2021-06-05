package kodlamaio.hrms.core.utilities.converter;

import java.util.List;

public interface DtoConverterService {
    <T> Object dtoToBaseClassConverter(Object sourceObject, Class<T> baseClass);
    <T, S> List<S> dtoToTargetClassConverter(List<T> sourceObjects, Class<S> targetClass);
}
