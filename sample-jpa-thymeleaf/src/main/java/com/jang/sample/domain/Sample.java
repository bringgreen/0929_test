package com.jang.sample.domain;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "SAMPLE")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//기본 생성자 접근을 protected으로 변경하면 외부에서 해당 생성자를 접근 할 수 없으므로 아래 생성자를 통해서 객체를 생성
@ToString 
@EqualsAndHashCode
/*
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
*/
public class Sample {
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
출처: https://coding-start.tistory.com/84 [코딩스타트]
 */	 
	//TABLE 이용한 SEQUENCE 생성
    @Id
   	//@Column(name = "id")
   	@GeneratedValue(strategy=GenerationType.TABLE, generator = "SAMPLE_SEQ_GENERATOR")
   	@TableGenerator(
   			name="SAMPLE_SEQ_GENERATOR",
   			table="TB_SEQUENCE",
   			pkColumnName="NAME", //MY_SEQUENCE 테이블에 생성할 필드이름(시퀀스네임)
   			pkColumnValue="CUSTOMER_SEQ", //SEQ_NAME이라고 지은 칼럼명에 들어가는 값.(키로 사용할 값)
   			allocationSize=1
   	)
    
    //자동방식을 이용한 SEQUENCE 생성
    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO) // (IDENTITY, SEQUENCE, TABLE, AUTO)
    private Long id;

    @Column(nullable = false, length=50)
    private String name;
    
    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private String useYn;
    
    @Column(nullable = false)
    private String regUser;
    
    @Column
    private String content;

    /*
    @Column
    @CreationTimestamp
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime createDateTime;
     
    @Column
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
    */
    
    @CreationTimestamp
    @Column(name = "created_dt", nullable = false, updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    //private Timestamp createdAt;
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_dt", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updatedAt;
        
    @Builder
    public Sample(String name, String description, String useYn, String regUser) {
        this.name = name;
        this.description = description;
        this.useYn = useYn;
        this.regUser = regUser;
    }
     

}
