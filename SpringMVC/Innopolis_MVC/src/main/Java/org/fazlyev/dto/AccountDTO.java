package org.fazlyev.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

}
