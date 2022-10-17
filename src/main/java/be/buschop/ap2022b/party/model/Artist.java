package be.buschop.ap2022b.party.model;

public class Artist {
    private int id;
    private String artistName;
    private String linkMoreInfo;
    private String genre;
    private String bio;
    private String portfolio;

    public Artist() {
    }

    public Artist(String artistName, String linkMoreInfo, String genre, String bio, String portfolio) {
    this.artistName = artistName;
    this.linkMoreInfo = linkMoreInfo;
    this.genre = genre;
    this.bio = bio;
    this.portfolio = portfolio;
    }

    public String getArtistName(){
        return artistName;
    }
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
    public String getLinkMoreInfo() {
        return linkMoreInfo;
    }
    public void setLinkMoreInfo(String linkMoreInfo) {
        this.linkMoreInfo = linkMoreInfo;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getPortfolio(){
        return portfolio;
    }
    public void setPortfolio(String portfolio) {
        this.portfolio = portfolio;
    }


}

