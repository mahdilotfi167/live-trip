package co.live.trip.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Trip {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne // TODO set fetch type to eager if is better
    private RiderInfo rider;
    @ManyToOne // TODO set fetch type to eager if is better
    private DriverInfo driver;
    @OneToOne(cascade = CascadeType.REMOVE) // TODO set fetch type to eager if is better
    private Location startLocation;
    @OneToOne(cascade = CascadeType.REMOVE) // TODO set fetch type to eager if is better
    private Location endLocation;
    @Column
    private int payMent;
    @Column
    @Enumerated(EnumType.ORDINAL) // ! Be careful
    private TripStatus status;

    public Trip() {
        // ? use for entity initializing by hibernate
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RiderInfo getRider() {
        return rider;
    }

    public void setRider(RiderInfo rider) {
        this.rider = rider;
    }

    public DriverInfo getDriver() {
        return driver;
    }

    public void setDriver(DriverInfo driver) {
        this.driver = driver;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public int getPayMent() {
        return payMent;
    }

    public void setPayMent(int payMent) {
        this.payMent = payMent;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }
}
