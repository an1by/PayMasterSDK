package net.aniby.paymaster.enums;

import net.aniby.paymaster.utils.json.PayMasterEnum;

public enum PaymentStatus implements PayMasterEnum {
    AUTHORIZED,
    SETTLED,
    CANCELLED,
    REJECTED,
    CONFIRMATION,
    PENDING
}
