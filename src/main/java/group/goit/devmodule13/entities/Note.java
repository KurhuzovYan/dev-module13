package group.goit.devmodule13.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Note {
    private Long id;

    private String title;

    private String content;
}
