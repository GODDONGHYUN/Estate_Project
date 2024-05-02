package com.estate.back.common.object;

import lombok.Getter;

@Getter
public class BoardListItem {

	private Integer receptionNumber;
	private Boolean status;
	private String title;
	private String content;
	private String writerId;
	private String writeDatetime;
	private Integer viewCount;
	private String comment;
	
}
