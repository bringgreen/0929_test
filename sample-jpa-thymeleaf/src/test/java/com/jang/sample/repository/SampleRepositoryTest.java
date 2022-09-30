package com.jang.sample.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jang.sample.domain.Sample;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class SampleRepositoryTest {

    @Autowired
    SampleRepository sampleRepository;


    /*
    @BeforeEach
    public void startUp() {
    	String[]  arrDescription = {"Foundation Layer",
    								"Persistence Layer",
    								"Presentation Layer",
    								"Business Layer",
    								"Batch Layer"};
        LongStream.rangeClosed(1, 10).forEach(
    		index ->
    			sampleRepository.save(
	    			Sample.builder()
	    				.name("Runtime Environment")
	    				.description(arrDescription[(int)(index%5)])
	    				.useYn("Y")
	    				.regUser("eGov")
	    				.build()
	    		)
		);
    	
    }
    */
    /*
    @Test
    @DisplayName("find All test")
    public void findAllTest() {
    	
    	System.out.println("find All test");
    	
    	//testBeforeAll();
    	List<Sample> listSample = sampleRepository.findAll();
    	
    	listSample.forEach(o->System.out.println(o));
    	
    	assertEquals(1, 1);
    }
   
    @Test
    @DisplayName("name like test")
    public void sample_save_test2() {
    	
    	System.out.println("name like test");
    	
    	//testBeforeAll();
    	List<Sample> listSample = sampleRepository.findByNameLikeIgnoreCase("%Runtime%");
    	
    	listSample.forEach(System.out::println);
    	
    	assertEquals(1, 1);
    }
     */
    /*
    @Test
    @DisplayName("select test")
    public void sample_save_test2() {
    	System.out.println("select test");
    	
    	//testBeforeAll();
    	Sample sample = sampleRepository.findSampleById("SAMPLE-00001");
    	System.out.println(sample);
    	
    	assertEquals(1, 1);
    }
    */
    
    /*
    @Test
    @DisplayName("insert test")
    public void sample_insert_test2() {
    	System.out.println("insert test");
    	
    	sampleRepository.save(
    			Sample.builder()
    				.name("insert test")
    				.description("Foundation Layer")
    				.useYn("Y")
    				.regUser("eGov")
    				.build()
    		);
    	
    	
    	System.out.println(sampleRepository.findSampleByName("insert test"));
    	
    	assertEquals(1, 1);
    }
    */
    /*
    @Test
    @DisplayName("update test")
    public void book_save_test2() {
    	System.out.println("update test");

    	sampleRepository.save(
    			Sample.builder()
    				.name("update test")
    				.description("Foundation Layer")
    				.useYn("Y")
    				.regUser("eGov")
    				.build()
    		);
    	
    	Sample sample = (Sample)sampleRepository.findSampleById(1L);
    	sample.setDescription("Foundation Layer1111111111");
    	sampleRepository.save(sample);
    	
    	System.out.println(sampleRepository.findSampleById(1L));
    	
    	assertEquals(1, 1);
    }
    */
    @Test
    @DisplayName("delete test")
    public void book_save_test2() {
    	System.out.println("delete test");

    	sampleRepository.save(
    			Sample.builder()
    				.name("delete test")
    				.description("Foundation Layer")
    				.useYn("Y")
    				.regUser("eGov")
    				.build()
    		);
    	
    	
    	sampleRepository.deleteById(1L);
    	
    	System.out.println(sampleRepository.findSampleById(1L));
    	
    	assertEquals(1, 1);
    }
    
}
/*
@BeforeAll : 모든 테스트 실행 전 최초 한번 실행 (JUnit4에서의 @BeforeClass)
@BeforeEach : 테스트 실행할 때마다 테스트 전에 실행 (JUnit4에서의 @Before)
@Test : 테스트 실행 (JUnit4에서의 @Test )
@AfterEach : 테스트 종료할 때마다 테스트 이후 실행 (JUnit4에서의 @After)
@AfterAll : 모든 테스트 종료 후 마지막 실행 (JUnit4에서의 @AfterClass)
@Disabled : 테스트를 수행하지 않고 패스 (JUnit4에서 @Ignore)
@DiplayName : 테스트 이름 설정
*/
/*
 * How to write a custom sequence-based String Id generator with JPA and Hibernat
https://discourse.hibernate.org/t/how-to-write-a-custom-sequence-based-string-id-generator-with-jpa-and-hibernate/2306
@Id
@GenericGenerator(
	name = "assigned-sequence",
	strategy = "com.vladmihalcea.book.hpjp.hibernate.identifier.StringSequenceIdentifier",
	parameters = {
		@org.hibernate.annotations.Parameter(
			name = "sequence_name", value = "hibernate_sequence"),
		@org.hibernate.annotations.Parameter(
			name = "sequence_prefix", value = "CTC_"),
	}
)
@GeneratedValue(
	generator = "assigned-sequence",
	strategy = GenerationType.SEQUENCE)
private String id;
*/
