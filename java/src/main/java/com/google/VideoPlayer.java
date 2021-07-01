package com.google;

import java.util.Arrays;
import  java.util.Random;

public class VideoPlayer {

  private final VideoLibrary videoLibrary;

  public VideoPlayer() {
    this.videoLibrary = new VideoLibrary();
  }

  public void numberOfVideos() {
    System.out.printf("%s videos in the library%n", videoLibrary.getVideos().size());
  }

  public void showAllVideos() {
    String[] order = new String[videoLibrary.getVideos().size()];
    for (int i = 0; i < videoLibrary.getVideos().size(); i++) {
      order[i] = videoLibrary.getVideos().get(i).getTitle();
    }
    Arrays.sort(order);

    System.out.println("Here's a list of all available videos:");
    int vidIDRef = 0;
    for (int i = 0; i < videoLibrary.getVideos().size(); i++) {
      //Finding the video with matching title to the order
      for (int j = 0; j < videoLibrary.getVideos().size(); j++) {
        if (videoLibrary.getVideos().get(j).getTitle().equals(order[i])){
          vidIDRef = j;
        }
      }

      Video videoRef = videoLibrary.getVideos().get(vidIDRef);

      String tags = videoRef.getTags().toString();
      tags = tags.replaceAll(",","");

      System.out.println(videoRef.getTitle()+" ("+videoRef.getVideoId()+") "+tags);
    }
  }
  String currentVid = "na";
  public void playVideo(String videoId) {
    boolean videoMatch = false;
    for (int i = 0; i < videoLibrary.getVideos().size(); i++) {
     if (videoLibrary.getVideos().get(i).getVideoId().equals(videoId)){
       videoMatch = true;
       if(currentVid != "na") {
         System.out.println("Stopping video: " + currentVid);
       }
       currentVid = videoLibrary.getVideos().get(i).getTitle();
       System.out.println("Playing video: " + currentVid);
       break;

     }
    }
    if (!videoMatch){
      System.out.println("Cannot play video: Video does not exist");
    }

  }

  public void stopVideo() {
    if (currentVid != "na"){
    System.out.println("Stopping video: " + currentVid);
    currentVid ="na";
    }
    else{
      System.out.println("Cannot stop video: No video is currently playing");
    }
  }

  public void playRandomVideo() {
    Random rand = new Random();
    int randVid = rand.nextInt(videoLibrary.getVideos().size());
    String randomVid = videoLibrary.getVideos().get(randVid).getVideoId();
    playVideo(randomVid);
  }
private String pausedVid = "na";

  public void pauseVideo() {
    if (currentVid == "na"){
      System.out.println("Cannot pause video: No video is currently playing");
    }
    else if(currentVid == pausedVid){
      System.out.println("Video already paused: " + pausedVid);
    }
    else {
      System.out.println("Pausing video: " + currentVid);
      pausedVid = currentVid;
    }

  }
  public void continueVideo() {
    if (pausedVid == "na" && currentVid == "na"){
      System.out.println("Cannot continue video: No video is currently playing");
    }
    else if (pausedVid == "na" && currentVid !="na"){
      System.out.println("Cannot continue video: Video is not paused");
    }
    else{
      System.out.println("Continuing video: " + pausedVid);
    }
  }

  public void showPlaying() {

    int vidIDRef = 0;
    for (int j = 0; j < videoLibrary.getVideos().size(); j++) {
      if (videoLibrary.getVideos().get(j).getTitle().equals(currentVid)){
        vidIDRef = j;
      }
    }

    Video videoRef = videoLibrary.getVideos().get(vidIDRef);

    String tags = videoRef.getTags().toString();
    tags = tags.replaceAll(",","");


    if (currentVid == "na"){
      System.out.println("No video is currently playing");
    }
    else if(currentVid != "na" && currentVid != pausedVid){
      System.out.println("Currently playing: " + currentVid + " ("+videoRef.getVideoId()+") "+ tags );
    }
    else if (currentVid != "na" && currentVid == pausedVid){
      System.out.println("Currently playing: " + currentVid + " ("+videoRef.getVideoId()+") "+ tags  + " - PAUSED");
    }

  }

  public void createPlaylist(String playlistName) {
    System.out.println("createPlaylist needs implementation");
  }

  public void addVideoToPlaylist(String playlistName, String videoId) {
    System.out.println("addVideoToPlaylist needs implementation");
  }

  public void showAllPlaylists() {
    System.out.println("showAllPlaylists needs implementation");
  }

  public void showPlaylist(String playlistName) {
    System.out.println("showPlaylist needs implementation");
  }

  public void removeFromPlaylist(String playlistName, String videoId) {
    System.out.println("removeFromPlaylist needs implementation");
  }

  public void clearPlaylist(String playlistName) {
    System.out.println("clearPlaylist needs implementation");
  }

  public void deletePlaylist(String playlistName) {
    System.out.println("deletePlaylist needs implementation");
  }

  public void searchVideos(String searchTerm) {
    System.out.println("searchVideos needs implementation");
  }

  public void searchVideosWithTag(String videoTag) {
    System.out.println("searchVideosWithTag needs implementation");
  }

  public void flagVideo(String videoId) {
    System.out.println("flagVideo needs implementation");
  }

  public void flagVideo(String videoId, String reason) {
    System.out.println("flagVideo needs implementation");
  }

  public void allowVideo(String videoId) {
    System.out.println("allowVideo needs implementation");
  }
}