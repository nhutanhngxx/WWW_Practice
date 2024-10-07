package vn.com.iuh.fit.week02.converters;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.ws.rs.ext.ContextResolver;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperContextResolver implements ContextResolver<ObjectMapper> {
    final ObjectMapper mapper = new ObjectMapper();
    public ObjectMapperContextResolver() {
        mapper.registerModule(new JavaTimeModule());
    }
    @Override
    public ObjectMapper getContext(Class<?> type) {
        return mapper;
    }
}
