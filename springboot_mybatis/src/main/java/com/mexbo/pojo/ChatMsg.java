package com.mexbo.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "chat_msg")
public class ChatMsg {
    private String id;

    @Column(name = "send_user_id")
    private String sendUserId;

    @Column(name = "accept_user_id")
    private String acceptUserId;

    private String msg;

    /**
     * æ¶ˆæ¯æ˜¯å¦ç­¾æ”¶çŠ¶æ€
1ï¼šç­¾æ”¶
0ï¼šæœªç­¾æ”¶

     */
    @Column(name = "sign_flag")
    private Integer signFlag;

    /**
     * å‘é€è¯·æ±‚çš„äº‹ä»¶
     */
    @Column(name = "create_time")
    private Date createTime;

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
     * @return send_user_id
     */
    public String getSendUserId() {
        return sendUserId;
    }

    /**
     * @param sendUserId
     */
    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    /**
     * @return accept_user_id
     */
    public String getAcceptUserId() {
        return acceptUserId;
    }

    /**
     * @param acceptUserId
     */
    public void setAcceptUserId(String acceptUserId) {
        this.acceptUserId = acceptUserId;
    }

    /**
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取æ¶ˆæ¯æ˜¯å¦ç­¾æ”¶çŠ¶æ€
1ï¼šç­¾æ”¶
0ï¼šæœªç­¾æ”¶

     *
     * @return sign_flag - æ¶ˆæ¯æ˜¯å¦ç­¾æ”¶çŠ¶æ€
1ï¼šç­¾æ”¶
0ï¼šæœªç­¾æ”¶

     */
    public Integer getSignFlag() {
        return signFlag;
    }

    /**
     * 设置æ¶ˆæ¯æ˜¯å¦ç­¾æ”¶çŠ¶æ€
1ï¼šç­¾æ”¶
0ï¼šæœªç­¾æ”¶

     *
     * @param signFlag æ¶ˆæ¯æ˜¯å¦ç­¾æ”¶çŠ¶æ€
1ï¼šç­¾æ”¶
0ï¼šæœªç­¾æ”¶

     */
    public void setSignFlag(Integer signFlag) {
        this.signFlag = signFlag;
    }

    /**
     * 获取å‘é€è¯·æ±‚çš„äº‹ä»¶
     *
     * @return create_time - å‘é€è¯·æ±‚çš„äº‹ä»¶
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置å‘é€è¯·æ±‚çš„äº‹ä»¶
     *
     * @param createTime å‘é€è¯·æ±‚çš„äº‹ä»¶
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}