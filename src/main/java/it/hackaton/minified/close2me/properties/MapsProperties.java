package it.hackaton.minified.close2me.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Component
@ConfigurationProperties("maps")
public class MapsProperties {
	private String url;
	private String radius;
	private String key;
	private String fileJson;
	private String fileHtml;
	private String pythonMapConverter;
}
