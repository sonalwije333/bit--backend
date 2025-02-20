package com.bit.backend.controllers;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.services.FormDemoServiceI;
import com.bit.backend.services.impl.FormDemoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class FormDemoController {
      private final FormDemoServiceI formDemoServiceI;


    public FormDemoController(FormDemoServiceI formDemoServiceI, FormDemoService formDemoService) {
          this.formDemoServiceI = formDemoServiceI;

    }
      @PostMapping("/form-demo")
      public ResponseEntity<FormDemoDto> addForm(@RequestBody FormDemoDto formDemoDto) {
          FormDemoDto formDemoDtoResponse = formDemoServiceI.addFormDemoEntity(formDemoDto);
          return ResponseEntity.created(URI.create("/form-demo" + formDemoDtoResponse.getFirstName())).body(formDemoDtoResponse);

      }
}
