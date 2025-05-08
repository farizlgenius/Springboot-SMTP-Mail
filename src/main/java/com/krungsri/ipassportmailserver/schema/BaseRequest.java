package com.krungsri.ipassportmailserver.schema;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class BaseRequest implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "'uuid' field is require in request body.")
    private UUID uuid;


    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }



}
