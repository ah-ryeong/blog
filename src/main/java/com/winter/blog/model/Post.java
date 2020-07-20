package com.winter.blog.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
	private int id;
	private String title;
	private String longtext;
	private int userId;
	private Timestamp createDate;
}