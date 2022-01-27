package cam.endava.jackson;

import cam.endava.google.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JacksonExample {

    public static final Logger LOGGER = LogManager.getLogger( JacksonExample.class);

    public static void main(String[] args) throws JsonProcessingException {
        Payment payment = new Payment();
        payment.setAmount(100.5);
        payment.setCurrency("EUR");
        payment.setCardNumber("2555445255");
        payment.setCustomerName("Alex Albon");

        //serializare
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(payment);
        LOGGER.info(json);

        //deserializare
        Payment dP = objectMapper.readValue(json, Payment.class);
        LOGGER.info(dP.equals(payment));

    }

}
