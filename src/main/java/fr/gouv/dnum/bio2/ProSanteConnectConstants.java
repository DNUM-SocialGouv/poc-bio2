package fr.gouv.dnum.bio2;

public class ProSanteConnectConstants {


    // côté ProConnect
    public static final class ProSanteConnect {

        private static final String ENVIRONMENT_INTERNET_INTEGRATION = "auth.bas.psc.esante.gouv.fr";

        public static final String ENVIRONMENT = "https://" + ENVIRONMENT_INTERNET_INTEGRATION;

        public static final String USERINFO_ENDPOINT = ENVIRONMENT + "/auth/realms/esante-wallet/protocol/openid-connect/userinfo";

        public static final String AUTH_ENDPOINT = "https://wallet.bas.psc.esante.gouv.fr/auth";
        public static final String TOKEN_ENDPOINT = ENVIRONMENT + "/auth/realms/esante-wallet/protocol/openid-connect/token";
        public static final String DISCONNECT_ENDPOINT = ENVIRONMENT + "/auth/realms/esante-wallet/protocol/openid-connect/logout";
        public static final String JWKS_ENDPOINT = ENVIRONMENT + "/auth/realms/esante-wallet/protocol/openid-connect/certs";

        public static final String EXPECTED_ISSUER = ENVIRONMENT+"/auth/realms/esante-wallet";

        //public static final String CLIENT_ID = System.getenv("PRO_SANTE_CONNECT_CLIENT_ID");
        //public static final String CLIENT_SECRET = System.getenv("PRO_SANTE_CONNECT_CLIENT_SECRET");

    }

    // côté Application DNUM
    public static final class MyApplication {
        // doivent correspondre à ce qui a été configuré dans le BO ProConnect
        //public static final String REDIRECT_URI = "http://localhost:8080/proconnect/valid_code";
        public static final String REDIRECT_URI = "/redirect";
        public static final String POST_INTERNAL_LOGOUT_REDIRECT_URI = "/logout";
    }

}
