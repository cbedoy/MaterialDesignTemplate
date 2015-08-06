package coders.self.materialdesigntemplate.items;

/**
 * Created by Carlos Bedoy on 8/6/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 * <p/>
 */
public class NavigationItem
{
    private String userName;
    private String email;
    private int imageResource;
    private int avatarResource;

    private String cellText;
    private int cellImage;

    private KindOfElement kindOfElement;


    public NavigationItem(String text, int resource){
        cellText = text;
        cellImage = resource;
        setKindOfElement(KindOfElement.CELL);
    }

    public NavigationItem(String user, String mail, int image, int avatar){
        userName = user;
        email = mail;
        imageResource = image;
        avatarResource = avatar;
        setKindOfElement(KindOfElement.TOP);
    }

    public void setKindOfElement(KindOfElement kindOfElement) {
        this.kindOfElement = kindOfElement;
    }

    public KindOfElement getKindOfElement() {
        return kindOfElement;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvatarResource(int avatarResource) {
        this.avatarResource = avatarResource;
    }

    public void setCellImage(int cellImage) {
        this.cellImage = cellImage;
    }

    public void setCellText(String cellText) {
        this.cellText = cellText;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public int getAvatarResource() {
        return avatarResource;
    }

    public int getCellImage() {
        return cellImage;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getCellText() {
        return cellText;
    }

    public String getUserName() {
        return userName;
    }

    public enum KindOfElement{
        TOP,
        CELL
    }
}
