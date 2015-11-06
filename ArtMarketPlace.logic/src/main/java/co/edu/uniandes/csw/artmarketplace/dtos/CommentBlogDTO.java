/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.dtos;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jh.rubiano10
 */
@XmlRootElement
public class CommentBlogDTO {
    private Long id;
    private String comment;
    private Calendar dateComment;
    private Long clientId;
    private Long blogId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Calendar getDateComment() {
        return dateComment;
    }

    public void setDateComment(Calendar dateComment) {
        this.dateComment = dateComment;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

      
}
