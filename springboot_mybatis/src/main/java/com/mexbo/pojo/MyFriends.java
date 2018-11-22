package com.mexbo.pojo;

import javax.persistence.*;

@Table(name = "my_friends")
public class MyFriends {
    private String id;

    /**
     * ç”¨æˆ·id
     */
    @Column(name = "my_user_id")
    private String myUserId;

    /**
     * ç”¨æˆ·çš„å¥½å‹id
     */
    @Column(name = "my_friend_user_id")
    private String myFriendUserId;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取ç”¨æˆ·id
     *
     * @return my_user_id - ç”¨æˆ·id
     */
    public String getMyUserId() {
        return myUserId;
    }

    /**
     * 设置ç”¨æˆ·id
     *
     * @param myUserId ç”¨æˆ·id
     */
    public void setMyUserId(String myUserId) {
        this.myUserId = myUserId;
    }

    /**
     * 获取ç”¨æˆ·çš„å¥½å‹id
     *
     * @return my_friend_user_id - ç”¨æˆ·çš„å¥½å‹id
     */
    public String getMyFriendUserId() {
        return myFriendUserId;
    }

    /**
     * 设置ç”¨æˆ·çš„å¥½å‹id
     *
     * @param myFriendUserId ç”¨æˆ·çš„å¥½å‹id
     */
    public void setMyFriendUserId(String myFriendUserId) {
        this.myFriendUserId = myFriendUserId;
    }
}