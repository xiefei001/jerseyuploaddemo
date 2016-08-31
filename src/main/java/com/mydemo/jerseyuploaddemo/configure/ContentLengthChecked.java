package com.mydemo.jerseyuploaddemo.configure;

import javax.ws.rs.NameBinding;
import java.lang.annotation.*;



/**
 * @author xie.fei
 * @since 1.0
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@NameBinding
@Documented
public @interface ContentLengthChecked {
}
