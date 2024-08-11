package net.aniby.paymaster.modules.receipts;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import net.aniby.paymaster.common.types.Amount;
import net.aniby.paymaster.common.types.Item;
import net.aniby.paymaster.common.types.ReceiptType;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
public class ReceiptCreateRequest {
    @SerializedName("paymentId")
    private @NotNull String paymentId;

    @SerializedName("amount")
    private @NotNull Amount amount;

    @SerializedName("type")
    private @NotNull ReceiptType type;

    @SerializedName("client")
    private @NotNull String client;

    @SerializedName("items")
    private @NotNull Item @NotNull [] items;

    // paymentId	string	Идентификатор платежа
    //amount		Сумма по чеку
    //value	decimal	Сумма
    //currency	string	Код валюты
    //type	string	Тип чека
    //client		Данные покупателя
    //items		Перечисление позиций чека
}
