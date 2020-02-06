package post;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostRepository {
    List<Post> posts;

    private static PostRepository instance = new PostRepository();

    private PostRepository() {
        posts = new CopyOnWriteArrayList<>();
        init();
    }

    public static PostRepository getInstance() {
        return instance;
    }

    public List<Post> getPosts() {
        return posts;
    }

    private void init() {
        posts.add(Post.builder()
                .title("Post Title")
                .author("Start Bootstrap")
                .content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!")
                .published(new Date()).build());

        posts.add(Post.builder()
                .title("Post Title")
                .author("Start Bootstrap")
                .content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!")
                .published(new Date()).build());

        posts.add(Post.builder()
                .title("Post Title")
                .author("Start Bootstrap")
                .content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!")
                .published(new Date()).build());
    }
}
