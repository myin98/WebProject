package com.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TempDTO {
	
	 int no;
	 String title;
	 String content;
	 boolean accept;
	 String regDate;
	 Object type;
	
}