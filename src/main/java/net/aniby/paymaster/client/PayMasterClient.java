package net.aniby.paymaster.client;

import com.google.gson.reflect.TypeToken;
import net.aniby.paymaster.exceptions.ResponseBodyException;
import net.aniby.paymaster.modules.payments.*;
import net.aniby.paymaster.modules.receipts.CreateReceiptBody;
import net.aniby.paymaster.modules.receipts.ReceiptDetails;
import net.aniby.paymaster.modules.refunds.CreateRefundBody;
import net.aniby.paymaster.modules.refunds.RefundDetails;
import net.aniby.paymaster.modules.stickers.RegisterStickerBody;
import net.aniby.paymaster.modules.stickers.StickerDetails;
import net.aniby.paymaster.modules.tokens.CreatePaymentTokenRequest;
import net.aniby.paymaster.modules.tokens.PaymentTokenDetails;
import net.aniby.paymaster.modules.tokens.TokenizationBody;
import net.aniby.paymaster.modules.tokens.TokenizationCallback;
import net.aniby.paymaster.utils.Constants;
import net.aniby.paymaster.types.ItemList;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

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
    <T, Z> T createRequest(@NotNull String url, TypeToken<T> typeToken, String method, @Nullable Z body) throws IOException {
        RequestBody requestBody = body != null
                ? RequestBody.create(GSON.toJson(body), Constants.Http.JSON_TYPE)
                : null;
        Request.Builder builder = new Request.Builder()
                .header("Authorization", "Bearer " + this.bearerToken)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .method(method, requestBody)
                .url(url);
        if (method.equals("POST")) {
            builder = builder.header("Idempotency-Key", this.idempotencyKey);
        }
        return executeAndReturn(builder.build(), typeToken);
    }

    <T> T getRequest(@NotNull String url, TypeToken<T> typeToken) throws IOException {
        return createRequest(url, typeToken, "GET", null);
    }

    <T, Z> T postRequest(@NotNull Z jsonObject, @NotNull String url, TypeToken<T> typeToken) throws IOException {
        return createRequest(url, typeToken, "POST", jsonObject);
    }

    <T, Z> T putRequest(Z jsonObject, @NotNull String url, TypeToken<T> typeToken) throws IOException {
        return createRequest(url, typeToken, "PUT", jsonObject);
    }

    <T> T executeAndReturn(@NotNull Request request, TypeToken<T> type) throws IOException {
        Response response = client.newCall(request).execute();
        if (type == null) {
            return null;
        }

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
    public InvoiceCallback createInvoice(@NotNull CreateInvoiceBody body) throws IOException {
        return postRequest(body, Constants.Host.PAYMENTS, TypeToken.get(InvoiceCallback.class));
    }

    public PaymentDetails createPayment(@NotNull CreatePaymentBody body) throws IOException {
        return postRequest(body, Constants.Host.PAYMENTS, TypeToken.get(PaymentDetails.class));
    }

    public PaymentDetails completePayment(@NotNull String id, @NotNull CompletePaymentBody body) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.PAYMENTS)
                .addPathSegment(id)
                .addPathSegment("complete")
                .build().toString();
        return putRequest(body, url, TypeToken.get(PaymentDetails.class));
    }

    public void confirmPayment(@NotNull String id, @NotNull ConfirmPaymentBody body) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.PAYMENTS)
                .addPathSegment(id)
                .addPathSegment("confirm")
                .build().toString();
        putRequest(body, url, null);
    }

    public void cancelPayment(@NotNull String id) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.PAYMENTS)
                .addPathSegment(id)
                .addPathSegment("cancel")
                .build().toString();
        putRequest(null, url, null);
    }

    public PaymentDetails getPayment(@NotNull String id) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.PAYMENTS)
                .addPathSegment(id)
                .build().toString();
        return getRequest(url, TypeToken.get(PaymentDetails.class));
    }

    public ArrayList<PaymentDetails> getPaymentList(@NotNull String merchantId, @NotNull Date start, @NotNull Date end) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.PAYMENTS)
                .addQueryParameter("merchantId", merchantId)
                .addQueryParameter("start", DATE_FORMAT.format(start))
                .addQueryParameter("end", DATE_FORMAT.format(end))
                .build().toString();
        final TypeToken<ItemList<PaymentDetails>> typeToken = new TypeToken<>() {
        };
        return getRequest(url, typeToken).items();
    }

    // Refunds
    public RefundDetails createRefund(CreateRefundBody body) throws IOException {
        return postRequest(body, Constants.Host.REFUNDS, TypeToken.get(RefundDetails.class));
    }

    public RefundDetails getRefund(@NotNull String id) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.REFUNDS)
                .addPathSegment(id)
                .build().toString();
        return getRequest(url, TypeToken.get(RefundDetails.class));
    }

    public ArrayList<RefundDetails> getRefundList(@NotNull String merchantId) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.REFUNDS)
                .addQueryParameter("merchantId", merchantId)
                .build().toString();
        final TypeToken<ItemList<RefundDetails>> typeToken = new TypeToken<>() {
        };
        return getRequest(url, typeToken).items();
    }

    // Tokens
    public TokenizationCallback tokenization(TokenizationBody body) throws IOException {
        return postRequest(body, Constants.Host.TOKENIZATION, TypeToken.get(TokenizationCallback.class));
    }

    public PaymentTokenDetails createPaymentToken(CreatePaymentTokenRequest body) throws IOException {
        return postRequest(body, Constants.Host.PAYMENT_TOKENS, TypeToken.get(PaymentTokenDetails.class));
    }

    public PaymentTokenDetails getPaymentToken(@NotNull String id) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.PAYMENT_TOKENS)
                .addPathSegment(id)
                .build().toString();
        return getRequest(url, TypeToken.get(PaymentTokenDetails.class));
    }

    public void revokeToken(@NotNull String id) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.PAYMENT_TOKENS)
                .addPathSegment(id)
                .addPathSegment("revoke")
                .build().toString();
        putRequest(null, url, null);
    }

    // Receipts
    public ReceiptDetails createReceipt(CreateReceiptBody body) throws IOException {
        return postRequest(body, Constants.Host.RECEIPTS, TypeToken.get(ReceiptDetails.class));
    }

    public ReceiptDetails getReceipt(@NotNull String id) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.RECEIPTS)
                .addPathSegment(id)
                .build().toString();
        return getRequest(url, TypeToken.get(ReceiptDetails.class));
    }

    public ArrayList<ReceiptDetails> getReceiptList(@NotNull String paymentId) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.RECEIPTS)
                .addQueryParameter("paymentId", paymentId)
                .build().toString();
        final TypeToken<ArrayList<ReceiptDetails>> typeToken = new TypeToken<>() {
        };
        return getRequest(url, typeToken);
    }

    // Stickers
    public StickerDetails registerSticker(RegisterStickerBody body) throws IOException {
        return postRequest(body, Constants.Host.STICKERS, TypeToken.get(StickerDetails.class));
    }

    public void updateStickerStatus(@NotNull String stickerId, boolean active) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.STICKERS)
                .addPathSegment(stickerId)
                .build().toString();
        putRequest("{\"active\":" + active + "}", url, null);
    }

    public StickerDetails getSticker(@NotNull String stickerId) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.STICKERS)
                .addPathSegment(stickerId)
                .build().toString();
        return getRequest(url, TypeToken.get(StickerDetails.class));
    }

    public ArrayList<StickerDetails> getStickerList(@NotNull String merchantId) throws IOException {
        String url = new HttpUrl.Builder()
                .host(Constants.Host.STICKERS)
                .addQueryParameter("merchantId", merchantId)
                .build().toString();
        final TypeToken<ItemList<StickerDetails>> typeToken = new TypeToken<>() {
        };
        return getRequest(url, typeToken).items();
    }
}
