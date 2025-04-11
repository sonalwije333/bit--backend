package com.bit.backend.controllers;
import com.bit.backend.dtos.EmployeeDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.EmployeeServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
public class EmployeeController {
       private final EmployeeServiceI employeeServiceI;

       public EmployeeController(EmployeeServiceI employeeServiceI) {this.employeeServiceI = employeeServiceI;}

       @PostMapping("/employee")
       public ResponseEntity<EmployeeDto> addForm(@RequestBody EmployeeDto employeeDto) {

              try {
                     EmployeeDto employeeResponse = employeeServiceI.addEmployeeEntity(employeeDto);
                     return ResponseEntity.created(URI.create("/employee" + employeeResponse.getFirstName())).body(employeeResponse);
              } catch (Exception e) {
                     throw new AppException("Request failed with error: " + 0, HttpStatus.INTERNAL_SERVER_ERROR );
              }
       }
       @GetMapping("/employee")
       public ResponseEntity<List<EmployeeDto>> getData(){
              /* controller -> service (interface) -> repository*/
              /* DTO , Entity , Mapper */

              try{
                     List<EmployeeDto>  employeeDtoList = employeeServiceI.getData();
                     return ResponseEntity.ok(employeeDtoList);
              } catch (Exception e){
                     throw new AppException("Request failed with error: " + 0, HttpStatus.INTERNAL_SERVER_ERROR );
              }
       }

       @PutMapping("/employee/{id}")
       public ResponseEntity <EmployeeDto> updateEmployee( @PathVariable long id , @RequestBody  EmployeeDto employeeDto) {

              try{
                     EmployeeDto responseEmployeeDto  =  employeeServiceI.updateEmployee(id,employeeDto);
                     return ResponseEntity.ok(responseEmployeeDto);

              } catch (Exception e){

                     throw new AppException("Request failed with error: " + 0, HttpStatus.INTERNAL_SERVER_ERROR );
              }}

       @DeleteMapping("/employee/{id}")
       public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable long id) {

              try{
                     EmployeeDto employeeDto = employeeServiceI.deleteEmployee(id);
                     return ResponseEntity.ok(employeeDto); // Ensure a proper response is returned

              } catch (Exception e) {
                     throw new AppException("Request failed with error: " + 0, HttpStatus.INTERNAL_SERVER_ERROR);

              }}


}
