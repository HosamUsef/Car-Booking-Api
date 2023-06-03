package com.firstapi.Booking;

import com.firstapi.Car.Car;
import com.firstapi.User.Userr;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.time.LocalTime;
import java.util.Objects;
import java.util.UUID;

@Entity
public class CarBooking {
    @jakarta.persistence.Id
    @Id
    @SequenceGenerator(
            name = "booking_id_sequence",
            sequenceName = "booking_id_sequence",
            allocationSize = 1,
            initialValue = 1

    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_id_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Integer id;
    private UUID bookingId;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", nullable = false)
    private Userr user;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    private  LocalTime bookingTime;
    boolean isCanceld;


    public CarBooking(Userr user, Car car) {
        this.bookingId = UUID.randomUUID();
        this.user = user;
        this.car = car;
        bookingTime=LocalTime.now();
        isCanceld=false;
    }

    public CarBooking() {
    }

    public LocalTime getBookingTime() {
        return bookingTime;
    }

    public boolean isCanceld() {
        return isCanceld;
    }

    public void setCanceld(boolean canceld) {
        isCanceld = canceld;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public Userr getUser() {
        return user;
    }

    public void setUser(Userr user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarBooking{" +
                "bookingId=" + bookingId +
                ", user=" + user +
                ", car=" + car +
                ", bookingTime=" + bookingTime +
                ", isCanceld=" + isCanceld +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarBooking that = (CarBooking) o;
        return isCanceld == that.isCanceld && Objects.equals(bookingId, that.bookingId) && Objects.equals(user, that.user) && Objects.equals(car, that.car) && Objects.equals(bookingTime, that.bookingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, user, car, bookingTime, isCanceld);
    }


}
