package fr.gouv.dnum.bio2;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class SecureProSanteConnectConstants {

    @Value( "${PRO_SANTE_CONNECT_CLIENT_ID}")
    private String clientId;

    @Value( "${PRO_SANTE_CONNECT_CLIENT_SECRET}")
    private String clientSecret;

}
