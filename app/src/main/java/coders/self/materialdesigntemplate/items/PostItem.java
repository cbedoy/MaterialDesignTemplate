package coders.self.materialdesigntemplate.items;

import java.util.Date;

/**
 * Created by Carlos Bedoy on 8/6/15.
 *
 * Mobile App Developer - MaterialDesignTemplate
 */
public class PostItem
{
    private Date date;
    private int imageResource;
    private String title;
    private String description;

    private int color;

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public PostItem(Date date, int imageResource, String title, String description, int color){
        this.date = date;
        this.imageResource = imageResource;
        this.title = title;
        this.description = description;
        this.color = color;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public Date getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
