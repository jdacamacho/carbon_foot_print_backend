package com.cruzroja.carbon_foot_print.Infrastucture.Output.Persistence.Serealizables;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompanyPlanId implements Serializable {
    private Long company;
    private Long seller;
    private Long plan;
    private Date sold;

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CompanyPlanId that = (CompanyPlanId) o;
        return Objects.equals(this.company, that.company) && Objects.equals(this.seller, that.seller)
                && Objects.equals(this.plan, that.plan) && Objects.equals(this.sold, that.sold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.company, this.seller, this.plan, this.sold);
    }
}
