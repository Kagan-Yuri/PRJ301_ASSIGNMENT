/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author dv15312
 */
import java.sql.Timestamp;
import java.util.Date;
public class Request {
    private int id;
    private String title;
    private java.sql.Date fromDate;
    private java.sql.Date toDate;
    private String reason;
    private int createdBy;
    private java.sql.Timestamp createdAt;
    private String status; // INPROGRESS / APPROVED / REJECTED
    private Integer processedBy;
    private java.sql.Timestamp processedAt;
    private String processNote;

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

    public java.sql.Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(java.sql.Date fromDate) {
        this.fromDate = fromDate;
    }

    public java.sql.Date getToDate() {
        return toDate;
    }

    public void setToDate(java.sql.Date toDate) {
        this.toDate = toDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(Integer processedBy) {
        this.processedBy = processedBy;
    }

    public Timestamp getProcessedAt() {
        return processedAt;
    }

    public void setProcessedAt(Timestamp processedAt) {
        this.processedAt = processedAt;
    }

    public String getProcessNote() {
        return processNote;
    }

    public void setProcessNote(String processNote) {
        this.processNote = processNote;
    }

}
