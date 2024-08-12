package net.aniby.paymaster.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.aniby.paymaster.enums.PaymentMethod;
import net.aniby.paymaster.enums.TokenType;
import net.aniby.paymaster.utils.json.*;
import okhttp3.MediaType;

import java.text.SimpleDateFormat;

public class Constants {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
    // DO NOT USE THIS GSON FOR YOUR CODE!
    public static final Gson GSON = new GsonBuilder()
            .registerTypeHierarchyAdapter(PaymentMethod.class, new PaymentMethodSerializer())
            .registerTypeHierarchyAdapter(TokenType.class, new TokenTypeSerializer())
            .registerTypeHierarchyAdapter(PayMasterEnum.class, new PayMasterEnumDeserializer())
            .registerTypeHierarchyAdapter(PayMasterEnum.class, new PayMasterEnumSerializer())
            .setDateFormat(DATE_FORMAT.toPattern())
            .create();

    public static class Http {
        public static final MediaType JSON_TYPE = MediaType.parse("application/json; charset=utf-8");
    }

    public static class Host {
        public static final String API_URL = "https://paymaster.ru/api/v2";
        public static final String INVOICES = API_URL + "/invoices";
        public static final String RECEIPTS = API_URL + "/receipts";
        public static final String PAYMENTS = API_URL + "/payments";
        public static final String TOKENIZATION = API_URL + "/tokenization";
        public static final String PAYMENT_TOKENS = API_URL + "/paymenttokens";
        public static final String REFUNDS = API_URL + "/refunds";
        public static final String STICKERS = API_URL + "/stickers";
    }
}
