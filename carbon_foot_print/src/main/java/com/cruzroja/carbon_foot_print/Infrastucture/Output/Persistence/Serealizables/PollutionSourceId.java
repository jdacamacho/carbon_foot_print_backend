package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables;

import java.io.Serializable;
import java.util.Objects;

public class PollutionSourceId implements Serializable {
    private Long pollution;
    private Long source;

    public PollutionSourceId() {

    }

    public PollutionSourceId(Long pollution, Long source) {
        this.pollution = pollution;
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        PollutionSourceId that = (PollutionSourceId) o;
        return Objects.equals(pollution, that.pollution) && Objects.equals(source, that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pollution, this.source);
    }
}
