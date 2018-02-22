package tst.controller.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import tst.controller.entity.Role;
import tst.controller.entity.User;

import java.io.IOException;

public class CustomUserSerializer extends JsonSerializer<User> {
    @Override
    public void serialize(User user, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        jgen.writeNumberField("id", user.getId());
        jgen.writeStringField("firstName", user.getFirstName());
        jgen.writeStringField("lastName", user.getLastName());

        if (user.getRoles() != null) {
            jgen.writeArrayFieldStart("roles");
            for(Role role: user.getRoles()) {
                jgen.writeString(role.getName());
            }
            jgen.writeEndArray();
        }

        jgen.writeEndObject();
    }
}
