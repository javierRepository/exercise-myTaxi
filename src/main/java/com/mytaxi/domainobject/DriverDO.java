package com.mytaxi.domainobject;

import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
        name = "driver",
        uniqueConstraints = @UniqueConstraint(name = "uc_username", columnNames = {"username"})
)
public class DriverDO {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "Username can not be null!")
    private String username;

    @Column(nullable = false)
    @NotNull(message = "Password can not be null!")
    private String password;

    @Column(nullable = false)
    private Boolean deleted = false;

    @Embedded
    private GeoCoordinate coordinate;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCoordinateUpdated = ZonedDateTime.now();

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OnlineStatus onlineStatus;

    private Integer carIdSelected;


    private DriverDO() {
    }


    public DriverDO(String username, String password) {
        this.username = username;
        this.password = password;
        this.deleted = false;
        this.coordinate = null;
        this.dateCoordinateUpdated = null;
        this.onlineStatus = OnlineStatus.OFFLINE;
        this.carIdSelected = null;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }


    public Boolean getDeleted() {
        return deleted;
    }


    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }


    public OnlineStatus getOnlineStatus() {
        return onlineStatus;
    }


    public void setOnlineStatus(OnlineStatus onlineStatus) {
        this.onlineStatus = onlineStatus;
    }


    public GeoCoordinate getCoordinate() {
        return coordinate;
    }


    public void setCoordinate(GeoCoordinate coordinate) {
        this.coordinate = coordinate;
        this.dateCoordinateUpdated = ZonedDateTime.now();
    }

    public ZonedDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(ZonedDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ZonedDateTime getDateCoordinateUpdated() {
        return dateCoordinateUpdated;
    }

    public void setDateCoordinateUpdated(ZonedDateTime dateCoordinateUpdated) {
        this.dateCoordinateUpdated = dateCoordinateUpdated;
    }

    public Integer getCarIdSelected() {
        return carIdSelected;
    }

    public void setCarIdSelected(Integer carIdSelected) {
        this.carIdSelected = carIdSelected;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DriverDO driverDO = (DriverDO) o;

        if (id != null ? !id.equals(driverDO.id) : driverDO.id != null) return false;
        if (dateCreated != null ? !dateCreated.equals(driverDO.dateCreated) : driverDO.dateCreated != null)
            return false;
        if (username != null ? !username.equals(driverDO.username) : driverDO.username != null) return false;
        if (password != null ? !password.equals(driverDO.password) : driverDO.password != null) return false;
        if (deleted != null ? !deleted.equals(driverDO.deleted) : driverDO.deleted != null) return false;
        if (coordinate != null ? !coordinate.equals(driverDO.coordinate) : driverDO.coordinate != null) return false;
        if (dateCoordinateUpdated != null ? !dateCoordinateUpdated.equals(driverDO.dateCoordinateUpdated) : driverDO.dateCoordinateUpdated != null)
            return false;
        if (onlineStatus != driverDO.onlineStatus) return false;
        return carIdSelected != null ? carIdSelected.equals(driverDO.carIdSelected) : driverDO.carIdSelected == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dateCreated != null ? dateCreated.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (deleted != null ? deleted.hashCode() : 0);
        result = 31 * result + (coordinate != null ? coordinate.hashCode() : 0);
        result = 31 * result + (dateCoordinateUpdated != null ? dateCoordinateUpdated.hashCode() : 0);
        result = 31 * result + (onlineStatus != null ? onlineStatus.hashCode() : 0);
        result = 31 * result + (carIdSelected != null ? carIdSelected.hashCode() : 0);
        return result;
    }
}
