package it.hackaton.minified.close2me.pojo;

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
public class Result {
	private String id;
	private String name;
	private String vicinity;
	private Geometry geometry;
	@JsonIgnore
	private String icon;
	private OpeningHours opening_hours;
	@JsonIgnore
	private Object photos;
	private String place_id;
	@JsonIgnore
	private Object plus_code;
	private String rating;
	private String reference;
	private String scope;
	@JsonIgnore
	private Object types;
	private String user_ratings_total;
	private String price_level;
}
