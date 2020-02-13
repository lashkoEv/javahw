package post;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PostRepository {
    int id;
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
        for(int i=0; i<3; i++) {
            posts.add(Post.builder()
                    .id(++id)
                    .title("Post Title")
                    .author("Start Bootstrap")
                    .content("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!")
                    .published(new Date()).build());
        }
    }

    public void add(String title, String author, String content) {
        posts.add(Post.builder()
                .id(++id)
                .title(title)
                .author(author)
                .content(content)
                .published(new Date()).build());
    }

    public void edit(int id, String nTitle, String nAuthor, String nContent) {
        for (Post post : posts) {
            if (post.getId() == id) {
                if ("".equals(nTitle)) {
                    post.setTitle(post.getTitle());
                } else {
                    post.setTitle(nTitle);
                }
                if ("".equals(nAuthor)) {
                    post.setAuthor(post.getAuthor());
                } else {
                    post.setAuthor(nAuthor);
                }
                if ("".equals(nContent)) {
                    post.setContent(post.getContent());
                } else {
                    post.setContent(nContent);
                }
            }
        }
    }

    public void delete(int id) {
        for (Post post : posts) {
            if(post.getId() == id){
                posts.remove(post);
            }
        }
    }
}
