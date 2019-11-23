package lock.file.youtubeapi.model;

public class YouModelClass {
    public  String videoId,title,length;

    public YouModelClass() {
    }

    public YouModelClass(String videoId, String title, String length) {
        this.videoId = videoId;
        this.title = title;
        this.length = length;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
    @Override
    public String toString() {
        return "YoutubeVideoModel{" +
                "videoId='" + videoId + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + length + '\'' +
                '}';
    }
}
