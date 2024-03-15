package pe.com.lapositiva.pocspringwebflux.entity.dto.client;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "NumberToWordsResponse", namespace = "http://www.dataaccess.com/webservicesserver/")
public class NumberToWordsResponseDto {

    @JacksonXmlProperty(localName = "NumberToWordsResult", namespace = "http://www.dataaccess.com/webservicesserver/")
    private String numberToWordsResult;
}
