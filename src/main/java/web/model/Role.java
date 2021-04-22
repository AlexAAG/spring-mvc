package web.model;


import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
        USER(Set.of(Permission.DEVELOPERS_READ)),           //Set.of добавили только в java9!!!
        ADMIN(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));

        private final Set<Permission> permissions;

        Role(Set<Permission> permissions) {
                this.permissions = permissions;
        }

        public Set<Permission> getPermissions() {
                return permissions;
        }

        //GrantedAuthority с точки зрения SS является правами
        //SimpleGrantedAuthority позволяет определить кто и к чему имеет доступ
        //мы должны научиться конвертировать наши Роли в SimpleGrantedAuthority
        public Set<SimpleGrantedAuthority> getAuthorities() {
                return getPermissions().stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                        .collect(Collectors.toSet());
        }

}
