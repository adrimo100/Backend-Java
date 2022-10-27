package com.bosonit.formacion.Backend161.Travel.Domain;

import com.bosonit.formacion.Backend161.Client.Domain.Client;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Input.InputTravelDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Travel {
    @Id
    @GeneratedValue
    Long id;
    @Column(nullable = false)
    String origin;
    @Column(nullable = false)
    String destination;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;
    @OneToMany(mappedBy = "travel")
    @JsonManagedReference
    List<Client> passengers = new ArrayList<>();
    @Column(columnDefinition = "boolean default false")
    Boolean status;

    public Travel(InputTravelDto inputTravelDto){
        setOrigin(inputTravelDto.getOrigin());
        setDestination(inputTravelDto.getDestination());
        setDepartureDate(inputTravelDto.getDepartureDate());
        setArrivalDate(inputTravelDto.getArrivalDate());
        setStatus(inputTravelDto.getStatus());
    }
}
