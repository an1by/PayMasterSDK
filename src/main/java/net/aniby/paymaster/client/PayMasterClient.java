package net.aniby.paymaster.client;

import com.google.gson.reflect.TypeToken;
import net.aniby.paymaster.common.exceptions.ResponseBodyException;
import net.aniby.paymaster.modules.payments.PaymentDetails;
import net.aniby.paymaster.modules.payments.PaymentPartialDetailsList;
import net.aniby.paymaster.modules.receipts.ReceiptCreateRequest;
import net.aniby.paymaster.modules.receipts.ReceiptDetails;
import net.aniby.paymaster.utils.Constants;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Date;

import static net.aniby.paymaster.utils.Constants.DATE_FORMAT;
import static net.aniby.paymaster.utils.Constants.GSON;

public class PayMasterClient {
    private final OkHttpClient client;
    private final String bearerToken;
    private final String idempotencyKey;

    public PayMasterClient(String bearerToken, String idempotencyKey) {
        this.bearerToken = bearerToken;
        this.idempotencyKey = idempotencyKey;
        this.client = new OkHttpClient.Builder().build();
    }

    public PayMasterClient(String bearerToken, String idempotencyKey, Proxy proxy) {
        this.bearerToken = bearerToken;
        this.idempotencyKey = idempotencyKey;
        this.client = new OkHttpClient.Builder().proxy(proxy).build();
    }

    // Templates
    <T> T postRequest(Object jsonObject, String url, TypeToken<T> typeToken) throws IOException {
        RequestBody requestBody = RequestBody.create(GSON.toJson(jsonObject), Constants.JSON_TYPE);
        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + this.bearerToken)
                .header("Idempotency-Key", this.idempotencyKey)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .url(url)
                .post(requestBody)
                .build();
        return executeAndReturn(request, typeToken);
    }

    <T> T getRequest(String url, TypeToken<T> typeToken) throws IOException {
        Request request = new Request.Builder()
                .header("Authorization", "Bearer " + this.bearerToken)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .url(url)
                .get()
                .build();
        return executeAndReturn(request, typeToken);
    }

    <T> T executeAndReturn(Request request, TypeToken<T> type) throws IOException {
        Response response = client.newCall(request).execute();
        ResponseBody responseBody = response.body();
        if (responseBody == null)
            throw ResponseBodyException.NULL;
        String body = responseBody.string();
        if (body.isEmpty())
            throw ResponseBodyException.EMPTY;

        T info = GSON.fromJson(body, type);
        response.close();
        return info;
    }

    // Main functions
    // Payments
    public PaymentDetails getPaymentDetails(@NotNull String id) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.PAYMENTS)
                .addPathSegment(id)
                .build().toString();
        return getRequest(url, TypeToken.get(PaymentDetails.class));
    }

    public PaymentPartialDetailsList getPaymentDetailsList(@NotNull String merchantId, @NotNull Date start, @NotNull Date end) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.PAYMENTS)
                .addQueryParameter("merchantId", merchantId)
                .addQueryParameter("start", DATE_FORMAT.format(start))
                .addQueryParameter("end", DATE_FORMAT.format(end))
                .build().toString();
        return getRequest(url, TypeToken.get(PaymentPartialDetailsList.class));
    }

    // Receipts
    public ReceiptDetails createReceipt(ReceiptCreateRequest request) throws IOException {
        return postRequest(request, Constants.Host.RECEIPTS, TypeToken.get(ReceiptDetails.class));
    }

    public ReceiptDetails getReceiptDetails(@NotNull String id) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.RECEIPTS)
                .addPathSegment(id)
                .build().toString();
        return getRequest(url, TypeToken.get(ReceiptDetails.class));
    }

    public ArrayList<ReceiptDetails> getReceiptDetailsList(@NotNull String paymentId) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.RECEIPTS)
                .addQueryParameter("paymentId", paymentId)
                .build().toString();
        final TypeToken<ArrayList<ReceiptDetails>> typeToken = new TypeToken<>() {
        };
        return getRequest(url, typeToken);
    }
}
