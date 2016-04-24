package org.injection.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Book {
    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private String issn;

    @Getter
    @Setter
    private String isbn;
}
