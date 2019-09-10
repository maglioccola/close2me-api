package it.hackaton.minified.close2me.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryDTO {
	private Integer id;
	private String  title;
	private String  iconName;
	private String  color;
	private String  url;
}
