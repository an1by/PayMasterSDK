package net.aniby.paymaster.common.types;

import com.google.gson.annotations.SerializedName;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Accessors(fluent = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Supplier {
    @SerializedName("name")
    String name;

    @SerializedName("inn")
    String inn;

    @SerializedName("phone")
    String phone;
}
