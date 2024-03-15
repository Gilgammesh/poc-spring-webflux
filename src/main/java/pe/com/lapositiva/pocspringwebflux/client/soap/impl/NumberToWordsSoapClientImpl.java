package pe.com.lapositiva.pocspringwebflux.client.soap.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import pe.com.lapositiva.pocspringwebflux.client.soap.NumberToWordsSoapClient;
import pe.com.lapositiva.pocspringwebflux.entity.dto.client.NumberToWordRequestDto;
import pe.com.lapositiva.pocspringwebflux.entity.dto.client.NumberToWordsResponseDto;

@Slf4j
@RequiredArgsConstructor
@SuppressWarnings("null")
@Component
public class NumberToWordsSoapClientImpl implements NumberToWordsSoapClient {

    private WebClient webClient;

    @Value("${soap.address}")
    private String soapAddress;

    @PostConstruct
    public void init() {
        this.webClient = WebClient.builder().baseUrl(soapAddress).build();
    }

    @Override
    public Mono<NumberToWordsResponseDto> numberToWords(NumberToWordRequestDto request) {

        String soapRequest = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://www.dataaccess.com/webservicesserver/\">\r"
                + "   <soapenv:Header/>\r"
                + "   <soapenv:Body>\r"
                + "     <web:NumberToWords>\r"
                + "         <web:ubiNum>" + request.getUbiNum() + "</web:ubiNum>\r"
                + "     </web:NumberToWords>\r"
                + "   </soapenv:Body>\r"
                + "</soapenv:Envelope>";

        log.info("Servicio SOAP Consumido es: {}", soapAddress);

        return webClient.post()
                .header("Content-Type", "text/xml; charset=UTF-8")
                .body(Mono.just(soapRequest), String.class)
                .retrieve()
                .bodyToMono(String.class)
                .map(this::xmlToDto);

    }

    private NumberToWordsResponseDto xmlToDto(String xml) {

        log.info("Respuesta Consulta SOAP: {}", xml);

        XmlMapper xmlMapper = new XmlMapper();
        try {
            String responseBody = xml.substring(xml.indexOf("<soap:Body>") + "<soap:Body>".length(),
                    xml.indexOf("</soap:Body>"));
            return xmlMapper.readValue(responseBody, NumberToWordsResponseDto.class);
        } catch (Exception e) {
            throw new RuntimeException("Error al convertir el xml a dto", e);
        }
    }

}
