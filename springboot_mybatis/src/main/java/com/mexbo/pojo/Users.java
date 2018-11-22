package com.mexbo.pojo;

import javax.persistence.*;

public class Users {
    private String id;

    /**
     * ç”¨æˆ·åï¼Œè´¦å·ï¼Œæ…•ä¿¡å·
     */
    private String username;

    /**
     * å¯†ç 
     */
    private String password;

    /**
     * æˆ‘çš„å¤´åƒï¼Œå¦‚æžœæ²¡æœ‰é»˜è®¤ç»™ä¸€å¼ 
     */
    @Column(name = "face_image")
    private String faceImage;

    @Column(name = "face_image_big")
    private String faceImageBig;

    /**
     * æ˜µç§°
     */
    private String nickname;

    /**
     * æ–°ç”¨æˆ·æ³¨å†ŒåŽé»˜è®¤åŽå°ç”ŸæˆäºŒç»´ç ï¼Œå¹¶ä¸”ä¸Šä¼ åˆ°fastdfs
     */
    private String qrcode;

    private String cid;

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
     * 获取ç”¨æˆ·åï¼Œè´¦å·ï¼Œæ…•ä¿¡å·
     *
     * @return username - ç”¨æˆ·åï¼Œè´¦å·ï¼Œæ…•ä¿¡å·
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置ç”¨æˆ·åï¼Œè´¦å·ï¼Œæ…•ä¿¡å·
     *
     * @param username ç”¨æˆ·åï¼Œè´¦å·ï¼Œæ…•ä¿¡å·
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取å¯†ç 
     *
     * @return password - å¯†ç 
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置å¯†ç 
     *
     * @param password å¯†ç 
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取æˆ‘çš„å¤´åƒï¼Œå¦‚æžœæ²¡æœ‰é»˜è®¤ç»™ä¸€å¼ 
     *
     * @return face_image - æˆ‘çš„å¤´åƒï¼Œå¦‚æžœæ²¡æœ‰é»˜è®¤ç»™ä¸€å¼ 
     */
    public String getFaceImage() {
        return faceImage;
    }

    /**
     * 设置æˆ‘çš„å¤´åƒï¼Œå¦‚æžœæ²¡æœ‰é»˜è®¤ç»™ä¸€å¼ 
     *
     * @param faceImage æˆ‘çš„å¤´åƒï¼Œå¦‚æžœæ²¡æœ‰é»˜è®¤ç»™ä¸€å¼ 
     */
    public void setFaceImage(String faceImage) {
        this.faceImage = faceImage;
    }

    /**
     * @return face_image_big
     */
    public String getFaceImageBig() {
        return faceImageBig;
    }

    /**
     * @param faceImageBig
     */
    public void setFaceImageBig(String faceImageBig) {
        this.faceImageBig = faceImageBig;
    }

    /**
     * 获取æ˜µç§°
     *
     * @return nickname - æ˜µç§°
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置æ˜µç§°
     *
     * @param nickname æ˜µç§°
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取æ–°ç”¨æˆ·æ³¨å†ŒåŽé»˜è®¤åŽå°ç”ŸæˆäºŒç»´ç ï¼Œå¹¶ä¸”ä¸Šä¼ åˆ°fastdfs
     *
     * @return qrcode - æ–°ç”¨æˆ·æ³¨å†ŒåŽé»˜è®¤åŽå°ç”ŸæˆäºŒç»´ç ï¼Œå¹¶ä¸”ä¸Šä¼ åˆ°fastdfs
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 设置æ–°ç”¨æˆ·æ³¨å†ŒåŽé»˜è®¤åŽå°ç”ŸæˆäºŒç»´ç ï¼Œå¹¶ä¸”ä¸Šä¼ åˆ°fastdfs
     *
     * @param qrcode æ–°ç”¨æˆ·æ³¨å†ŒåŽé»˜è®¤åŽå°ç”ŸæˆäºŒç»´ç ï¼Œå¹¶ä¸”ä¸Šä¼ åˆ°fastdfs
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * @return cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid
     */
    public void setCid(String cid) {
        this.cid = cid;
    }
}