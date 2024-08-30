package co.edu.unbosque.ElectroShop.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/clients")
@CrossOrigin(origins = "*")
@Transactional

public class ClientController {
	

}
