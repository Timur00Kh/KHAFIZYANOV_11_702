package models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subj {
    private Long id;
    private String title;
    private String type;
    private String genre;
    private String duration;
    private String releaseDate;
    private Integer releaseYear;
    private String status;
    private String posterUrl;
    private String desc;
}