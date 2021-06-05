package kodlamaio.hrms.core.utilities.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DtoConverterManager implements DtoConverterService {

    private final ModelMapper modelMapper;

    @Autowired
    public DtoConverterManager(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public <T> Object dtoToBaseClassConverter(Object sourceObject, Class<T> baseClass) {
        return this.modelMapper.map(sourceObject, baseClass);
    }

    @Override
    public <T, S> List<S> dtoToTargetClassConverter(List<T> sourceObjects, Class<S> targetClass) {
        return sourceObjects.stream().map(s -> modelMapper.map(s, targetClass)).collect(Collectors.toList());
    }
}
