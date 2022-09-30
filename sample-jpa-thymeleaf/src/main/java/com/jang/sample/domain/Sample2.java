package com.jang.sample.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Entity
@Table(name = "SAMPLE2")
@Data
public class Sample2 {
/*
 	@Id
	@Column(name = "CUSTOMER_ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator = "CUSTOMER_SEQ_GENERATOR")
	@TableGenerator(
			name="CUSTOMER_SEQ_GENERATOR",
			table="MY_SEQUENCE",
			pkColumnName="SEQ_NAME", //MY_SEQUENCE 테이블에 생성할 필드이름(시퀀스네임)
			pkColumnValue="CUSTOMER_SEQ", //SEQ_NAME이라고 지은 칼럼명에 들어가는 값.(키로 사용할 값)
			allocationSize=1
	)
	private Long id;
출처: https://coding-start.tistory.com/84 [코딩스타트]
 */
	//select id from sample > stream > max  방식(동작)
	/*
	@Id
	@GeneratedValue(generator = "prod-generator")
	@GenericGenerator(name = "prod-generator", 
		parameters = @Parameter(name = "prefix", value = "SAMPLE"), 
		strategy = "com.jang.sample.repository.MyGenerator")
	*/
	@Id
	@GeneratedValue(generator = "prod-generator")
	@GenericGenerator(name = "prod-generator", 
		parameters = @Parameter(name = "prefix", value = "SAMPLE"), 
		strategy = "com.jang.sample.repository.MyGenerator")
	String id;
	
	//----------------------------------------------------------------------------------------------------
	
	/*
    @Id
    @GeneratedValue(strategy= GenerationType.TABLE, generator = "string_prefix_generator")
    @GenericGenerator(name = "string_prefix_generator", strategy = "jang.sample.repository.StringPrefixTableGenerator", 
    	parameters = {
            @Parameter(name = "table_name", value = "new_key_numbers"),
            @Parameter(name = "value_column_name", value = "key_number"),
            @Parameter(name = "segment_column_name", value = "name"),
            @Parameter(name = "segment_value", value = "names_key"),
            @Parameter(name = "prefix_key", value = "prg")
            }
    )
   	@TableGenerator(
   			name="SAMPLE_SEQ_GENERATOR",
   			table="TB_SEQUENCE",
   			pkColumnName="NAME", //MY_SEQUENCE 테이블에 생성할 필드이름(시퀀스네임)
   			pkColumnValue="CUSTOMER2_SEQ", //SEQ_NAME이라고 지은 칼럼명에 들어가는 값.(키로 사용할 값)
   			allocationSize=1
   	)
   	*/
	/*
	 @Id
	  @GeneratedValue(strategy = GenerationType.TABLE, generator = "CUSTOM_SEQ")
	  @GenericGenerator(strategy = "sample.hibernate.id.StringTableGenerator", 
	    name = "CUSTOM_SEQ", parameters = {
	    @Parameter(name = "segment_value", value = "partner_cd"),
	    @Parameter(name = "table_name", value = "sequence_mng"),
	    @Parameter(name = "segment_column_name", value = "colname"),
	    @Parameter(name = "value_column_name", value = "nextvalue")
	  })
    private String id;
	
	 @Id
     @GenericGenerator(name = "table", strategy = "jang.sample.repository.AssignedTableGenerator",
         parameters = {
             @org.hibernate.annotations.Parameter(name = "table_name", value = "sequence_table")
         })
     @GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
     private Long id;
      */
    

    
//	@Id
//	
//	@GenericGenerator(
//						name = "SAMPLE_SEQ_GENERATOR",
//						strategy = "jang.sample.repository.StringPrefixTableGenerator", 
//						parameters = {
//								 	@Parameter(name = "table_name", value = "table_name"),
//						            @Parameter(name = "value_column_name", value = "value_column_name"),
//						            @Parameter(name = "segment_column_name", value = "segment_column_name"),
//						            @Parameter(name = "segment_value", value = "sequence_name"),
//						            @Parameter(name = "increment_size", value = "1"),
//						            @Parameter(name = "prefix_key", value = "prg")
//						})
	/*
	
	*/
	//https://medium.com/@circlee7/spring-jpa-string-prefix-sequencial-identifier-9a3c9a229869
	/*
   	@TableGenerator(
   			name="SAMPLE_SEQ_GENERATOR",
   			table="TB_SEQUENCE",
   			pkColumnName="NAME", //MY_SEQUENCE 테이블에 생성할 필드이름(시퀀스네임)
   			pkColumnValue="CUSTOMER2_SEQ", //SEQ_NAME이라고 지은 칼럼명에 들어가는 값.(키로 사용할 값)
   			allocationSize=1
   	)
   	*/
    //private Long id;

    @Column(nullable = false, length=50)
    private String name;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String useYn;
    
    @Column(nullable = false)
    private String regUser;

    public Sample2(String name, String description, String useYn, String regUser) {
        this.name = name;
        this.description = description;
        this.useYn = useYn;
        this.regUser = regUser;
    }

}
