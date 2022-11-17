package com.example.zoo_clinic;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.annotations.NotNull;
import kotlin.Metadata;

import kotlin.jvm.internal.Intrinsics;

@Metadata(
        mv = {1, 7, 1},
        k = 1,
        xi = 48,
        d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t"},
        d2 = {"https://zoo-clinic-android-default-rtdb.europe-west1.firebasedatabase.app/;", "", "()V", "login", "", "getBaseReference", "https://zoo-clinic-android-default-rtdb.europe-west1.firebasedatabase.app/;", "setlogin", "", "app_debug"}
)

public final class FindLogin {

    @NotNull
    public static final FindLogin INSTANCE = new FindLogin();
    @NotNull
    private static String login = "";

    private FindLogin() {
    }

    public final void setDeviceID(@NotNull String login) {
        Intrinsics.checkNotNullParameter(login, "login");
        FindLogin.login = login;
    }

    @NotNull
    public final DatabaseReference getBaseReference() {
        DatabaseReference var10000 = FirebaseDatabase.getInstance().getReference(login);
        Intrinsics.checkNotNullExpressionValue(var10000, "getInstance()\n            .getReference(deviceID)");
        return var10000;
    }

}
