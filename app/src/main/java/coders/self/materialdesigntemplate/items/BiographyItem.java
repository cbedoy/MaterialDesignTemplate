package coders.self.materialdesigntemplate.items;

import java.util.List;

/**
 * Created by Carlos Bedoy on 8/7/15.
 *
 * Mobile App Developer - MaterialDesignTemplate
 */
public class BiographyItem
{
    private String username;
    private int avatar;
    private int background;
    private int id;
    private String about;
    private String birthday;
    private int age;
    private List<PostItem> posts;
    private int color;
    private String email;


    public BiographyItem(String username, String email, int avatar, int background, List<PostItem> posts){
        this.username = username;
        this.email = email;
        this.avatar = avatar;
        this.background = background;
        this.posts = posts;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public int getBackground() {
        return background;
    }

    public String getEmail() {
        return email;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setPosts(List<PostItem> posts) {
        this.posts = posts;
    }

    public List<PostItem> getPosts() {
        return posts;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public int getAvatar() {
        return avatar;
    }

    public String getAbout() {
        return about;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getUsername() {
        return username;
    }
}
