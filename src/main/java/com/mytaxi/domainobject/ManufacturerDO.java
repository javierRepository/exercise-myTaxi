package com.mytaxi.domainobject;


import java.time.ZonedDateTime;

public class ManufacturerDO {

    private Long id;
    private ZonedDateTime date_created;
    private String brand_name;
    private Integer rating;

    public Long getId() {
        return id;
    }

    public ZonedDateTime getDate_created() {
        return date_created;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public Integer getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ManufacturerDO that = (ManufacturerDO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date_created != null ? !date_created.equals(that.date_created) : that.date_created != null) return false;
        if (brand_name != null ? !brand_name.equals(that.brand_name) : that.brand_name != null) return false;
        return rating != null ? rating.equals(that.rating) : that.rating == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date_created != null ? date_created.hashCode() : 0);
        result = 31 * result + (brand_name != null ? brand_name.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ManufacturerDO{" +
                "id=" + id +
                ", date_created=" + date_created +
                ", brand_name='" + brand_name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
