package com.jang.sample.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jang.sample.domain.Sample;
import com.jang.sample.service.SampleService;

@Controller
public class SampleApiController {

    @Autowired
    SampleService sampleService;

    @GetMapping("/api/sample/list")
    private List<Sample> getAllSamples() {
        return sampleService.getAllSamples();
    }

    @GetMapping("/api/sample/{id}")
    private Sample getSample(@PathVariable("id") Long id) {
        return sampleService.getSampleById(id);
    }

    @DeleteMapping("/api/sample/{id}")
    private void deleteSample(@PathVariable("id") Long id) {
    	sampleService.delete(id);
    }

    @PostMapping("/api/sample/save")
    private Long saveSample(@RequestBody Sample eample) {
    	sampleService.saveOrUpdate(eample);
        return eample.getId();
    }
    

    
}
