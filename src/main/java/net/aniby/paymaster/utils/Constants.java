package net.aniby.paymaster.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;

import java.text.SimpleDateFormat;

public class Constants {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
    public static final Gson GSON = new GsonBuilder().setDateFormat(DATE_FORMAT.toPattern()).create();
    public static final MediaType JSON_TYPE
            = MediaType.parse("application/json; charset=utf-8");

    public static class Host {
        public static final String RECEIPTS = "https://paymaster.ru/api/v2/receipts";
        public static final String PAYMENTS = "https://paymaster.ru/api/v2/payments";
    }
}
