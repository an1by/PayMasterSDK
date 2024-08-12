package net.aniby.paymaster.enums;

import net.aniby.paymaster.utils.json.PayMasterEnum;

public enum AuthorizationCode implements PayMasterEnum {
    TRANSACTION_DECLINED,
    ISSUER_UNAVAILABLE,
    REJECTED_BY_FRAUD,
    INVALID_AMOUNT,
    INVALID_ACCOUNT,
    BLOCKED_ACCOUNT,
    OPERATION_NOT_ALLOWED,
    INSUFFICIENT_FUNDS,
    EXPIRED_ACCOUNT,
    PAYMENT_LIMIT_EXCEEDED,
    PAYMENT_COUNT_EXCEEDED,
    CARD_NOT_ENROLLED,
    THREE_D_SECURE_FAILED,
    CANCELLED_BY_USER,
    PAYMENT_EXPIRED
}
