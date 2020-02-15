package edu.itc.gic.m1.semester1.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "contributor")
public class Contributor {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "avatar_url")
    public String avatarUrl;
    public String login;

    /**
     * Default constructor for Database and any mapping libraries
     */
    public Contributor(){}

    @Ignore
    public Contributor(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public long getId() { return this.id; }
    public void setId(long id) { this.id = id; }
}
