package net.aniby.paymaster.utils;

import com.google.gson.Gson;
import okhttp3.MediaType;

public class Constants {
    public static final Gson GSON = new Gson();
    public static final MediaType JSON_TYPE
            = MediaType.parse("application/json; charset=utf-8");

    public static class Host {
        public static final String RECEIPTS = "https://paymaster.ru/api/v2/receipts";
    }
}
