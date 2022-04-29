package com.qa.customassertion;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Favfoods {
    private String breakfast;
    private List<String> dinner;
}
