/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dwr.simple;

/**
 *
 * @author Admin4DB2
 */
public class Poll {

     private String poll_title;
     private int votes_count;

     public String getPoll_title() {
          return poll_title;
     }

     public void setPoll_title(String poll_title) {
          this.poll_title = poll_title;
     }

     public int getVotes_count() {
          return votes_count;
     }

     public void setVotes_count(int votes_count) {
          this.votes_count = votes_count;
     }

}
