package com.jang.sample.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jang.sample.domain.Sample;
import com.jang.sample.repository.SampleRepository;
import com.jang.sample.repository.SampleRepositoryQueryDslImpl;

@Service
@Transactional
//@AllArgsConstructor //Annotation Constructor 방식
public class SampleService {
	
    @Autowired
    SampleRepositoryQueryDslImpl sampleRepositoryQueryDslImpl;
	
	//Annotation Constructor 방식 방식
	//private final SampleRepository sampleRepository;
	
	//Autowired 방식
    //@Autowired 
	//private SampleRepository sampleRepository;

	//Container Constructor 방식
    private SampleRepository sampleRepository;
    
    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }
    
    public List<Sample> getSerchSamples(Map param) {
    	
    	return sampleRepository.findByNameLikeIgnoreCaseOrDescriptionLikeIgnoreCase(param.get("searchKeyword").toString(), param.get("searchKeyword").toString());
        //return sampleRepositoryQueryDslImpl.findByNameLikeDescriptionLike(param);
    }
    
    public Page<Sample> getSerchSamples(Map param, Pageable pageable) {
        pageable = PageRequest.of(
        		pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1,
        				pageable.getPageSize());
        return sampleRepositoryQueryDslImpl.searchPage(param, pageable);
    }
    
    public List<Sample> getAllSamples() {
        //List<Sample> Samples = new ArrayList<Sample>();
        //sampleRepository.findAll().forEach(Sample -> Samples.add(Sample));
        //return Samples;
        return sampleRepository.findAll();
    }

    public Sample getSampleById(Long id) {
        return sampleRepository.findById(id).get();
    }

    public Sample saveOrUpdate(Sample sample) {
    	return sampleRepository.save(sample);
    }

    public void delete(Long id) {
    	sampleRepository.deleteById(id);
    } 
    
    //page
    public Page<Sample> findSmplePageList(Pageable pageable) {
    	
        pageable = PageRequest.of(
                		pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber()-1,
                				pageable.getPageSize());
                				
        return sampleRepository.findAll(pageable);
    }
    /*
     * https://goodgid.github.io/Spring-Data-JPA-Query_Part_1/
    PageRequest.of(int page, int size)	페이지 번호(0부터 시작), 페이지당 데이터의 수
    PageRequest.of(int page, int size, Sort.Direction direction, String… props)	페이지 번호, 페이지당 데이터의 수, 정렬 방향, 속성(컬럼)들
    PageRequest.of(int page, int size, Sort sort)	페이지 번호, 페이지당 데이터의 수, 정렬 방향
     */
        
}
