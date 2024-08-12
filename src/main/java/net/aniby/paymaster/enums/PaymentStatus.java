package net.aniby.paymaster.enums;

import net.aniby.paymaster.utils.PayMasterEnum;

public enum PaymentStatus implements PayMasterEnum {
    AUTHORIZED,
    SETTLED,
    CANCELLED,
    REJECTED,
    CONFIRMATION,
    PENDING
}
