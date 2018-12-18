package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryPart {
    private Long id;
    private User user;
    private Long list_id;
    private Long subj_id;
    private Long list_item_id;
    private String creation_date;
    private String actionTitle;
    private String description;
}