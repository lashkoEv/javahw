package org.itstep.formatter;

import org.itstep.model.Role;
import org.springframework.format.Formatter;
import java.util.Locale;

public class RoleFormatter implements Formatter<Role> {

    @Override
    public Role parse(String s, Locale locale) {
            return Role.PRESIDENT;
    }

    @Override
    public String print(Role role, Locale locale) {
        return String.valueOf(role);
    }
}
