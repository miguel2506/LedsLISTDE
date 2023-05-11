package co.edu.umanizales.ledslistde.service;


import co.edu.umanizales.ledslistde.model.ListDE;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ListDEService {

    private ListDE leds;


    public ListDEService() {
        leds = new ListDE();


    }



}





