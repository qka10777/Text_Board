public class Article  {
    private int id;
    private String title;
    private String content;
    private String regDate;
    private int hit;



    //    private String comment;
    private String comments;





    public Article(int id, String title, String content, String regDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.regDate = regDate;
        this.hit = 0;

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public void increaseHit() {
        this.hit++;
    }

//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
public void addComments(String comments) {
    this.comments = comments;
}

    public String getComments() {
        return comments;
    }


}
