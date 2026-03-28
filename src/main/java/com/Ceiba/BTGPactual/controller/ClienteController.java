package com.Ceiba.BTGPactual.controller;

import com.Ceiba.BTGPactual.modelo.Categoria;
import com.Ceiba.BTGPactual.modelo.Cliente;
import com.Ceiba.BTGPactual.modelo.Fondo;
import com.Ceiba.BTGPactual.modelo.Suscripcion;
import com.Ceiba.BTGPactual.servicio.CategoriaService;
import com.Ceiba.BTGPactual.servicio.ClienteService;
import com.Ceiba.BTGPactual.servicio.FondoService;
import com.Ceiba.BTGPactual.servicio.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Controlador maestro

@RestController
@RequestMapping("/api/BTGPactual")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    FondoService fondoService;

    @Autowired
    SuscripcionService suscripcionService;

    @GetMapping("/listar/clientes")
    public List<Cliente> listarClientes() {
        return clienteService.listar();
    }


    @GetMapping("/listar/categoria")
    public List<Categoria> listarCategoria() {
        return categoriaService.listar();
    }


    @GetMapping("/listar/fondo")
    public List<Fondo> listarFondo() {
        return fondoService.listar();
    }


    @GetMapping("/listar/suscripcion")
    public List<Suscripcion> listarSuscripcion() {
        return suscripcionService.listar();
    }

    @PostMapping("/categoria")
    public ResponseEntity<Map<String, Object>> crearCategoria(
            @RequestBody Categoria categoriaBody) {

        Map<String, Object> response = new HashMap<>();

        if (categoriaBody.getDescripcion() == null ||
                categoriaBody.getDescripcion().trim().isEmpty()) {
            response.put("error", "el nombre es obligatorio");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {
            categoriaService.guardar(categoriaBody);

            response.put("success", true);
            response.put("message", "sucess");
            response.put("data", categoriaBody);
            response.put("status", HttpStatus.CREATED.value());
            response.put("timestamp", LocalDateTime.now());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            response.put("error", "Error al registrar");
            response.put("message", e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/fondo")
    public ResponseEntity<Map<String, Object>> crearFondo(
            @RequestBody Fondo fondoBody) {

        Map<String, Object> response = new HashMap<>();

        if (fondoBody.getNombre() == null ||
                fondoBody.getNombre().trim().isEmpty()) {
            response.put("error", "el nombre es obligatorio");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (fondoBody.getMontoMinimo() == null ||
                fondoBody.getMontoMinimo()<=0) {
            response.put("error", "el monto minimo es obligatorio");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (fondoBody.getCategoria() == null) {
            response.put("error", "categoria es obligatorio"+fondoBody.getCategoria());
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        try {


            fondoService.guardar(fondoBody);

            response.put("success", true);
            response.put("message", "sucess");
            response.put("data", fondoBody);
            response.put("status", HttpStatus.CREATED.value());
            response.put("timestamp", LocalDateTime.now());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            response.put("error", "Error al registrar");
            response.put("message", e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/suscripcion")
    public ResponseEntity<Map<String, Object>> crearSuscripcion(
            @RequestBody Suscripcion suscripcionBody) {

        Map<String, Object> response = new HashMap<>();

        if (suscripcionBody.getCliente().getId() == null ||
                suscripcionBody.getCliente().getId() <=0) {
            response.put("error", "el id de cliente es obligatorio");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (suscripcionBody.getTipo() == null ||
                suscripcionBody.getTipo().trim().isEmpty()) {
            response.put("error", "el tipo es obligatorio");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (suscripcionBody.getFecha() == null) {
            suscripcionBody.setFecha(LocalDate.from(LocalDateTime.now()));
        }

        if (suscripcionBody.getMonto() == null ||
                suscripcionBody.getMonto() <= 500000) {
            response.put("error", "el moto es obligatorio y mayor 500.000 COP");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (suscripcionBody.getFondo().getId() == null ||
                suscripcionBody.getFondo().getId() <= 0) {
            response.put("error", "el fondo es obligatorio");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }



        try {


            suscripcionService.guardar(suscripcionBody);

            response.put("success", true);
            response.put("message", "sucess");
            response.put("data", suscripcionBody);
            response.put("status", HttpStatus.CREATED.value());
            response.put("timestamp", LocalDateTime.now());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            response.put("error", "Error al registrar");
            response.put("message", e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/cliente")
    public ResponseEntity<Map<String, Object>> crearCliente(
            @RequestBody Cliente clienteBody) {

        Map<String, Object> response = new HashMap<>();

        if (clienteBody.getNombre() == null ||
                clienteBody.getNombre().trim().isEmpty()) {
            response.put("error", "el nombre es obligatorio");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (clienteBody.getEmail() == null ||
                clienteBody.getEmail().trim().isEmpty()) {
            response.put("error", "el email es obligatorio");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (clienteBody.getTelefono() == null ||
                clienteBody.getTelefono().trim().isEmpty()) {
            response.put("error", "el telefono es obligatorio");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }

        if (clienteBody.getSaldo() == null ||
                clienteBody.getSaldo()<=0) {
            response.put("error", "el telefono es obligatorio");
            response.put("status", HttpStatus.BAD_REQUEST.value());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }



        try {


            clienteService.guardar(clienteBody);

            response.put("success", true);
            response.put("message", "sucess");
            response.put("data", clienteBody);
            response.put("status", HttpStatus.CREATED.value());
            response.put("timestamp", LocalDateTime.now());

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (Exception e) {
            response.put("error", "Error al registrar");
            response.put("message", e.getMessage());
            response.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


}
