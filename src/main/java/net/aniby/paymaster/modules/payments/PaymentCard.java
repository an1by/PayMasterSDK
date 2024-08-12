package net.aniby.paymaster.modules.payments;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.DSRPType;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaymentCard {
    @SerializedName("pan")
    @NotNull
    String pan;

    @SerializedName("expiry")
    @NotNull
    String expiry;

    @SerializedName("cvc")
    String cvc;

    @SerializedName("dsrp")
    DigitalSecureRemotePayments dsrp;

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public class DigitalSecureRemotePayments {
        @SerializedName("type")
        @NotNull
        DSRPType type;

        @SerializedName("cryptogram")
        @NotNull
        String cryptogram;

        @SerializedName("eci")
        String eci;
    }
}
