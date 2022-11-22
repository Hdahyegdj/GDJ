package com.gdu.app14.domain;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UploadDTO {
	private int uploadNo;
	private String title;
	private String content;
	private Timestamp createDate;		// DB와 동일하게 입력
	private Timestamp modifyDate;
	private int attachCnt;
}
