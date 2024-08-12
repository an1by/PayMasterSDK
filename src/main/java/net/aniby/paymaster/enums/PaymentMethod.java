package net.aniby.paymaster.enums;

import net.aniby.paymaster.utils.PayMasterEnum;

public enum PaymentMethod implements PayMasterEnum {
    BANKCARD,
    SBP,
    @Deprecated
    QIWI
}
