package co.edu.umanizales.ledslistde.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Led {
    private String id;
    private boolean state;
    private LocalTime dateon;
    private LocalTime dateoff;

}