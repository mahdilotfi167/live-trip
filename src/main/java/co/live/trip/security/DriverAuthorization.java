package co.live.trip.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface DriverAuthorization {

}

// @Target({ ElementType.METHOD, ElementType.TYPE })
// @Retention(RetentionPolicy.RUNTIME)
// @Inherited
// @PreAuthorize("hasRole(T(<package name>.Role).ROLE_ADMIN)")
// public @interface AdminAuthorization {
// }