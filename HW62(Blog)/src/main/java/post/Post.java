package post;

import lombok.*;

import java.util.Date;
@Data
@Builder
public class Post {
    private int id;
    private String title;
    private String author;
    private String content;
    private Date published;
}
