package net.aniby.paymaster.enums;

import net.aniby.paymaster.utils.PayMasterEnum;

public enum ErrorCode implements PayMasterEnum {
    VALIDATION_ERROR,
    NOT_AUTHORIZED,
    IDEMPOTENCY_KEY_VIOLATION,
    INVALID_OPERATION,
    PAYMENT_TOKEN_REVOKED,
    PAYMENT_TOKEN_BLOCKED
}
