package com.jang.sample.web;

import javax.validation.constraints.NotBlank;

import com.jang.sample.domain.Sample;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@validated
public class SampleRequestDto {
	
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ValidateFormReq {
    	
        private Long id;

        @NotBlank(message = "카테고리명을 작성해주세요.")
        private String name;
        
        @NotBlank(message = "description 작성해주세요.")
        private String description;
        
        @NotBlank(message = "사용여부을 작성해주세요.")
        private String useYn;
        
        @NotBlank(message = "등록자를 작성해주세요.")
        //@Pattern(regexp = "[0-9]{10,11}", message = "10~11자리의 숫자만 입력가능합니다")
        //@Email(message = "메일의 양식을 지켜주세요.")
        private String regUser;
            
        @Builder
        public ValidateFormReq(Long id, String name, String description, String useYn, String regUser) {
        	this.id = id;
            this.name = name;
            this.description = description;
            this.useYn = useYn;
            this.regUser = regUser;
        }

        public Sample toEntity() {
        	return Sample.builder()
			.name(this.name)
			.description(this.description)
			.useYn(this.useYn)
			.regUser(this.regUser)
			.build();
        }
    }
}
/*
<데이터 검증을 위한 기본제공 Annotation>
어노테이션 설명
@AssertFalse  거짓인지?
@AssertTrue 참인지?
@DecimalMax 지정 값 이하의 실수인지?
@DecimalMin 지정 값 이상의 실수인지?
@Digits(integer=,fraction=) 정수 여부
@Future 미래 날짜인지?
@Max 지정 값 이상인지?
@Min 지정 값 이하인지?
@NotNull  Null이 아닌지?
@Null Null인지?
@Pattern(regex=,flag=) 정규식을 만족하는지?
@Past   과거날짜인지?
@Size(min=,max=)  문자열 또는 배열등의 길이 만족 여부  

 */
