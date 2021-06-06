package com.samanecorp.orienta.entities;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class PayTech {
    private static final String API_KEY = "64ed8026168096cfab7c5904e0adfcb0e3fe810301e179d6671fd41c231ce740";
    private static final String API_SECRET_HERE = "1e47f30d458e583709e47452c95244884d5e990245941c63dec10b86a6c7773e";
    private static final String PAYMENT_IPN_URL = "http://localhost:8080/paymentIpn";
    private static final String PAYMENT_SUCCESS_REDIRECT_URL = "http://localhost:8080/paymentSuccess";
    private static final String PAYMENT_CANCELED_REDIRECT_URL = "http://localhost:8080/paymentCanceled";
    private static final boolean IS_PRODUCTION_MODE = true;

    public static String sendPaymentRequest(String idTransaction, int amount, String paymentTitle) {
        try {
            HashMap<String, Object> params = new HashMap<>();


            params.put("item_name", paymentTitle);
            params.put("item_price", String.valueOf(amount));
            params.put("currency", "XOF");
            params.put("ref_command", String.format("UNIV-%s-%s", ThreadLocalRandom.current().nextInt(0, 999999999), idTransaction));// should be unique
            params.put("command_name", paymentTitle);// more details than item_price
            params.put("env", PayTech.IS_PRODUCTION_MODE ? "test" : "prod");
            params.put("ipn_url", PayTech.PAYMENT_IPN_URL);
            params.put("success_url", PayTech.PAYMENT_SUCCESS_REDIRECT_URL);
            params.put("cancel_url",  PayTech.PAYMENT_CANCELED_REDIRECT_URL);
            params.put("custom_field", String.valueOf(idTransaction)); // can be serialized xml, or json string, or simple string

            StringBuilder result = new StringBuilder();
            boolean first = true;

            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (first)
                    first = false;
                else
                    result.append("&");

                result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                result.append("=");
                result.append(URLEncoder.encode(String.valueOf(entry.getValue()), "UTF-8"));
            }

            String postParams =  result.toString();

            return PayTech.sendPaymentRequestInternal(postParams);
        } catch (Exception e) {
            e.printStackTrace();
            return String.format("{\"success\": -1, \"message\":\"%s\"}", e.getMessage().replace("\"", "\\\"").replace("\n", "").replace("\r", ""));
        }
    }

    static private String sendPaymentRequestInternal(String postParams) throws Exception {
            URL url = new URL("https://paytech.sn/api/payment/request-payment");
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("API_KEY", PayTech.API_KEY);
            conn.setRequestProperty("API_SECRET", PayTech.API_SECRET_HERE);
            conn.setUseCaches(false);
            conn.setDoInput(true);
            conn.setDoOutput(true);


            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, StandardCharsets.UTF_8));
            writer.write(postParams);
            writer.flush();
            writer.close();
            os.close();

            conn.connect();

            return PayTech.readInputStreamToString(conn);
    }

    static private String readInputStreamToString(HttpURLConnection connection) {
        String result = null;
        StringBuilder sb = new StringBuilder();
        InputStream is = null;

        try {
            is = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String inputLine = "";
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            result = sb.toString();
        } catch (Exception e) {
            result = "";
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }

    public static boolean ipnFromPayTech(HttpServletRequest req) throws Exception{
        return PayTech.sha256(PayTech.API_SECRET_HERE).equalsIgnoreCase(req.getParameter("api_secret_sha256"))
               &&
               PayTech.sha256(PayTech.API_KEY).equalsIgnoreCase(req.getParameter("api_key_sha256"));
    }

    private static String sha256(String data) throws Exception{
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(hash);
    }
}
