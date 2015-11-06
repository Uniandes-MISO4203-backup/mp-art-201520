/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.artmarketplace.entities;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jh.rubiano10
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Blog.getCommentBlog", query = "select u from CommentBlogEntity u WHERE u.blogId = :idBlog")
})
public class CommentBlogEntity implements Serializable {
    
    @Id
    @GeneratedValue(generator = "CommentBlog")
    private Long id;
    private String comment;
    
    @Temporal(TemporalType.DATE)
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
