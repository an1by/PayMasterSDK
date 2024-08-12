package net.aniby.paymaster.types;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;
import net.aniby.paymaster.enums.*;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Item {
    @SerializedName("name")
    @NotNull
    String name;

    @SerializedName("quantity")
    double quantity;

    @SerializedName("price")
    double price;

    @SerializedName("measure")
    Measure measure;

    @SerializedName("excise")
    Double excise;

    @SerializedName("product")
    Product product;

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Product {
        @SerializedName("country")
        String country;

        @SerializedName("declaration")
        String declaration;
    }


    @SerializedName("vatType")
    @NotNull
    VatType vatType;

    @SerializedName("paymentSubject")
    @NotNull
    OperationSubject subject;

    @SerializedName("paymentMethod")
    @NotNull
    ReceiptMethod receiptMethod;

    @SerializedName("marking")
    Marking marking;

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Marking {
        @SerializedName("code")
        @NotNull
        String code;

        @SerializedName("quantity")
        Marking.Quantity quantity;

        public Double calculateQuantity() {
            return quantity == null ? null : (double) quantity.numerator / quantity.denominator;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @ToString
        @Getter
        @Accessors(fluent = true)
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class Quantity {
            @SerializedName("numerator")
            int numerator;

            @SerializedName("denominator")
            int denominator;
        }
    }

    @SerializedName("agentType")
    AgentType agentType;

    @SerializedName("supplier")
    Supplier supplier;

    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Getter
    @Accessors(fluent = true)
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class Supplier {
        @SerializedName("name")
        String name;

        @SerializedName("inn")
        String inn;

        @SerializedName("phone")
        String phone;
    }

}
