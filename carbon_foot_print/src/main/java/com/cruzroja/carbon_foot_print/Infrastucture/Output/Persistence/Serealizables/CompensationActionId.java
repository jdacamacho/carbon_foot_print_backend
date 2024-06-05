package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables;

import java.io.Serializable;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompensationActionId implements Serializable {
    private Long action;
    private Long plan;

    public CompensationActionId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CompensationActionId that = (CompensationActionId) o;
        return Objects.equals(this.action, that.action) && Objects.equals(this.plan, that.plan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.action, this.plan);
    }

}
