package com.jang.sample.web;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.jang.cmm.jpa.CommPageRequest;
import com.jang.sample.domain.Sample;
import com.jang.sample.domain.SampleVO;
import com.jang.sample.service.SampleService;

@Controller
public class SampleUiController {

    @Autowired
    SampleService sampleService;
    
    @GetMapping({"", "/"})
    public String sampleIndex(Model model) {

        return "redirect:sample/list";
    }
    
    @RequestMapping("/sample/page/list")
    private String sampleUiListPageBind(
    		@PageableDefault Pageable pageable,
    		Model model) {
    	System.out.print("SampleUiControllerPage");
    	

    	Page<Sample> boardList = sampleService.findSmplePageList(pageable);
    	
    	model.addAttribute("boardList", boardList);
        //model.addAttribute("boardList.totalPages", boardList.getTotalPages());
        
        
        //boardList.stream().forEach(System.out::println);
        
        //model.addAttribute("boardList", boardList);
    	
        return "/sample/page/list";
    }
    @RequestMapping("/sample/page/list/search11")
    private String sampleUiListPageSearchBind(
    		@RequestParam Map<?, ?> commandMap,
    		@PageableDefault Pageable pageable,
    		Model model) {
    	
    	System.out.print("SampleUiControllerPage>>>>>>"+commandMap);
    	System.out.print("SampleUiControllerPage>>>>>>"+commandMap);
    	System.out.print("SampleUiControllerPage>>>>>>"+commandMap);
    	

    	//Page<Sample> boardList = sampleService.getSerchSamples(commandMap, pageable);
    	List<Sample> boardList = sampleService.getSerchSamples(commandMap);
    	
    	model.addAttribute("boardList", boardList);
    	
        return "/sample/page/list";
    }
    
    
    ////http://localhost:8080/sample/page/api?page=0&size=10
    @RequestMapping("/sample/page/api")
    @ResponseBody
    private Page<Sample> sampleUiListPage(
    		final CommPageRequest cmmPageRequest,
    		Model model) {    	
    	return sampleService.findSmplePageList(cmmPageRequest.of());
    }
    
    //http://localhost:8080/sample/page/api1?page=0&size=10
    @RequestMapping("/sample/page/api1")
    @ResponseBody
    private Page<Sample> sampleUiListPage1(
    		//@PageableDefault(page=0, size=20, sort="name", direction=Sort.Direction.ASC)
    		@PageableDefault Pageable pageable,
    		Model model) {    	
    	/*
		pageable = PageRequest.of(
		                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1,
		                pageable.getPageSize());
    	 */
    	return sampleService.findSmplePageList(pageable);
    }

    //http://localhost:8080/sample/page/api3?page=0&size=10
    @RequestMapping("/sample/page/api3")
    @ResponseBody
    private Page<Sample> sampleUiListPage(
    		//@PageableDefault(page=0, size=20, sort="name", direction=Sort.Direction.ASC)
    		//@PageableDefault PageRequest pageable
    		@RequestParam(value = "page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value = "size", defaultValue = "10", required = false) Integer size,
            @RequestParam(value = "sort", defaultValue = "orderNumber", required = false) String sort,
    		//final PageRequest pageable
    		Model model) {
    	System.out.print("SampleUiControllerPage");
    	
    	return sampleService.findSmplePageList(PageRequest.of(page, size));
    }


    @RequestMapping("/sample/list")
    private String sampleUiList(Model model) {
    	System.out.print("SampleUiController");
    	
    	List<Sample> boardList = sampleService.getAllSamples();
    	
        model.addAttribute("list", boardList);    	
    	
        return "/sample/list";
    }
    
    
    /*
     * 
     JPQLQuery 1
     QuerydslRepositorySupport 사용
    <dependency>
        <groupId>com.querydsl</groupId>
        <artifactId>querydsl-apt</artifactId>
    </dependency>

    <dependency>
        <groupId>com.querydsl</groupId>
        <artifactId>querydsl-jpa</artifactId>
    </dependency>
	자동생성됨
     @Generated("com.querydsl.codegen.EmbeddableSerializer")
     
     JPQLQuery 2
	@Query("select c from Customer c where c.lastName LIKE :lastname||'%'")
	List<Customer> findCustomByLastName( @Param("lastname") String lastName);

	SELECT * FROM todos t WHERE
    LOWER(t.title) LIKE LOWER(CONCAT('%',:searchTerm, '%')) OR
    LOWER(t.description) LIKE LOWER(CONCAT('%',:searchTerm, '%')) 
    ORDER BY t.title ASC
     */
    @RequestMapping("/sample/list/search")
    private String sampleUiListSearch(
    		SampleRequestDto.ValidateFormReq dto,
    		@RequestParam Map<?, ?> commandMap,
    		Model model) {
    	System.out.println("SampleUiController Search2222");
    	System.out.println("SampleUiController Search111");
    	
    	//searchKeyword
    	//searchCondition
    	commandMap.forEach(
    				(key,value)->{
    					System.out.println("param key:"+key+" / value : "+value);
    				}
    			);
    	
    	List<Sample> boardList = sampleService.getSerchSamples(commandMap);
    	
        model.addAttribute("list", boardList);    	
    	
        return "/sample/list";
    }

    @GetMapping("/sample/regist") 
    private String sampleUiAddGet(@ModelAttribute("sample") Sample sample, Model model) {
        return "/sample/regist";
    }
    
    ////produces = "application/json; charset=UTF-8")
    /*
    @PutMapping(value="/sample/regist1",
    		consumes=MediaType.APPLICATION_JSON_VALUE, 
    	    produces=MediaType.APPLICATION_JSON_VALUE )
   */
    
    //@PutMapping(value="/sample/regist/ajax", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    
    //json>Form 방식 등록 처리
    @PutMapping(value="/sample/regist/ajaxForm", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    private Sample sampleUiPutForm(	SampleVO sampleVO,
    								@Valid final SampleRequestDto.ValidateFormReq dto //method bainding
    							) {

    	System.out.println("sampleUiPut start==");
    	//System.out.println("sampleUiPut sampleVO>>>>>"+sampleVO);
    	System.out.println("sampleUiPut sample>>>>>"+dto.toEntity());
    	Sample saveSample = sampleService.saveOrUpdate(dto.toEntity());
    	
    	//System.out.println( sampleService.saveOrUpdate(sample) );
    	//System.out.println( sampleService.saveOrUpdate(sample) );
    	
        //return saveSample;
    	return saveSample;
    }
    
    
    //ajax>json 방식 등록 처리
    @PutMapping(value="/sample/regist/ajaxJson", consumes=MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    @ResponseBody
    private Sample sampleUiPutAjax(	
    								@RequestBody @Valid final SampleRequestDto.ValidateFormReq dto //method bainding
    							) {

    	System.out.println("sampleUiPut start==");
    	//System.out.println("sampleUiPut sampleVO>>>>>"+sampleVO);
    	System.out.println("sampleUiPut sample>>>>>"+dto.toEntity());
    	Sample saveSample = sampleService.saveOrUpdate(dto.toEntity());
    	
    	//System.out.println( sampleService.saveOrUpdate(sample) );
    	//System.out.println( sampleService.saveOrUpdate(sample) );
    	
        //return saveSample;
    	return saveSample;
    }
    
    @PostMapping("/sample/regist")
    private String sampleUiAddPost(//@ModelAttribute @Valid Sample sample,
    								@ModelAttribute Sample sample,
    								//@Valid final SampleRequestDto.ValidateFormReq dto,
    								BindingResult result,
    								Model model) {
    	System.out.println("sampleUiAddPost start==");
    	//validation check
    	if(result.hasErrors()){
    		System.out.println(sample);
    		return "/sample/regist";
    	}
    	
    	System.out.println( sampleService.saveOrUpdate(sample) );
        return "redirect:/sample/list";
    }
    
    @PostMapping("/sample/update")
    private String sampleUiUUpdatePost(//@ModelAttribute @Valid Sample sample,
    								@ModelAttribute Sample sample,
    								//@Valid final SampleRequestDto.ValidateFormReq dto,
    								BindingResult result,
    								Model model) {
    	System.out.println("sampleUiAddPost start==");
    	//validation check
    	if(result.hasErrors()){
    		System.out.println(sample);
    		return "/sample/regist";
    	}
    	
    	System.out.println( sampleService.saveOrUpdate(sample) );
        return "redirect:/sample/list";
    }

    @RequestMapping("/sample/modify/{id}")
    private String sampleUiModify(@PathVariable final long id, Model model) {
    	Sample sample = sampleService.getSampleById(id);
    	model.addAttribute("sample", sample);    	
        return "/sample/regist";
    }
    
    @RequestMapping("sample/detail/{id}")
    private String sampleUiDetail(@PathVariable final long id, Model model) {
    	Sample sample = sampleService.getSampleById(id);
    	model.addAttribute("sample", sample);
        return "/sample/detail";
    }
    //@RequestMapping(value="/foos/{id}", method = RequestMethod.DELETE)

    //@DeleteMapping("sample/delete/{id}")
    //@DeleteMapping("sample/delete/{id}")
    /*
    @DeleteMapping("sample/delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    private List sampleUiDelete(@PathVariable final long id, Model model) {

      sampleService.delete(id);
      
      return Arrays.asList("1","2");
    }
    
    @DeleteMapping("sample/delete/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    private ResponseEntity<String> sampleUiDelete(@PathVariable final long id, Model model) {
      sampleService.delete(id);
      return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
    }
    
    @DeleteMapping("sample/delete/{id}")
    private @ResponseBody ResponseEntity<String> sampleUiDelete(@PathVariable final long id, Model model) {
      sampleService.delete(id);
      return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
    }
    */
    @DeleteMapping("sample/delete/{id}")
    @ResponseBody
    private ResponseEntity<Void> sampleUiDelete(@PathVariable final long id, Model model) {
      sampleService.delete(id);
      return ResponseEntity.ok().build();
    }
}