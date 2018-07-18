package com.mytaxi.domainobject;

import com.mytaxi.domainvalue.EngineType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.time.ZonedDateTime;

@Entity
@Table(
        name = "car",
        uniqueConstraints = @UniqueConstraint(name = "id", columnNames = {"id"})
)
public class CarDO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    private String licencePlate;

    @Column(nullable = false)
    private Integer seatCount;

    @Column(nullable = false)
    private Boolean convertible;

    @Column(nullable = false)
    private Integer rating;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Enum<EngineType> engineType;

    @Column(nullable = false)
    private Boolean deleted = false;

    @Column(nullable = false)
    private String manufacturer;

    private CarDO() {
    }

    public CarDO(String licencePlate, Integer seatCount, Boolean convertible, Integer rating, Enum<EngineType> engineType, String manufacturer) {
        this.licencePlate = licencePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.deleted = false;
        this.manufacturer = manufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public Boolean getConvertible() {
        return convertible;
    }

    public void setConvertible(Boolean convertible) {
        this.convertible = convertible;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Enum<EngineType> getEngineType() {
        return engineType;
    }

    public void setEngineType(Enum<EngineType> engineType) {
        this.engineType = engineType;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarDO carDO = (CarDO) o;

        if (id != null ? !id.equals(carDO.id) : carDO.id != null) return false;
        if (dateCreated != null ? !dateCreated.equals(carDO.dateCreated) : carDO.dateCreated != null) return false;
        if (licencePlate != null ? !licencePlate.equals(carDO.licencePlate) : carDO.licencePlate != null) return false;
        if (seatCount != null ? !seatCount.equals(carDO.seatCount) : carDO.seatCount != null) return false;
        if (convertible != null ? !convertible.equals(carDO.convertible) : carDO.convertible != null) return false;
        if (rating != null ? !rating.equals(carDO.rating) : carDO.rating != null) return false;
        if (engineType != null ? !engineType.equals(carDO.engineType) : carDO.engineType != null) return false;
        if (deleted != null ? !deleted.equals(carDO.deleted) : carDO.deleted != null) return false;
        return manufacturer != null ? manufacturer.equals(carDO.manufacturer) : carDO.manufacturer == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (licencePlate != null ? licencePlate.hashCode() : 0);
        result = 31 * result + (seatCount != null ? seatCount.hashCode() : 0);
        result = 31 * result + (convertible != null ? convertible.hashCode() : 0);
        result = 31 * result + (rating != null ? rating.hashCode() : 0);
        result = 31 * result + (engineType != null ? engineType.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        return result;
    }
}
