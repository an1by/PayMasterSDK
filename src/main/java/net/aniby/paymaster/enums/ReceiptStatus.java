package net.aniby.paymaster.enums;

import net.aniby.paymaster.utils.PayMasterEnum;

public enum ReceiptStatus implements PayMasterEnum {
    SUCCESS,
    REJECTED,
    CANCELLED,
    PENDING
}
