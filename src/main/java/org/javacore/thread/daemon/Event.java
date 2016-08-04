package org.javacore.thread.daemon;

import java.util.Date;

/**
 * 事件类
 * 
 * @author taomk
 * @since 2016-8-4 
 */
public class Event {
	
    private Date date;
    private String event;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}
