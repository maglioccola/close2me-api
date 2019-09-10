package it.hackaton.minified.close2me.pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Places {
	@JsonIgnore
	private String html_attributions;
	private List<Result> results;
	private String status;
	@JsonIgnore
	private String next_page_token;
}
