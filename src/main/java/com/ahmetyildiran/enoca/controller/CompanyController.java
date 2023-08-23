package com.ahmetyildiran.enoca.controller;


import com.ahmetyildiran.enoca.dto.CompanyDto;
import com.ahmetyildiran.enoca.dto.CompanySaveRequest;
import com.ahmetyildiran.enoca.general.RestResponse;
import com.ahmetyildiran.enoca.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping
    public ResponseEntity<RestResponse<CompanyDto>> save(@RequestBody CompanySaveRequest request){
        CompanyDto companyDto = companyService.save(request);
        return ResponseEntity.ok(RestResponse.of(companyDto));
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CompanyDto>>> findAll(){
        List<CompanyDto> companyDtoList = companyService.findAll();
        return ResponseEntity.ok(RestResponse.of(companyDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CompanyDto>> findById(@PathVariable Long id){
        CompanyDto companyDto = companyService.findById(id);
        return ResponseEntity.ok(RestResponse.of(companyDto));
    }

    @PutMapping()
    public ResponseEntity<RestResponse<CompanyDto>> update( @RequestBody CompanyDto companyDto){
        companyService.update(companyDto);
        return ResponseEntity.ok(RestResponse.of(companyDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id){
        companyService.delete(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
