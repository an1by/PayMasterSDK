package net.aniby.paymaster.types.users;

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
public class Client {
    @SerializedName("email")
    String email;

    @SerializedName("phone")
    String phone;

    @SerializedName("name")
    String name;

    @SerializedName("inn")
    String inn;
}
