package cam.endava.google;

import cam.endava.apache.Log4jExample;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GsonExample {

    private static final Logger LOGGER = LogManager.getLogger(GsonExample.class);

    public static void main(String[] args) {

        Payment payment = new Payment();
        payment.setAmount(100.2);
        payment.setCurrency("RON");
        payment.setCardNumber("2545445255");
        payment.setCustomerName("John Travolta");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //serializare
        String json = gson.toJson(payment);
        LOGGER.info("\n{}", json);

        //deserializare
        Payment dP = gson.fromJson(json, Payment.class);
        LOGGER.info(payment.equals(dP));
        LOGGER.info(dP.getCardNumber());

    }

}
