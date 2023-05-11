package co.edu.umanizales.ledslistde.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Led {
    private int id;
    private boolean state;
    private LocalTime dateon;
    private LocalTime dateoff;

    public Led(int id)
    {
        this.id = id;
        state = false;
    }



}