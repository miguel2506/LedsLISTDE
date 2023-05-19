package co.edu.umanizales.ledslistde.controller;

import co.edu.umanizales.ledslistde.controller.dto.ResponseDTO;
import co.edu.umanizales.ledslistde.model.Led;
import co.edu.umanizales.ledslistde.service.ListDELedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/listleds")
public class ListDELedController {
    @Autowired
    private ListDELedService listDELedService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getLeds() {
        return new ResponseEntity<>(new ResponseDTO(
                200, listDELedService.getLeds().print(), null), HttpStatus.OK);
    }

    @GetMapping(path = "/addled/{id}")
    public ResponseEntity<ResponseDTO> addLed(@PathVariable int id){
        listDELedService.getLeds().addLed(new Led(id));
        return new ResponseEntity<>(new ResponseDTO(
                200, "Se ha añadido una nueva luz LED", null), HttpStatus.OK);
    }

    @GetMapping(path = "/addledtostart/{id}")
    public ResponseEntity<ResponseDTO> addLedToStart(@PathVariable int id){
        listDELedService.getLeds().addLedsToStart(new Led(id));
        return new ResponseEntity<>(new ResponseDTO(200, "La luz LED ha sido añadida al inicio.",
                null), HttpStatus.OK);
    }

    @GetMapping(path = "/addledtofinal/{id}")
    public ResponseEntity<ResponseDTO> addLedToFinal(@PathVariable int id){
        listDELedService.getLeds().addLedsToFinal(new Led(id));
        return new ResponseEntity<>(new ResponseDTO(200, "La luz LED ha sido añadida al final.",
                null), HttpStatus.OK);
    }

    @GetMapping("/turnon")
    public ResponseEntity<ResponseDTO> turnOnLeds() {
        listDELedService.getLeds().turnOnLeds();
        return new ResponseEntity<>(new ResponseDTO(200, "Las luces LED han sido encendidas.", null), HttpStatus.OK);
    }

    @GetMapping("/turnooff")
    public ResponseEntity<ResponseDTO> turnOffLeds() {
        listDELedService.getLeds().turnOffLeds();
        return new ResponseEntity<>(new ResponseDTO(200, "Las luces LED han sido apagadas.", null), HttpStatus.OK);
    }

    @GetMapping(path = "/rebootleds")
    public ResponseEntity<ResponseDTO> rebootLeds(){
        listDELedService.getLeds().rebootLeds();
        return new ResponseEntity<>(new ResponseDTO(200, "Se han reiniciado las luces led.",
                null), HttpStatus.OK);
    }

    @GetMapping(path = "/turnonandoffleds")
    public ResponseEntity<ResponseDTO> turnOnAndOffLeds(){
        listDELedService.getLeds().turnOffOn();
        return new ResponseEntity<>(new ResponseDTO(200, "Se han prendido y apagado las luces led desde el medio",
                null), HttpStatus.OK);
    }

}

