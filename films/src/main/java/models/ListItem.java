package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListItem {
    private Long id;
    private Long list_id;
    private Long subj_id;
    private String creation_date;
    private String description;
}