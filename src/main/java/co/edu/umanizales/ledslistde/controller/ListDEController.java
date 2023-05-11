package co.edu.umanizales.ledslistde.controller;

import co.edu.umanizales.ledslistde.controller.dto.ResponseDTO;
import co.edu.umanizales.ledslistde.model.Led;
import co.edu.umanizales.ledslistde.service.ListDEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/ledlist")
public class ListDEController {
    @Autowired
    private ListDEService listDEService;


    @GetMapping(path = "/add/{id}")
    public ResponseEntity<ResponseDTO> add(@PathVariable int id){
        listDEService.getLeds().add(new Led(id));
        return new ResponseEntity<>(new ResponseDTO(
                200, "Se ha adicionado un nuevo led",
                null), HttpStatus.OK);

    }

    @GetMapping(path = "/poweON")
    public ResponseEntity<ResponseDTO> turnOn()  {
        listDEService.getLeds().turnOn();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se encendieron  todos los leds", null), HttpStatus.OK);
    }

    @GetMapping(path = "/reset")
    public ResponseEntity<ResponseDTO> restart()  {
        listDEService.getLeds().restart();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se reiniciaron todos los leds", null), HttpStatus.OK);
    }

    @GetMapping(path = "/onof")
    public ResponseEntity<ResponseDTO> turnOnAndOff() {
        listDEService.getLeds().turnOnAndOff();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se prendió y apago los leds desde el medio", null), HttpStatus.OK);
    }

    @GetMapping(path = "/delete")
    public ResponseEntity<ResponseDTO> delete()  {
        listDEService.getLeds().delete();

        return new ResponseEntity<>(new ResponseDTO(
                200, "Se eliminaron todos los leds", null), HttpStatus.OK);
    }

}

