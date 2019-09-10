package it.hackaton.minified.close2me.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EventDTO {
	
	private String  id;
	private String  categoryId;
	private String  longitude;
	private String  latitude;
	private Date    start;
	private Date    end;
	private String  formattedDate;
	private String  title;
	private String  note;
	private String  metadata;
	private String  link;
	private String  image;
	private String  rating;
	private String  address;
}
