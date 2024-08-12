package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.PaymentMethod;
import net.aniby.paymaster.types.Amount;
import net.aniby.paymaster.types.Client;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateInvoiceBody {
    @SerializedName("merchantId")
    String merchantId;

    @SerializedName("dualMode")
    Boolean dualMode;

    @SerializedName("testMode")
    Boolean testMode;

    @SerializedName("tokenization")
    Tokenization tokenization;

    @SerializedName("invoice")
    @NotNull
    PaymentInvoice invoice;

    @SerializedName("amount")
    @NotNull
    Amount amount;

    @SerializedName("paymentMethod")
    PaymentMethod paymentMethod;

    @SerializedName("protocol")
    PaymentProtocol protocol;

    @SerializedName("customer")
    Client customer;

    @SerializedName("receipt")
    PaymentReceipt receipt;
}
