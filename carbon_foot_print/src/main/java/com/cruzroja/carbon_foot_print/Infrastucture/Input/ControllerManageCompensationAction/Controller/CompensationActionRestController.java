package com.cruzroja.carbon_foot_print.Infrastucture.Input.ControllerManageCompensationAction.Controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "http://localhost:5050" })
@RestController
@RequestMapping("/api/plans/actions")
@Validated
@RequiredArgsConstructor
public class CompensationActionRestController {

}
